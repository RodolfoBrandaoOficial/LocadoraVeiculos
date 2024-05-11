package com.rodolfobrandao.aulajavacollectionsproject.models.base;

import java.util.Date;
/**
 *   
 *  @author @RodolfoBrandaoOficial.dev.br 
 *  https://github.com/RodolfoBrandaoOficial 
 *  
 * Modelo gerado automaticamente para a tabela estado
 */
public class Estado {

    private int id;
    private String descricao;
    private String sigla;

    /**
     * Obtém o valor de id
     * @return O valor de id
     */
    public int getId() {
        return id;
    }

    /**
     * Define o valor de id
     * @param id O novo valor de id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtém o valor de descricao
     * @return O valor de descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Define o valor de descricao
     * @param descricao O novo valor de descricao
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Obtém o valor de sigla
     * @return O valor de sigla
     */
    public String getSigla() {
        return sigla;
    }

    /**
     * Define o valor de sigla
     * @param sigla O novo valor de sigla
     */
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

}