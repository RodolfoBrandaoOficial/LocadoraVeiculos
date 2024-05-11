package com.rodolfobrandao.aulajavacollectionsproject.models.base;

import java.util.Date;
/**
 *   
 *  @author @RodolfoBrandaoOficial.dev.br 
 *  https://github.com/RodolfoBrandaoOficial 
 *  
 * Modelo gerado automaticamente para a tabela locacao
 */
public class Locacao {

    private int id;
    private int id_carro;
    private int id_seguradora;
    private int id_cliente;
    private Date datalocacao;
    private Date datadevolucao;
    private Date datadevolvida;
    private double valor;
    private double valordesconto;
    private double valortotal;

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
     * Obtém o valor de id_carro
     * @return O valor de id_carro
     */
    public int getId_carro() {
        return id_carro;
    }

    /**
     * Define o valor de id_carro
     * @param id_carro O novo valor de id_carro
     */
    public void setId_carro(int id_carro) {
        this.id_carro = id_carro;
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
     * Obtém o valor de datalocacao
     * @return O valor de datalocacao
     */
    public Date getDatalocacao() {
        return datalocacao;
    }

    /**
     * Define o valor de datalocacao
     * @param datalocacao O novo valor de datalocacao
     */
    public void setDatalocacao(Date datalocacao) {
        this.datalocacao = datalocacao;
    }

    /**
     * Obtém o valor de datadevolucao
     * @return O valor de datadevolucao
     */
    public Date getDatadevolucao() {
        return datadevolucao;
    }

    /**
     * Define o valor de datadevolucao
     * @param datadevolucao O novo valor de datadevolucao
     */
    public void setDatadevolucao(Date datadevolucao) {
        this.datadevolucao = datadevolucao;
    }

    /**
     * Obtém o valor de datadevolvida
     * @return O valor de datadevolvida
     */
    public Date getDatadevolvida() {
        return datadevolvida;
    }

    /**
     * Define o valor de datadevolvida
     * @param datadevolvida O novo valor de datadevolvida
     */
    public void setDatadevolvida(Date datadevolvida) {
        this.datadevolvida = datadevolvida;
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
     * Obtém o valor de valordesconto
     * @return O valor de valordesconto
     */
    public double getValordesconto() {
        return valordesconto;
    }

    /**
     * Define o valor de valordesconto
     * @param valordesconto O novo valor de valordesconto
     */
    public void setValordesconto(double valordesconto) {
        this.valordesconto = valordesconto;
    }

    /**
     * Obtém o valor de valortotal
     * @return O valor de valortotal
     */
    public double getValortotal() {
        return valortotal;
    }

    /**
     * Define o valor de valortotal
     * @param valortotal O novo valor de valortotal
     */
    public void setValortotal(double valortotal) {
        this.valortotal = valortotal;
    }

}