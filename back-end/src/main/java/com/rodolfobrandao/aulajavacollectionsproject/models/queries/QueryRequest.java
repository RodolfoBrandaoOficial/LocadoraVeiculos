package com.rodolfobrandao.aulajavacollectionsproject.models.queries;
// Importe os pacotes necessários, se houver

public class QueryRequest {

    private String qtype;
    private String query;
    private String oper;
    private String page;
    private String rp;
    private String grid_param;
    private String sortname;
    private String sortorder;

    // Crie os getters e setters para cada atributo

    public String getQtype() {
        return qtype;
    }

    public void setQtype(String qtype) {
        this.qtype = qtype;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getOper() {
        return oper;
    }

    public void setOper(String oper) {
        this.oper = oper;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getRp() {
        return rp;
    }

    public void setRp(String rp) {
        this.rp = rp;
    }

    public String getGrid_param() {
        return grid_param;
    }

    public void setGrid_param(String grid_param) {
        this.grid_param = grid_param;
    }

    public String getSortname() {
        return sortname;
    }

    public void setSortname(String sortname) {
        this.sortname = sortname;
    }

    public String getSortorder() {
        return sortorder;
    }

    public void setSortorder(String sortorder) {
        this.sortorder = sortorder;
    }
}
