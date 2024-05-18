package com.rodolfobrandao.aulajavacollectionsproject.models.advice;

import java.util.List;

/**
 * Classe para representar a resposta de uma consulta paginada.
 *
 * @param <T> O tipo dos registros retornados na resposta.
 */
public class PaginatedResponse<T> {
    private String page;
    private long total;
    private List<T> registros;

    // Getters e Setters

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRegistros() {
        return registros;
    }

    public void setRegistros(List<T> registros) {
        this.registros = registros;
    }
}
