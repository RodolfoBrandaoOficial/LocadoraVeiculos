package com.rodolfobrandao.aulajavacollectionsproject.service.base;

import com.rodolfobrandao.aulajavacollectionsproject.models.base.Seguradoratelefone;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Component;
import com.rodolfobrandao.aulajavacollectionsproject.repositories.impl.CrudRepository;

import java.util.List;

/**

 *   

 *  @author @RodolfoBrandaoOficial.dev.br 

 *  https://github.com/RodolfoBrandaoOficial 

 *  

 * DAO gerado automaticamente para a tabela seguradoratelefone

 */

@Component

public class SeguradoratelefoneService implements CrudRepository<Seguradoratelefone, Long> {

    private final JdbcClient jdbcClient;

    /**

     * Cria uma nova instância de SeguradoratelefoneService

     * @param jdbcClient O cliente JDBC

     */

    public SeguradoratelefoneService(JdbcClient jdbcClient) {

        this.jdbcClient = jdbcClient;

    }


    @Override
    public JdbcClient getConnection() {

        return jdbcClient;

    }

    @Override
    public List<Seguradoratelefone> findAll() {

        return CrudRepository.super.findAll();

    }

    @Override
    public Seguradoratelefone findById(Long id) {
        return CrudRepository.super.findById(id);
    }

    @Override
    public void save(Seguradoratelefone entity) {
        CrudRepository.super.save(entity);
    }

    @Override
    public void update(Seguradoratelefone entity, Integer id) {
        CrudRepository.super.update(entity, id);
    }

    @Override
    public void delete(Long id) {
        CrudRepository.super.delete(id);
    }

}
