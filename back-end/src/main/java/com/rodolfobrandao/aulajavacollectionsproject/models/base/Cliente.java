package com.rodolfobrandao.aulajavacollectionsproject.models.base;

import java.util.Date;
/**
 *   
 *  @author @RodolfoBrandaoOficial.dev.br 
 *  https://github.com/RodolfoBrandaoOficial 
 *  
 * Modelo gerado automaticamente para a tabela cliente
 */
public class Cliente {

    private int id;
    private String rg;
    private String cpf;
    private String nome;
    private String logradouro;
    private int id_municipio;
    private int id_estado;
    private String cnh;
    private Date datavencimentocnh;
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
     * Obtém o valor de rg
     * @return O valor de rg
     */
    public String getRg() {
        return rg;
    }

    /**
     * Define o valor de rg
     * @param rg O novo valor de rg
     */
    public void setRg(String rg) {
        this.rg = rg;
    }

    /**
     * Obtém o valor de cpf
     * @return O valor de cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * Define o valor de cpf
     * @param cpf O novo valor de cpf
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
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
     * Obtém o valor de logradouro
     * @return O valor de logradouro
     */
    public String getLogradouro() {
        return logradouro;
    }

    /**
     * Define o valor de logradouro
     * @param logradouro O novo valor de logradouro
     */
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
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

    /**
     * Obtém o valor de cnh
     * @return O valor de cnh
     */
    public String getCnh() {
        return cnh;
    }

    /**
     * Define o valor de cnh
     * @param cnh O novo valor de cnh
     */
    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    /**
     * Obtém o valor de datavencimentocnh
     * @return O valor de datavencimentocnh
     */
    public Date getDatavencimentocnh() {
        return datavencimentocnh;
    }

    /**
     * Define o valor de datavencimentocnh
     * @param datavencimentocnh O novo valor de datavencimentocnh
     */
    public void setDatavencimentocnh(Date datavencimentocnh) {
        this.datavencimentocnh = datavencimentocnh;
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