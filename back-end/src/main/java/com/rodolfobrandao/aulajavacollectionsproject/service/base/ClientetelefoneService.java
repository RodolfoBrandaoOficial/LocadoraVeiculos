package com.rodolfobrandao.aulajavacollectionsproject.service.base;

import com.rodolfobrandao.aulajavacollectionsproject.models.base.Clientetelefone;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Component;
import com.rodolfobrandao.aulajavacollectionsproject.repositories.impl.CrudRepository;

import java.util.List;

/**

 *   

 *  @author @RodolfoBrandaoOficial.dev.br 

 *  https://github.com/RodolfoBrandaoOficial 

 *  

 * DAO gerado automaticamente para a tabela clientetelefone

 */

@Component

public class ClientetelefoneService implements CrudRepository<Clientetelefone, Long> {

    private final JdbcClient jdbcClient;

    /**

     * Cria uma nova instância de ClientetelefoneService

     * @param jdbcClient O cliente JDBC

     */

    public ClientetelefoneService(JdbcClient jdbcClient) {

        this.jdbcClient = jdbcClient;

    }


    @Override
    public JdbcClient getConnection() {

        return jdbcClient;

    }

    @Override
    public List<Clientetelefone> findAll() {

        return CrudRepository.super.findAll();

    }

    @Override
    public Clientetelefone findById(Long id) {
        return CrudRepository.super.findById(id);
    }

    @Override
    public void save(Clientetelefone entity) {
        CrudRepository.super.save(entity);
    }

    @Override
    public void update(Clientetelefone entity, Integer id) {
        CrudRepository.super.update(entity, id);
    }

    @Override
    public void delete(Long id) {
        CrudRepository.super.delete(id);
    }

}
