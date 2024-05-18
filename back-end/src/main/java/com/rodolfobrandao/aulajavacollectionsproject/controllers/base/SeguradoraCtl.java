package com.rodolfobrandao.aulajavacollectionsproject.controllers.base;

import com.rodolfobrandao.aulajavacollectionsproject.models.advice.PaginatedResponse;
import com.rodolfobrandao.aulajavacollectionsproject.service.base.SeguradoraService;
import com.rodolfobrandao.aulajavacollectionsproject.models.base.Seguradora;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**

 *

 *  @author @RodolfoBrandaoOficial.dev.br

 *  https://github.com/RodolfoBrandaoOficial

 *

 * Controlador REST gerado automaticamente para a tabela seguradora

 */

@RestController
@RequestMapping("/api/v1/seguradora")
public class SeguradoraCtl {

    private final SeguradoraService seguradoraService;

    /**

     * Cria uma nova instância de SeguradoraCtl

     * @param seguradoraService O DAO correspondente

     */

    @Autowired
    public SeguradoraCtl(SeguradoraService seguradoraService) {
        this.seguradoraService = seguradoraService;
    }

    @GetMapping("/list")
    public PaginatedResponse<Map<String, Object>> findAll(){
        return seguradoraService.findAll();
    }

    @GetMapping("/{id}")
    public Seguradora findById(@PathVariable("id") Long id) {
        return seguradoraService.findById(id);
    }

    @PostMapping("/create")
    public Seguradora create(@RequestBody Seguradora seguradora) {
        seguradoraService.save(seguradora);
        return seguradora;
    }

    @PutMapping("/{id}")
    public Seguradora update(@PathVariable("id") Integer id, @RequestBody Seguradora seguradora) {
        seguradora.setId(Math.toIntExact(id));
        seguradoraService.update(seguradora, id);
        return seguradora;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        seguradoraService.delete(id);
        return "Seguradora deletado com sucesso";
    }

}
