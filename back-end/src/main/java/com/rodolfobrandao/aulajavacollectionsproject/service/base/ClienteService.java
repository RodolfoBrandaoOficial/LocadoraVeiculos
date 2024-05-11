package com.rodolfobrandao.aulajavacollectionsproject.service.base;

import com.rodolfobrandao.aulajavacollectionsproject.models.base.Cliente;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Component;
import com.rodolfobrandao.aulajavacollectionsproject.repositories.impl.CrudRepository;

import java.util.List;

/**

 *   

 *  @author @RodolfoBrandaoOficial.dev.br 

 *  https://github.com/RodolfoBrandaoOficial 

 *  

 * DAO gerado automaticamente para a tabela cliente

 */

@Component

public class ClienteService implements CrudRepository<Cliente, Long> {

    private final JdbcClient jdbcClient;

    /**

     * Cria uma nova instância de ClienteService

     * @param jdbcClient O cliente JDBC

     */

    public ClienteService(JdbcClient jdbcClient) {

        this.jdbcClient = jdbcClient;

    }


    @Override
    public JdbcClient getConnection() {

        return jdbcClient;

    }

    @Override
    public List<Cliente> findAll() {

        return CrudRepository.super.findAll();

    }

    @Override
    public Cliente findById(Long id) {
        return CrudRepository.super.findById(id);
    }

    @Override
    public void save(Cliente entity) {
        CrudRepository.super.save(entity);
    }

    @Override
    public void update(Cliente entity, Integer id) {
        CrudRepository.super.update(entity, id);
    }

    @Override
    public void delete(Long id) {
        CrudRepository.super.delete(id);
    }

}
