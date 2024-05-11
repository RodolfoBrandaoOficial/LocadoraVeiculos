package com.rodolfobrandao.aulajavacollectionsproject.models.base;

import java.util.Date;
/**
 *   
 *  @author @RodolfoBrandaoOficial.dev.br 
 *  https://github.com/RodolfoBrandaoOficial 
 *  
 * Modelo gerado automaticamente para a tabela fabricante
 */
public class Fabricante {

    private int id;
    private String nome;
    private Object imgurl;

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
     * Obtém o valor de imgurl
     * @return O valor de imgurl
     */
    public Object getImgurl() {
        return imgurl;
    }

    /**
     * Define o valor de imgurl
     * @param imgurl O novo valor de imgurl
     */
    public void setImgurl(Object imgurl) {
        this.imgurl = imgurl;
    }

}