package com.rodolfobrandao.aulajavacollectionsproject.repositories.impl;

import org.springframework.jdbc.core.simple.JdbcClient;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

public interface CrudRepository<ENTITY, ID_TYPE> {


    //    JdbcClient getConnection();
//
//
//
//// Devera criar no arquivo do DAO
////    private final JdbcClient jdbcClient;
////
////    public FabricanteService(JdbcClient jdbcClient) {
////        this.jdbcClient = jdbcClient;
////    }
////
////    @Override
////    public JdbcClient getConnection() {
////        return jdbcClient;
////    }

    default List<ENTITY> findAll(){
        JdbcClient jdbcClient = getConnection();
        Class<ENTITY> entityClass = getEntityClass();
        String tableName = entityClass.getSimpleName().toLowerCase();
        String sql = "SELECT * FROM " + tableName;

        return jdbcClient
                .sql(sql)
                .query(entityClass)
                .list();
    }

    /**
     * Recupera uma entidade do banco de dados pelo seu identificador único.
     *
     * @param id O identificador único da entidade a ser recuperada.
     * @return A entidade correspondente ao identificador especificado, ou null se não for encontrada.
     */
    default ENTITY findById(ID_TYPE id) {
        JdbcClient jdbcClient = getConnection();
        Class<ENTITY> entityClass = getEntityClass();
        String tableName = entityClass.getSimpleName().toLowerCase();
        String sql = "SELECT * FROM " + tableName + " WHERE id = :id";

        if(id == null) {
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
     * @param entity A entidade a ser salva no banco de dados.
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
        for (int i = 0; i <= values.size(); i++) {
            if (!fields[i].getName().equals("id")) {
                String fieldName = fields[i].getName();
                sqlBuilder.append(fieldName)
                        .append(", ");
            }
        }

        sqlBuilder.setLength(sqlBuilder.length() - 2);
        sqlBuilder.append(") VALUES (");

        for (int i = 0; i <= values.size(); i++) {
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
     * @param entity A entidade a ser atualizada no banco de dados.
     * @param id
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
     * Exclui uma entidade do banco de dados com base no seu identificador único.
     *
     * @param id O identificador único da entidade a ser excluída do banco de dados.
     */
    default void delete(ID_TYPE id){
        JdbcClient jdbcClient = getConnection();
        Class<ENTITY> entityClass = getEntityClass();
        String tableName = entityClass.getSimpleName().toLowerCase();
        String sql = "DELETE FROM " + tableName + " WHERE id = :id";

        jdbcClient.sql(sql)
                .param("id", id)
                .update();
    }

    /**
     * Obtém o cliente JDBC usado para executar operações no banco de dados.
     *
     * @return A conexão com o banco de dados usada pelo jdbcClient.
     */
    JdbcClient getConnection();

    /**
     * Obtém a classe da entidade.
     *
     * @return A classe da entidade.
     */
    @SuppressWarnings("unchecked")
    private Class<ENTITY> getEntityClass() {
        ParameterizedType type = (ParameterizedType) getClass().getGenericInterfaces()[0];
        return (Class<ENTITY>) type.getActualTypeArguments()[0];
    }

    /**
     * Obtém os valores para inserção de uma entidade no banco de dados.
     *
     * @return Uma lista contendo os valores a serem inseridos.
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
     * Obtém os valores para atualização de uma entidade no banco de dados.
     *
     * @return Uma lista contendo os valores a serem atualizados.
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
}






//package com.rodolfobrandao.aulajavacollectionsproject.repositories.impl;
//
//import org.springframework.jdbc.core.simple.JdbcClient;
//
//import java.lang.reflect.Field;
//import java.lang.reflect.ParameterizedType;
//import java.util.ArrayList;
//import java.util.List;
//
//public interface CrudRepository<ENTITY, ID_TYPE> {
//
//
//    default List<ENTITY> findAll(){
//        JdbcClient jdbcClient = getConnection();
//        Class<ENTITY> entityClass = getEntityClass();
//        String tableName = entityClass.getSimpleName().toLowerCase();
//        String sql = "SELECT * FROM " + tableName;
//
//        return jdbcClient
//                .sql(sql)
//                .query(entityClass)
//                .list();
//    }
//
//    /**
//     * Recupera uma entidade do banco de dados pelo seu identificador único.
//     *
//     * @param id O identificador único da entidade a ser recuperada.
//     * @return A entidade correspondente ao identificador especificado, ou null se não for encontrada.
//     */
//    default ENTITY findById(ID_TYPE id) {
//        JdbcClient jdbcClient = getConnection();
//        Class<ENTITY> entityClass = getEntityClass();
//        String tableName = entityClass.getSimpleName().toLowerCase();
//        String sql = "SELECT * FROM " + tableName + " WHERE id = :id";
//
//        return jdbcClient
//                .sql(sql)
//                .param("id", id)
//                .query(entityClass)
//                .single();
//    }
//
//    /**
//     * Salva uma nova entidade no banco de dados.
//     *
//     * @param entity A entidade a ser salva no banco de dados.
//     */
//    default void save(ENTITY entity) {
//        JdbcClient jdbcClient = getConnection();
//        String tableName = entity.getClass().getSimpleName().toLowerCase();
//        List<Object> values = getSaveValues(entity);
//
//        StringBuilder sqlBuilder = new StringBuilder();
//        sqlBuilder.append("INSERT INTO ")
//                .append(tableName)
//                .append(" (");
//
//        Field[] fields = entity.getClass().getDeclaredFields();
//        for (int i = 0; i <= values.size(); i++) {
//            if (!fields[i].getName().equals("id")) {
//                String fieldName = fields[i].getName();
//                sqlBuilder.append(fieldName)
//                        .append(", ");
//            }
//        }
//
//        sqlBuilder.setLength(sqlBuilder.length() - 2);
//        sqlBuilder.append(") VALUES (");
//
//        for (int i = 0; i <= values.size(); i++) {
//            if (!fields[i].getName().equals("id")) {
//                sqlBuilder.append("?, ");
//            }
//        }
//
//        sqlBuilder.setLength(sqlBuilder.length() - 2);
//        sqlBuilder.append(")");
//        String sql = sqlBuilder.toString();
//
//        jdbcClient.sql(sql)
//                .params(values)
//                .update();
//    }
//
//    /**
//     * Atualiza uma entidade existente no banco de dados.
//     *
//     * @param entity A entidade a ser atualizada no banco de dados.
//     * @param id
//     */
//    default void update(ENTITY entity, Integer id) {
//        JdbcClient jdbcClient = getConnection();
//        String tableName = entity.getClass().getSimpleName().toLowerCase();
//        List<Object> values = getUpdateValues(entity);
//
//        StringBuilder sqlBuilder = new StringBuilder();
//        sqlBuilder.append("UPDATE ")
//                .append(tableName)
//                .append(" SET ");
//
//        Field[] fields = entity.getClass().getDeclaredFields();
//        for (int i = 0; i < values.size(); i++) {
//            if (!fields[i].getName().equals("id")) {
//                String fieldName = fields[i].getName();
//                sqlBuilder.append(fieldName)
//                        .append(" = ?, ");
//            }
//        }
//
//        sqlBuilder.setLength(sqlBuilder.length() - 2);
//        sqlBuilder.append(" WHERE id = ?");
//        String sql = sqlBuilder.toString();
//
//        jdbcClient.sql(sql)
//                .params(values)
//                .update();
//    }
//
//    /**
//     * Exclui uma entidade do banco de dados com base no seu identificador único.
//     *
//     * @param id O identificador único da entidade a ser excluída do banco de dados.
//     */
//    default void delete(ID_TYPE id){
//        JdbcClient jdbcClient = getConnection();
//        Class<ENTITY> entityClass = getEntityClass();
//        String tableName = entityClass.getSimpleName().toLowerCase();
//        String sql = "DELETE FROM " + tableName + " WHERE id = :id";
//
//        jdbcClient.sql(sql)
//                .param("id", id)
//                .update();
//    }
//
//    /**
//     * Obtém o cliente JDBC usado para executar operações no banco de dados.
//     *
//     * @return A conexão com o banco de dados usada pelo jdbcClient.
//     */
//    JdbcClient getConnection();
//
//    /**
//     * Obtém a classe da entidade.
//     *
//     * @return A classe da entidade.
//     */
//    @SuppressWarnings("unchecked")
//    private Class<ENTITY> getEntityClass() {
//        ParameterizedType type = (ParameterizedType) getClass().getGenericInterfaces()[0];
//        return (Class<ENTITY>) type.getActualTypeArguments()[0];
//    }
//
//    /**
//     * Obtém os valores para inserção de uma entidade no banco de dados.
//     *
//     * @return Uma lista contendo os valores a serem inseridos.
//     */
//    private List<Object> getSaveValues(ENTITY entity) {
//        List<Object> values = new ArrayList<>();
//        Field[] fields = entity.getClass().getDeclaredFields();
//
//        for (Field field : fields) {
//            String fieldName = field.getName();
//            if (!fieldName.equals("id")) {
//                try {
//                    field.setAccessible(true);
//                    Object value = field.get(entity);
//                    values.add(value);
//                } catch (IllegalAccessException e) {
//                    throw new RuntimeException(e.getMessage());
//                }
//            }
//        }
//        return values;
//    }
//
//    /**
//     * Obtém os valores para atualização de uma entidade no banco de dados.
//     *
//     * @return Uma lista contendo os valores a serem atualizados.
//     */
//    private List<Object> getUpdateValues(ENTITY entity) {
//        List<Object> values = getSaveValues(entity);
//        try {
//            Field idField = getEntityClass().getDeclaredField("id");
//            idField.setAccessible(true);
//            Object id = idField.get(entity);
//            values.add(id);
//        } catch (NoSuchFieldException | IllegalAccessException e) {
//            throw new RuntimeException(e.getMessage());
//        }
//        return values;
//    }
//}







//package com.rodolfobrandao.aulajavacollectionsproject.repositories.impl;
//
//import org.springframework.jdbc.core.simple.JdbcClient;
//
//import java.lang.reflect.Field;
//import java.lang.reflect.ParameterizedType;
//import java.util.ArrayList;
//import java.util.List;
//
//public interface CrudRepository<ENTITY, ID_TYPE> {
//
//    JdbcClient getConnection();
//
//
//
//// Devera criar no arquivo do DAO
////    private final JdbcClient jdbcClient;
////
////    public FabricanteService(JdbcClient jdbcClient) {
////        this.jdbcClient = jdbcClient;
////    }
////
////    @Override
////    public JdbcClient getConnection() {
////        return jdbcClient;
////    }
//
//
//
//    default List<ENTITY> findAll() {
//        JdbcClient jdbcClient = getConnection();
//        Class<ENTITY> entityClass = getEntityClass();
//        String tableName = entityClass.getSimpleName().toLowerCase();
//        String sql = "SELECT * FROM " + tableName;
//
//        return jdbcClient
//                .sql(sql)
//                .query(entityClass)
//                .list();
//    }
//
//    default ENTITY findById(ID_TYPE id) {
//        JdbcClient jdbcClient = getConnection();
//        Class<ENTITY> entityClass = getEntityClass();
//        String tableName = entityClass.getSimpleName().toLowerCase();
//        String sql = "SELECT * FROM " + tableName + " WHERE id = :id";
//
//        return jdbcClient
//                .sql(sql)
//                .param("id", id)
//                .query(entityClass)
//                .single();
//    }
//
//    default void save(ENTITY entity) {
//        JdbcClient jdbcClient = getConnection();
//        String tableName = entity.getClass().getSimpleName().toLowerCase();
//        List<Object> values = getValues(entity);
//
//        String sql = "INSERT INTO " + tableName + " (";
//        String fields = getFields(entity);
//        String placeholders = getPlaceholders(entity);
//
//        sql += fields + ") VALUES (" + placeholders + ")";
//
//        jdbcClient.sql(sql)
//                .params(values)
//                .update();
//    }
//
//    default void update(ENTITY entity) {
//        JdbcClient jdbcClient = getConnection();
//        String tableName = entity.getClass().getSimpleName().toLowerCase();
//        List<Object> values = getValues(entity);
//
//        String sql = "UPDATE " + tableName + " SET ";
//        String fields = getFields(entity);
//
//        sql += fields + " WHERE id = ?";
//
//        values.add(getId(entity));
//
//        jdbcClient.sql(sql)
//                .params(values)
//                .update();
//    }
//
//    default void delete(ID_TYPE id) {
//        JdbcClient jdbcClient = getConnection();
//        Class<ENTITY> entityClass = getEntityClass();
//        String tableName = entityClass.getSimpleName().toLowerCase();
//        String sql = "DELETE FROM " + tableName + " WHERE id = :id";
//
//        jdbcClient.sql(sql)
//                .param("id", id)
//                .update();
//    }
//
//    @SuppressWarnings("unchecked")
//    private Class<ENTITY> getEntityClass() {
//        ParameterizedType type = (ParameterizedType) getClass().getGenericInterfaces()[0];
//        return (Class<ENTITY>) type.getActualTypeArguments()[0];
//    }
//
//    private List<Object> getValues(ENTITY entity) {
//        List<Object> values = new ArrayList<>();
//        Field[] fields = entity.getClass().getDeclaredFields();
//
//        for (Field field : fields) {
//            field.setAccessible(true);
//            try {
//                values.add(field.get(entity));
//            } catch (IllegalAccessException e) {
//                throw new RuntimeException("Error getting field value: " + e.getMessage());
//            }
//        }
//        return values;
//    }
//
//    private String getFields(ENTITY entity) {
//        Field[] fields = entity.getClass().getDeclaredFields();
//        StringBuilder fieldNames = new StringBuilder();
//        for (Field field : fields) {
//            if (!field.getName().equals("id")) {
//                fieldNames.append(field.getName()).append(", ");
//            }
//        }
//        return fieldNames.substring(0, fieldNames.length() - 2);
//    }
//
//    private String getPlaceholders(ENTITY entity) {
//        Field[] fields = entity.getClass().getDeclaredFields();
//        StringBuilder placeholders = new StringBuilder();
//        for (Field ignored : fields) {
//            placeholders.append("?, ");
//        }
//        return placeholders.substring(0, placeholders.length() - 2);
//    }
//
//    private ID_TYPE getId(ENTITY entity) {
//        try {
//            Field idField = entity.getClass().getDeclaredField("id");
//            idField.setAccessible(true);
//            return (ID_TYPE) idField.get(entity);
//        } catch (NoSuchFieldException | IllegalAccessException e) {
//            throw new RuntimeException("Error getting ID field value: " + e.getMessage());
//        }
//    }
//}
