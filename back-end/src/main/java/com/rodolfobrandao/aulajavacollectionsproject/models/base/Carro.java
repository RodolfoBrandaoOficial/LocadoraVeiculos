package com.rodolfobrandao.aulajavacollectionsproject.models.base;

import java.util.Date;
/**
 *
 *  @author @RodolfoBrandaoOficial.dev.br
 *  https://github.com/RodolfoBrandaoOficial
 *
 * Modelo gerado automaticamente para a tabela carro
 */
public class Carro {

    private int id;
    private int id_fabricante;
    private int id_modelo;
    private String placa;
    private String cor;
    private boolean disponivel;
    private int ano;
    private double valorlocacao;

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

    /**
     * Obtém o valor de id_modelo
     * @return O valor de id_modelo
     */
    public int getId_modelo() {
        return id_modelo;
    }

    /**
     * Define o valor de id_modelo
     * @param id_modelo O novo valor de id_modelo
     */
    public void setId_modelo(int id_modelo) {
        this.id_modelo = id_modelo;
    }

    /**
     * Obtém o valor de placa
     * @return O valor de placa
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * Define o valor de placa
     * @param placa O novo valor de placa
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    /**
     * Obtém o valor de cor
     * @return O valor de cor
     */
    public String getCor() {
        return cor;
    }

    /**
     * Define o valor de cor
     * @param cor O novo valor de cor
     */
    public void setCor(String cor) {
        this.cor = cor;
    }

    /**
     * Obtém o valor de disponivel
     * @return O valor de disponivel
     */
    public boolean getDisponivel() {
        return disponivel;
    }

    /**
     * Define o valor de disponivel
     * @param disponivel O novo valor de disponivel
     */
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    /**
     * Obtém o valor de ano
     * @return O valor de ano
     */
    public int getAno() {
        return ano;
    }

    /**
     * Define o valor de ano
     * @param ano O novo valor de ano
     */
    public void setAno(int ano) {
        this.ano = ano;
    }

    /**
     * Obtém o valor de valorlocacao
     * @return O valor de valorlocacao
     */
    public double getValorlocacao() {
        return valorlocacao;
    }

    /**
     * Define o valor de valorlocacao
     * @param valorlocacao O novo valor de valorlocacao
     */
    public void setValorlocacao(double valorlocacao) {
        this.valorlocacao = valorlocacao;
    }

}