package com.rodolfobrandao.aulajavacollectionsproject.controllers.base;

import com.rodolfobrandao.aulajavacollectionsproject.models.advice.PaginatedResponse;
import com.rodolfobrandao.aulajavacollectionsproject.service.base.ContatoService;
import com.rodolfobrandao.aulajavacollectionsproject.models.base.Contato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**

 *

 *  @author @RodolfoBrandaoOficial.dev.br

 *  https://github.com/RodolfoBrandaoOficial

 *

 * Controlador REST gerado automaticamente para a tabela contato

 */

@RestController
@RequestMapping("/api/v1/contato")
public class ContatoCtl {

    private final ContatoService contatoService;

    /**

     * Cria uma nova instância de ContatoCtl

     * @param contatoService O DAO correspondente

     */

    @Autowired
    public ContatoCtl(ContatoService contatoService) {
        this.contatoService = contatoService;
    }

    @GetMapping("/list")
    public PaginatedResponse<Map<String, Object>> findAll() {
        return contatoService.findAll();
    }

    @GetMapping("/{id}")
    public Contato findById(@PathVariable("id") Long id) {
        return contatoService.findById(id);
    }

    @PostMapping("/create")
    public Contato create(@RequestBody Contato contato) {
        contatoService.save(contato);
        return contato;
    }

    @PutMapping("/{id}")
    public Contato update(@PathVariable("id") Integer id, @RequestBody Contato contato) {
        contato.setId(Math.toIntExact(id));
        contatoService.update(contato, id);
        return contato;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        contatoService.delete(id);
        return "Contato deletado com sucesso";
    }

}
