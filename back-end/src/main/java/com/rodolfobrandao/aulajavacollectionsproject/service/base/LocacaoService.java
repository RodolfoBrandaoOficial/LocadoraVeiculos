package com.rodolfobrandao.aulajavacollectionsproject.service.base;

import com.rodolfobrandao.aulajavacollectionsproject.models.advice.PaginatedResponse;
import com.rodolfobrandao.aulajavacollectionsproject.models.base.Locacao;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Component;
import com.rodolfobrandao.aulajavacollectionsproject.repositories.impl.CrudRepository;

import java.util.Map;

/**

 *

 *  @author @RodolfoBrandaoOficial.dev.br

 *  https://github.com/RodolfoBrandaoOficial

 *

 * DAO gerado automaticamente para a tabela locacao

 */

@Component

public class LocacaoService implements CrudRepository<Locacao, Long> {

    private final JdbcClient jdbcClient;

    /**

     * Cria uma nova instância de LocacaoService

     * @param jdbcClient O cliente JDBC

     */

    public LocacaoService(JdbcClient jdbcClient) {

        this.jdbcClient = jdbcClient;

    }


    @Override
    public JdbcClient getConnection() {

        return jdbcClient;

    }

    @Override
    public PaginatedResponse<Map<String, Object>> findAll() {

        return CrudRepository.super.findAll();

    }

    @Override
    public Locacao findById(Long id) {
        return CrudRepository.super.findById(id);
    }

    @Override
    public void save(Locacao entity) {
        CrudRepository.super.save(entity);
    }

    @Override
    public void update(Locacao entity, Integer id) {
        CrudRepository.super.update(entity, id);
    }

    @Override
    public void delete(Long id) {
        CrudRepository.super.delete(id);
    }


    @Override
    public PaginatedResponse<Locacao> findByQuery(String qtype, String query, String oper, String page, String rp, String grid_param, String sortname, String sortorder) {
        CrudRepository.super.findByQuery(qtype, query, oper, page, rp, grid_param, sortname, sortorder);
        return CrudRepository.super.findByQuery(qtype, query, oper, page, rp, grid_param, sortname, sortorder);
    }



//    @Override
//    public List<Locacao> findByQueryGeneric(String qtype, String query, String oper, String page, String rp, String grid_param, String sortname, String sortorder) {
//        try {
//            if (qtype == null || qtype.isEmpty() || query == null || query.isEmpty() || oper == null || oper.isEmpty()) {
//                return Collections.emptyList();
//            }
//            if (grid_param != null && !grid_param.isEmpty()) {
//                String[] gridParams = grid_param.split("/");
//                if (gridParams.length == 2) {
//                    qtype = gridParams[0];
//                    query = gridParams[1];
//                }
//            }
//            int offset = (Integer.parseInt(page) - 1) * Integer.parseInt(rp);
//            String sql = "SELECT * FROM locacao WHERE " + qtype + " " + oper + " ? ORDER BY " + sortname + " " + sortorder + " OFFSET ? LIMIT ?";
//            // Imprimir o SQL gerado no console
//            System.out.println("SQL gerado: " + sql);
//            Object queryValue = ("id".equals(qtype)) ? Integer.parseInt(query) : query;
//            return jdbcClient.sql(sql).params(queryValue, offset, Integer.parseInt(rp)).query(Locacao.class).list();
//        } catch (NumberFormatException | NullPointerException e) {
//            e.printStackTrace();
//            return Collections.emptyList();
//        }
//    }
}
