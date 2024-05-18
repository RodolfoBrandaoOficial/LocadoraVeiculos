package com.rodolfobrandao.aulajavacollectionsproject.controllers.base;

import com.rodolfobrandao.aulajavacollectionsproject.models.advice.PaginatedResponse;
import com.rodolfobrandao.aulajavacollectionsproject.service.base.FabricanteService;
import com.rodolfobrandao.aulajavacollectionsproject.models.base.Fabricante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**

 *

 *  @author @RodolfoBrandaoOficial.dev.br

 *  https://github.com/RodolfoBrandaoOficial

 *

 * Controlador REST gerado automaticamente para a tabela fabricante

 */

@RestController
@RequestMapping("/api/v1/fabricante")
@CrossOrigin(origins = "*")
public class FabricanteCtl {

    private final FabricanteService fabricanteService;

    /**

     * Cria uma nova instância de FabricanteCtl

     * @param fabricanteService O DAO correspondente

     */

    @Autowired
    public FabricanteCtl(FabricanteService fabricanteService) {
        this.fabricanteService = fabricanteService;
    }

    @GetMapping("/list")
    public PaginatedResponse<Map<String, Object>> findAll() {
        return fabricanteService.findAll();
    }

    @GetMapping("/{id}")
    public Fabricante findById(@PathVariable("id") Long id) {
        return fabricanteService.findById(id);
    }

    @PostMapping("/create")
    public Fabricante create(@RequestBody Fabricante fabricante) {
        fabricanteService.save(fabricante);
        return fabricante;
    }

    @PutMapping("/{id}")
    public Fabricante update(@PathVariable("id") Integer id, @RequestBody Fabricante fabricante) {
        fabricante.setId(Math.toIntExact(id));
        fabricanteService.update(fabricante, id);
        return fabricante;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        fabricanteService.delete(id);
        return "Fabricante deletado com sucesso";
    }

}
