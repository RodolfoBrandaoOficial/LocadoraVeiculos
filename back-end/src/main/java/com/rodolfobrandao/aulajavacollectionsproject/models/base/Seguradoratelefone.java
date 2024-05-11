package com.rodolfobrandao.aulajavacollectionsproject.models.base;

import java.util.Date;
/**
 *   
 *  @author @RodolfoBrandaoOficial.dev.br 
 *  https://github.com/RodolfoBrandaoOficial 
 *  
 * Modelo gerado automaticamente para a tabela seguradoratelefone
 */
public class Seguradoratelefone {

    private int id;
    private int id_seguradora;
    private String telefone;

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
     * Obtém o valor de id_seguradora
     * @return O valor de id_seguradora
     */
    public int getId_seguradora() {
        return id_seguradora;
    }

    /**
     * Define o valor de id_seguradora
     * @param id_seguradora O novo valor de id_seguradora
     */
    public void setId_seguradora(int id_seguradora) {
        this.id_seguradora = id_seguradora;
    }

    /**
     * Obtém o valor de telefone
     * @return O valor de telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * Define o valor de telefone
     * @param telefone O novo valor de telefone
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}