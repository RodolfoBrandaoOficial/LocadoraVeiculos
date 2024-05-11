package com.rodolfobrandao.aulajavacollectionsproject.service.base;

import com.rodolfobrandao.aulajavacollectionsproject.models.base.Locacao;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Component;
import com.rodolfobrandao.aulajavacollectionsproject.repositories.impl.CrudRepository;

import java.util.List;

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
    public List<Locacao> findAll() {

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

}
