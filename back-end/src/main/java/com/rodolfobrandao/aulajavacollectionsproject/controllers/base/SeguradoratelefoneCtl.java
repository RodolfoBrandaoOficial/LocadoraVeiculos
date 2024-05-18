package com.rodolfobrandao.aulajavacollectionsproject.controllers.base;

import com.rodolfobrandao.aulajavacollectionsproject.models.advice.PaginatedResponse;
import com.rodolfobrandao.aulajavacollectionsproject.service.base.SeguradoratelefoneService;
import com.rodolfobrandao.aulajavacollectionsproject.models.base.Seguradoratelefone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**

 *

 *  @author @RodolfoBrandaoOficial.dev.br

 *  https://github.com/RodolfoBrandaoOficial

 *

 * Controlador REST gerado automaticamente para a tabela seguradoratelefone

 */

@RestController
@RequestMapping("/api/v1/seguradoratelefone")
public class SeguradoratelefoneCtl {

    private final SeguradoratelefoneService seguradoratelefoneService;

    /**

     * Cria uma nova instância de SeguradoratelefoneCtl

     * @param seguradoratelefoneService O DAO correspondente

     */

    @Autowired
    public SeguradoratelefoneCtl(SeguradoratelefoneService seguradoratelefoneService) {
        this.seguradoratelefoneService = seguradoratelefoneService;
    }

    @GetMapping("/list")
    public PaginatedResponse<Map<String, Object>> findAll(){
        return seguradoratelefoneService.findAll();
    }

    @GetMapping("/{id}")
    public Seguradoratelefone findById(@PathVariable("id") Long id) {
        return seguradoratelefoneService.findById(id);
    }

    @PostMapping("/create")
    public Seguradoratelefone create(@RequestBody Seguradoratelefone seguradoratelefone) {
        seguradoratelefoneService.save(seguradoratelefone);
        return seguradoratelefone;
    }

    @PutMapping("/{id}")
    public Seguradoratelefone update(@PathVariable("id") Integer id, @RequestBody Seguradoratelefone seguradoratelefone) {
        seguradoratelefone.setId(Math.toIntExact(id));
        seguradoratelefoneService.update(seguradoratelefone, id);
        return seguradoratelefone;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        seguradoratelefoneService.delete(id);
        return "Seguradoratelefone deletado com sucesso";
    }

}
