package com.rodolfobrandao.aulajavacollectionsproject.models.base;

import java.util.Date;
/**
 *   
 *  @author @RodolfoBrandaoOficial.dev.br 
 *  https://github.com/RodolfoBrandaoOficial 
 *  
 * Modelo gerado automaticamente para a tabela modelo
 */
public class Modelo {

    private int id;
    private String nome;
    private int id_fabricante;

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
     * Obtém o valor de nome
     * @return O valor de nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o valor de nome
     * @param nome O novo valor de nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Obtém o valor de id_fabricante
     * @return O valor de id_fabricante
     */
    public int getId_fabricante() {
        return id_fabricante;
    }

    /**
     * Define o valor de id_fabricante
     * @param id_fabricante O novo valor de id_fabricante
     */
    public void setId_fabricante(int id_fabricante) {
        this.id_fabricante = id_fabricante;
    }

}