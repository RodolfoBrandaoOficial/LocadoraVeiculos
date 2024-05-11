package com.rodolfobrandao.aulajavacollectionsproject.models.base;

import java.util.Date;
/**
 *   
 *  @author @RodolfoBrandaoOficial.dev.br 
 *  https://github.com/RodolfoBrandaoOficial 
 *  
 * Modelo gerado automaticamente para a tabela seguradora
 */
public class Seguradora {

    private int id;
    private String nome;
    private String cnpj;
    private String email;
    private double valor;
    private int id_municipio;
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
     * Obtém o valor de cnpj
     * @return O valor de cnpj
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * Define o valor de cnpj
     * @param cnpj O novo valor de cnpj
     */
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
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

    /**
     * Obtém o valor de valor
     * @return O valor de valor
     */
    public double getValor() {
        return valor;
    }

    /**
     * Define o valor de valor
     * @param valor O novo valor de valor
     */
    public void setValor(double valor) {
        this.valor = valor;
    }

    /**
     * Obtém o valor de id_municipio
     * @return O valor de id_municipio
     */
    public int getId_municipio() {
        return id_municipio;
    }

    /**
     * Define o valor de id_municipio
     * @param id_municipio O novo valor de id_municipio
     */
    public void setId_municipio(int id_municipio) {
        this.id_municipio = id_municipio;
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