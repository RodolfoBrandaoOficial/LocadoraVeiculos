package com.rodolfobrandao.aulajavacollectionsproject.models.base;

import java.util.Date;
/**
 *   
 *  @author @RodolfoBrandaoOficial.dev.br 
 *  https://github.com/RodolfoBrandaoOficial 
 *  
 * Modelo gerado automaticamente para a tabela contato
 */
public class Contato {

    private int id;
    private String email;

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
     * Obtém o valor de email
     * @return O valor de email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o valor de email
     * @param email O novo valor de email
     */
    public void setEmail(String email) {
        this.email = email;
    }

}