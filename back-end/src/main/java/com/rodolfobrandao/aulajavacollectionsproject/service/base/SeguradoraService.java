package com.rodolfobrandao.aulajavacollectionsproject.service.base;

import com.rodolfobrandao.aulajavacollectionsproject.models.base.Seguradora;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Component;
import com.rodolfobrandao.aulajavacollectionsproject.repositories.impl.CrudRepository;

import java.util.List;

/**

 *   

 *  @author @RodolfoBrandaoOficial.dev.br 

 *  https://github.com/RodolfoBrandaoOficial 

 *  

 * DAO gerado automaticamente para a tabela seguradora

 */

@Component

public class SeguradoraService implements CrudRepository<Seguradora, Long> {

    private final JdbcClient jdbcClient;

    /**

     * Cria uma nova instância de SeguradoraService

     * @param jdbcClient O cliente JDBC

     */

    public SeguradoraService(JdbcClient jdbcClient) {

        this.jdbcClient = jdbcClient;

    }


    @Override
    public JdbcClient getConnection() {

        return jdbcClient;

    }

    @Override
    public List<Seguradora> findAll() {

        return CrudRepository.super.findAll();

    }

    @Override
    public Seguradora findById(Long id) {
        return CrudRepository.super.findById(id);
    }

    @Override
    public void save(Seguradora entity) {
        CrudRepository.super.save(entity);
    }

    @Override
    public void update(Seguradora entity, Integer id) {
        CrudRepository.super.update(entity, id);
    }

    @Override
    public void delete(Long id) {
        CrudRepository.super.delete(id);
    }

}
