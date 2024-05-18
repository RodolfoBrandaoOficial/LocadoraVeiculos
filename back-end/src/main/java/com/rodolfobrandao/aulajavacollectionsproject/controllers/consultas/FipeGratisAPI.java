package com.rodolfobrandao.aulajavacollectionsproject.controllers.consultas;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Deprecated
@SpringBootApplication
@RestController
public class FipeGratisAPI {

    @GetMapping("/tabelas")
    public List<Map<String, String>> getTabelas() throws IOException {
        List<Map<String, String>> tabelas = new ArrayList<>();
        Document doc = Jsoup.connect("http://www.fipe.org.br/web/indices/veiculos/default.aspx").get();
        Elements options = doc.select("#ddlTabelaReferencia > option");
        for (Element option : options) {
            Map<String, String> tabela = new HashMap<>();
            tabela.put("codigo", option.attr("value"));
            tabela.put("tabela", option.text());
            tabelas.add(tabela);
        }
        return tabelas;
    }

    @GetMapping("/marcas")
    public List<Map<String, String>> getMarcas(@RequestParam String tipo, @RequestParam int tabelaReferencia) throws IOException {
        List<Map<String, String>> marcas = new ArrayList<>();
        Document doc = Jsoup.connect("http://www.fipe.org.br/web/indices/veiculos/default.aspx?" + tipo).get();
        Elements options = doc.select("#ddlMarca > option");
        for (Element option : options) {
            String codigo = option.attr("value");
            if (!codigo.equals("0")) {
                Map<String, String> marca = new HashMap<>();
                marca.put("codigo", codigo);
                marca.put("marca", option.text());
                // Adicione aqui a lógica para buscar o logo
                marcas.add(marca);
            }
        }
        return marcas;
    }

    @GetMapping("/modelos")
    public List<Map<String, String>> getModelos(@RequestParam String tipo, @RequestParam int tabelaReferencia, @RequestParam int codMarca) throws IOException {
        List<Map<String, String>> modelos = new ArrayList<>();
        Document doc = Jsoup.connect("http://www.fipe.org.br/web/indices/veiculos/default.aspx?" + tipo).get();
        Elements options = doc.select("#ddlModelo > option");
        for (Element option : options) {
            String codigo = option.attr("value");
            if (!codigo.equals("0")) {
                Map<String, String> modelo = new HashMap<>();
                modelo.put("codigo", codigo);
                modelo.put("modelo", option.text());
                modelos.add(modelo);
            }
        }
        return modelos;
    }

    @GetMapping("/anos")
    public List<Map<String, String>> getAnos(@RequestParam String tipo, @RequestParam int tabelaReferencia, @RequestParam int codMarca, @RequestParam int codModelo) throws IOException {
        List<Map<String, String>> anos = new ArrayList<>();
        Document doc = Jsoup.connect("http://www.fipe.org.br/web/indices/veiculos/default.aspx?" + tipo).get();
        Elements options = doc.select("#ddlAnoValor > option");
        for (Element option : options) {
            String codigo = option.attr("value");
            if (!codigo.equals("0")) {
                Map<String, String> ano = new HashMap<>();
                ano.put("codigo", codigo);
                ano.put("ano", option.text());
                anos.add(ano);
            }
        }
        return anos;
    }

    @GetMapping("/precoMedio")
    public double getPrecoMedio(@RequestParam String tipo, @RequestParam int tabelaReferencia, @RequestParam int codMarca, @RequestParam int codModelo, @RequestParam int codAno) throws IOException {
        Document doc = Jsoup.connect("http://www.fipe.org.br/web/indices/veiculos/default.aspx?" + tipo).get();
        Element precoElement = doc.selectFirst("#lblValor");
        String precoText = precoElement.text().replace("R$", "").trim();
        return Double.parseDouble(precoText.replace(".", "").replace(",", "."));
    }
}
