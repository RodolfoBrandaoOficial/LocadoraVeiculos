package com.rodolfobrandao.aulajavacollectionsproject.models.base;

import java.util.Date;
/**
 *   
 *  @author @RodolfoBrandaoOficial.dev.br 
 *  https://github.com/RodolfoBrandaoOficial 
 *  
 * Modelo gerado automaticamente para a tabela municipio
 */
public class Municipio {

    private int id;
    private String descricao;
    private int id_estado;

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
     * Obtém o valor de id_estado
     * @return O valor de id_estado
     */
    public int getId_estado() {
        return id_estado;
    }

    /**
     * Define o valor de id_estado
     * @param id_estado O novo valor de id_estado
     */
    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }

}