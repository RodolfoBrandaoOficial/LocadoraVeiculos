package com.rodolfobrandao.aulajavacollectionsproject.models.base;

import java.util.Date;
/**
 *   
 *  @author @RodolfoBrandaoOficial.dev.br 
 *  https://github.com/RodolfoBrandaoOficial 
 *  
 * Modelo gerado automaticamente para a tabela clientetelefone
 */
public class Clientetelefone {

    private int id;
    private int id_cliente;
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
     * Obtém o valor de id_cliente
     * @return O valor de id_cliente
     */
    public int getId_cliente() {
        return id_cliente;
    }

    /**
     * Define o valor de id_cliente
     * @param id_cliente O novo valor de id_cliente
     */
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
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