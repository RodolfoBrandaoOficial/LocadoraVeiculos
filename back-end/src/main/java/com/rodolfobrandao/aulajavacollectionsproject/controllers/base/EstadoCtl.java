package com.rodolfobrandao.aulajavacollectionsproject.controllers.base;

import com.rodolfobrandao.aulajavacollectionsproject.models.advice.PaginatedResponse;
import com.rodolfobrandao.aulajavacollectionsproject.service.base.EstadoService;
import com.rodolfobrandao.aulajavacollectionsproject.models.base.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**

 *

 *  @author @RodolfoBrandaoOficial.dev.br

 *  https://github.com/RodolfoBrandaoOficial

 *

 * Controlador REST gerado automaticamente para a tabela estado

 */

@RestController
@RequestMapping("/api/v1/estado")
@CrossOrigin(origins = "*")
public class EstadoCtl {

    private final EstadoService estadoService;

    /**

     * Cria uma nova instância de EstadoCtl

     * @param estadoService O DAO correspondente

     */

    @Autowired
    public EstadoCtl(EstadoService estadoService) {
        this.estadoService = estadoService;
    }

    @GetMapping("/list")
    public PaginatedResponse<Map<String, Object>> findAll() {
        return estadoService.findAll();
    }

    @GetMapping("/{id}")
    public Estado findById(@PathVariable("id") Long id) {
        return estadoService.findById(id);
    }

    @PostMapping("/create")
    public Estado create(@RequestBody Estado estado) {
        estadoService.save(estado);
        return estado;
    }

    @PutMapping("/{id}")
    public Estado update(@PathVariable("id") Integer id, @RequestBody Estado estado) {
        estado.setId(Math.toIntExact(id));
        estadoService.update(estado, id);
        return estado;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        estadoService.delete(id);
        return "Estado deletado com sucesso";
    }

}
