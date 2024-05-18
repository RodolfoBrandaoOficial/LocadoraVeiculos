package com.rodolfobrandao.aulajavacollectionsproject.service.base;

import com.rodolfobrandao.aulajavacollectionsproject.models.advice.PaginatedResponse;
import com.rodolfobrandao.aulajavacollectionsproject.models.base.Modelo;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Component;
import com.rodolfobrandao.aulajavacollectionsproject.repositories.impl.CrudRepository;

import java.util.Map;

/**

 *

 *  @author @RodolfoBrandaoOficial.dev.br

 *  https://github.com/RodolfoBrandaoOficial

 *

 * DAO gerado automaticamente para a tabela modelo

 */

@Component

public class ModeloService implements CrudRepository<Modelo, Long> {

    private final JdbcClient jdbcClient;

    /**

     * Cria uma nova instância de ModeloService

     * @param jdbcClient O cliente JDBC

     */

    public ModeloService(JdbcClient jdbcClient) {

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
    public Modelo findById(Long id) {
        return CrudRepository.super.findById(id);
    }

    @Override
    public void save(Modelo entity) {
        CrudRepository.super.save(entity);
    }

    @Override
    public void update(Modelo entity, Integer id) {
        CrudRepository.super.update(entity, id);
    }

    @Override
    public void delete(Long id) {
        CrudRepository.super.delete(id);
    }

}
