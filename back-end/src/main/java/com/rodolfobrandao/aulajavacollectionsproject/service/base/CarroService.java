package com.rodolfobrandao.aulajavacollectionsproject.service.base;

import com.rodolfobrandao.aulajavacollectionsproject.models.advice.PaginatedResponse;
import com.rodolfobrandao.aulajavacollectionsproject.models.base.Carro;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Component;
import com.rodolfobrandao.aulajavacollectionsproject.repositories.impl.CrudRepository;

import java.util.Map;

/**

 *

 *  @author @RodolfoBrandaoOficial.dev.br

 *  https://github.com/RodolfoBrandaoOficial

 *

 * DAO gerado automaticamente para a tabela carro

 */

@Component

public class CarroService implements CrudRepository<Carro, Integer> { // Mudança no tipo do ID para Integer

    private final JdbcClient jdbcClient;

    /**

     * Cria uma nova instância de CarroService

     * @param jdbcClient O cliente JDBC

     */

    public CarroService(JdbcClient jdbcClient) {

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
    public Carro findById(Integer id) { // Mudança no tipo do parâmetro de Long para Integer
        return CrudRepository.super.findById(id);
    }

    @Override
    public void save(Carro entity) {
        CrudRepository.super.save(entity);
    }

    @Override
    public void update(Carro entity, Integer id) { // Adição do parâmetro ID
        CrudRepository.super.update(entity, id);
    }

    @Override
    public void delete(Integer id) { // Mudança no tipo do parâmetro de Long para Integer
        CrudRepository.super.delete(id);
    }

}
