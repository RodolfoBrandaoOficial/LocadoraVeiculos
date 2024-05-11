package com.rodolfobrandao.aulajavacollectionsproject.service.base;

import com.rodolfobrandao.aulajavacollectionsproject.models.base.Estado;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Component;
import com.rodolfobrandao.aulajavacollectionsproject.repositories.impl.CrudRepository;

import java.util.List;

/**

 *   

 *  @author @RodolfoBrandaoOficial.dev.br 

 *  https://github.com/RodolfoBrandaoOficial 

 *  

 * DAO gerado automaticamente para a tabela estado

 */

@Component

public class EstadoService implements CrudRepository<Estado, Long> {

    private final JdbcClient jdbcClient;

    /**

     * Cria uma nova instância de EstadoService

     * @param jdbcClient O cliente JDBC

     */

    public EstadoService(JdbcClient jdbcClient) {

        this.jdbcClient = jdbcClient;

    }


    @Override
    public JdbcClient getConnection() {

        return jdbcClient;

    }

    @Override
    public List<Estado> findAll() {

        return CrudRepository.super.findAll();

    }

    @Override
    public Estado findById(Long id) {
        return CrudRepository.super.findById(id);
    }

    @Override
    public void save(Estado entity) {
        CrudRepository.super.save(entity);
    }

    @Override
    public void update(Estado entity, Integer id) {
        CrudRepository.super.update(entity,id);
    }

    @Override
    public void delete(Long id) {
        CrudRepository.super.delete(id);
    }

}
