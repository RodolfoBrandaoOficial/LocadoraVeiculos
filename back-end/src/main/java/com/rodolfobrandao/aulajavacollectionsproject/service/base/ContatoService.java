package com.rodolfobrandao.aulajavacollectionsproject.service.base;

import com.rodolfobrandao.aulajavacollectionsproject.models.advice.PaginatedResponse;
import com.rodolfobrandao.aulajavacollectionsproject.models.base.Contato;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Component;
import com.rodolfobrandao.aulajavacollectionsproject.repositories.impl.CrudRepository;

import java.util.Map;

/**

 *

 *  @author @RodolfoBrandaoOficial.dev.br

 *  https://github.com/RodolfoBrandaoOficial

 *

 * DAO gerado automaticamente para a tabela contato

 */

@Component

public class ContatoService implements CrudRepository<Contato, Long> {

    private final JdbcClient jdbcClient;

    /**

     * Cria uma nova instância de ContatoService

     * @param jdbcClient O cliente JDBC

     */

    public ContatoService(JdbcClient jdbcClient) {

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
    public Contato findById(Long id) {
        return CrudRepository.super.findById(id);
    }

    @Override
    public void save(Contato entity) {
        CrudRepository.super.save(entity);
    }

    @Override
    public void update(Contato entity, Integer id) {
        CrudRepository.super.update(entity, id);
    }

    @Override
    public void delete(Long id) {
        CrudRepository.super.delete(id);
    }

}
