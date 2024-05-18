package com.rodolfobrandao.aulajavacollectionsproject.repositories.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rodolfobrandao.aulajavacollectionsproject.models.advice.PaginatedResponse;
import jakarta.persistence.JoinColumn;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;



import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Interface genérica para operações CRUD em um banco de dados usando Spring JDBC.
 *
 * @param <ENTITY>  O tipo de entidade a ser manipulado pelo repositório.
 * @param <ID_TYPE> O tipo de identificador usado pela entidade.
 */
public interface CrudRepository<ENTITY, ID_TYPE> {



    /**
     * Recupera todas as entidades da tabela correspondente.
     *
     * @return Um PaginatedResponse contendo todas as entidades na tabela.
     */
    default PaginatedResponse<Map<String, Object>> findAll() {
        JdbcClient jdbcClient = getConnection();
        Class<ENTITY> entityClass = getEntityClass();
        String tableName = entityClass.getSimpleName().toLowerCase();
        String sql = "SELECT * FROM " + tableName;

        // Query para obter os resultados
        List<ENTITY> entities = jdbcClient
                .sql(sql)
                .query(entityClass)
                .list();

        // Mapeia cada entidade para um mapa de campos e valores
        List<Map<String, Object>> registros = new ArrayList<>();
        for (ENTITY entity : entities) {
            registros.add(mapEntityToMap(entity));
        }

        PaginatedResponse<Map<String, Object>> response = new PaginatedResponse<>();
        response.setPage("0"); // Define a página como 0 por padrão
        response.setTotal(countTotalRecords()); // Define o total de registros
        response.setRegistros(registros);
        return response;
    }

    //TODO: Implementar paginação REVISAR ESTÁTICAMENTE
    private Map<String, Object> mapEntityToMap(ENTITY entity) {
        Map<String, Object> entityMap = new HashMap<>();
        Field[] fields = entity.getClass().getDeclaredFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(entity);

                // Se o campo for uma chave estrangeira, mapeie os dados da entidade relacionada
                if (field.isAnnotationPresent(JoinColumn.class)) {
                    // Recupera os dados da chave estrangeira e inclui no mapa
                    String foreignKeyId = (String) value;
                    String foreignKeyTable = field.getAnnotation(JoinColumn.class).table();
                    String foreignKeySql = "SELECT * FROM " + foreignKeyTable + " WHERE id = ?";
                    Map<String, Object> foreignKeyData = getConnection()
                            .sql(foreignKeySql)
                            .param("id", foreignKeyId)
                            .query(new RowMapper<Map<String, Object>>() {
                                @Override
                                public Map<String, Object> mapRow(ResultSet rs, int rowNum) throws SQLException {
                                    ResultSetMetaData metaData = rs.getMetaData();
                                    int columnCount = metaData.getColumnCount();
                                    Map<String, Object> map = new HashMap<>(columnCount);
                                    for (int i = 1; i <= columnCount; i++) {
                                        String key = metaData.getColumnLabel(i);
                                        Object value = rs.getObject(i);
                                        map.put(key, value);
                                    }
                                    return map;
                                }
                            })
                            .single();
                    entityMap.put(field.getName(), foreignKeyData);
                } else {
                    // Se não for uma chave estrangeira, apenas coloque o valor no mapa
                    entityMap.put(field.getName(), value);
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
        return entityMap;
    }





    /**
     * Encontra uma entidade pelo seu ID.
     *
     * @param id O ID da entidade a ser encontrada.
     * @return A entidade correspondente ao ID especificado.
     */
    default ENTITY findById(ID_TYPE id) {
        JdbcClient jdbcClient = getConnection();
        Class<ENTITY> entityClass = getEntityClass();
        String tableName = entityClass.getSimpleName().toLowerCase();
        String sql = "SELECT * FROM " + tableName + " WHERE id = :id";

        if (id == null) {
            throw new UnsupportedOperationException();
        }

        return jdbcClient
                .sql(sql)
                .param("id", id)
                .query(entityClass)
                .single();
    }

    /**
     * Salva uma nova entidade no banco de dados.
     *
     * @param entity A entidade a ser salva.
     */
    default void save(ENTITY entity) {
        JdbcClient jdbcClient = getConnection();
        String tableName = entity.getClass().getSimpleName().toLowerCase();
        List<Object> values = getSaveValues(entity);

        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("INSERT INTO ")
                .append(tableName)
                .append(" (");

        Field[] fields = entity.getClass().getDeclaredFields();
        for (int i = 0; i < values.size(); i++) {
            if (!fields[i].getName().equals("id")) {
                String fieldName = fields[i].getName();
                sqlBuilder.append(fieldName)
                        .append(", ");
            }
        }

        sqlBuilder.setLength(sqlBuilder.length() - 2);
        sqlBuilder.append(") VALUES (");

        for (int i = 0; i < values.size(); i++) {
            if (!fields[i].getName().equals("id")) {
                sqlBuilder.append("?, ");
            }
        }

        sqlBuilder.setLength(sqlBuilder.length() - 2);
        sqlBuilder.append(")");
        String sql = sqlBuilder.toString();

        jdbcClient.sql(sql)
                .params(values)
                .update();
    }

    /**
     * Atualiza uma entidade existente no banco de dados.
     *
     * @param entity A entidade a ser atualizada.
     * @param id     O ID da entidade a ser atualizada.
     */
    default void update(ENTITY entity, Integer id) {
        JdbcClient jdbcClient = getConnection();
        String tableName = entity.getClass().getSimpleName().toLowerCase();
        List<Object> values = getUpdateValues(entity);

        StringBuilder sqlBuilder = new StringBuilder();
        sqlBuilder.append("UPDATE ")
                .append(tableName)
                .append(" SET ");

        Field[] fields = entity.getClass().getDeclaredFields();
        for (int i = 0; i < values.size(); i++) {
            if (!fields[i].getName().equals("id")) {
                String fieldName = fields[i].getName();
                sqlBuilder.append(fieldName)
                        .append(" = ?, ");
            }
        }

        sqlBuilder.setLength(sqlBuilder.length() - 2);
        sqlBuilder.append(" WHERE id = ?");
        String sql = sqlBuilder.toString();

        jdbcClient.sql(sql)
                .params(values)
                .update();
    }

    /**
     * Exclui uma entidade do banco de dados com base no seu ID.
     *
     * @param id O ID da entidade a ser excluída.
     */
    default void delete(ID_TYPE id) {
        JdbcClient jdbcClient = getConnection();
        Class<ENTITY> entityClass = getEntityClass();
        String tableName = entityClass.getSimpleName().toLowerCase();
        String sql = "DELETE FROM " + tableName + " WHERE id = :id";

        jdbcClient.sql(sql)
                .param("id", id)
                .update();
    }

    /**
     * Retorna a conexão JDBC para execução de consultas SQL.
     *
     * @return A conexão JDBC.
     */
    JdbcClient getConnection();

    /**
     * Retorna a classe da entidade associada ao repositório.
     *
     * @return A classe da entidade.
     */
    @SuppressWarnings("unchecked")
    private Class<ENTITY> getEntityClass() {
        ParameterizedType type = (ParameterizedType) getClass().getGenericInterfaces()[0];
        return (Class<ENTITY>) type.getActualTypeArguments()[0];
    }

    /**
     * Retorna uma lista de valores a serem usados na inserção de uma entidade.
     *
     * @param entity A entidade para a qual os valores estão sendo obtidos.
     * @return Uma lista de valores a serem usados na inserção.
     */
    private List<Object> getSaveValues(ENTITY entity) {
        List<Object> values = new ArrayList<>();
        Field[] fields = entity.getClass().getDeclaredFields();

        for (Field field : fields) {
            String fieldName = field.getName();
            if (!fieldName.equals("id")) {
                try {
                    field.setAccessible(true);
                    Object value = field.get(entity);
                    values.add(value);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e.getMessage());
                }
            }
        }
        return values;
    }

    /**
     * Retorna uma lista de valores a serem usados na atualização de uma entidade.
     *
     * @param entity A entidade para a qual os valores estão sendo obtidos.
     * @return Uma lista de valores a serem usados na atualização.
     */
    private List<Object> getUpdateValues(ENTITY entity) {
        List<Object> values = getSaveValues(entity);
        try {
            Field idField = getEntityClass().getDeclaredField("id");
            idField.setAccessible(true);
            Object id = idField.get(entity);
            values.add(id);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e.getMessage());
        }
        return values;
    }

    /**
     * Busca entidades com base em uma consulta personalizada.
     *
     * @param qtype      O tipo de campo a ser usado na consulta (ex: id, name, etc.).
     * @param query      O valor do campo para comparar na consulta.
     * @param oper       O operador de comparação (ex: =, >, <, etc.).
     * @param page       O número da página para paginação.
     * @param rp         O número de registros por página.
     * @param grid_param Parâmetro adicional para consulta (opcional).
     * @param sortname   O nome do campo para ordenação.
     * @param sortorder  A ordem de classificação (ascendente ou descendente).
     * @return Uma lista de entidades que correspondem à consulta.
     */
    //TODO: Implementar paginação REVISAR ESTÁTICAMENTE
    default PaginatedResponse<ENTITY> findByQuery(String qtype, String query, String oper, String page, String rp, String grid_param, String sortname, String sortorder) {
        PaginatedResponse<ENTITY> response = new PaginatedResponse<>();
        try {
            // Verifica se os parâmetros obrigatórios estão presentes
            if (qtype == null || qtype.isEmpty() || query == null || query.isEmpty() || oper == null || oper.isEmpty()) {
                response.setRegistros(Collections.emptyList());
                return response;
            }

            // Analisa os critérios de filtro do grid_param, se fornecido
            Map<String, String> filterCriteria = new HashMap<>();
            if (grid_param != null && !grid_param.isEmpty()) {
                ObjectMapper objectMapper = new ObjectMapper();
                JsonNode rootNode = objectMapper.readTree(grid_param);
                rootNode.fields().forEachRemaining(entry -> filterCriteria.put(entry.getKey(), entry.getValue().asText()));
            }

            // Constrói a cláusula WHERE da consulta SQL com base nos critérios de filtro
            StringBuilder whereClause = new StringBuilder();
            List<Object> params = new ArrayList<>();
            filterCriteria.forEach((key, value) -> {
                if (whereClause.length() > 0) whereClause.append(" AND ");
                whereClause.append(key).append(" = ?");
                params.add(value);
            });

            // Calcula o deslocamento para a paginação
            int offset = (Integer.parseInt(page) - 1) * Integer.parseInt(rp);

            // Constrói a consulta SQL
            StringBuilder sqlBuilder = new StringBuilder("SELECT * FROM ").append(getTableName()).append(" WHERE 1=1");
            if (whereClause.length() > 0) sqlBuilder.append(" AND ").append(whereClause);
            sqlBuilder.append(" AND ").append(qtype).append(" ").append(oper).append(" ? ORDER BY ").append(sortname).append(" ").append(sortorder).append(" OFFSET ? LIMIT ?");

            // Adiciona os parâmetros adicionais à lista de parâmetros
            params.add(Integer.parseInt(query));
            params.add(offset);
            params.add(Integer.parseInt(rp));

            // Executa a consulta SQL e retorna os resultados paginados
            List<ENTITY> resultList = getConnection()
                    .sql(sqlBuilder.toString())
                    .params(params.toArray())
                    .query(getEntityClass())
                    .list();

            // Define os resultados e a página na resposta paginada
            response.setRegistros(resultList);
            response.setPage(page);
            response.setTotal(resultList.size());
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
            response.setRegistros(Collections.emptyList());
        }
        return response;
    }

    /**
     * Retorna o nome da tabela associada à entidade.
     *
     * @return O nome da tabela.
     */
    default String getTableName() {
        return getEntityClass().getSimpleName().toLowerCase();
    }

    /**
     * Método abstrato para contar o número total de registros na tabela.
     *
     * @return O número total de registros na tabela.
     */

    default int countTotalRecords() {
        JdbcClient jdbcClient = getConnection();
        String tableName = getTableName();
        String sql = "SELECT COUNT(*) FROM " + tableName;

        Integer count = jdbcClient
                .sql(sql)
                .query(Integer.class)
                .single();
        return count != null ? count : 0;

    }
}
