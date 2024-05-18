package com.rodolfobrandao.aulajavacollectionsproject.controllers.base;

import com.rodolfobrandao.aulajavacollectionsproject.models.advice.PaginatedResponse;
import com.rodolfobrandao.aulajavacollectionsproject.service.base.ModeloService;
import com.rodolfobrandao.aulajavacollectionsproject.models.base.Modelo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**

 *

 *  @author @RodolfoBrandaoOficial.dev.br

 *  https://github.com/RodolfoBrandaoOficial

 *

 * Controlador REST gerado automaticamente para a tabela modelo

 */

@RestController
@RequestMapping("/api/v1/modelo")
@CrossOrigin(origins = "*")
public class ModeloCtl {

    private final ModeloService modeloService;

    /**

     * Cria uma nova instância de ModeloCtlS

     * @param modeloService O DAO correspondente

     */

    @Autowired
    public ModeloCtl(ModeloService modeloService) {
        this.modeloService = modeloService;
    }

    @GetMapping("/list")
    public PaginatedResponse<Map<String, Object>> findAll(){
        return modeloService.findAll();
    }

    @GetMapping("/{id}")
    public Modelo findById(@PathVariable("id") Long id) {
        return modeloService.findById(id);
    }

    @PostMapping("/create")
    public Modelo create(@RequestBody Modelo modelo) {
        modeloService.save(modelo);
        return modelo;
    }


    @PutMapping("/{id}")
    public Modelo update(@PathVariable("id") Integer id, @RequestBody Modelo modelo) {
        modelo.setId(Math.toIntExact(id));
        modeloService.update(modelo, id);
        return modelo;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        modeloService.delete(id);
        return "Modelo deletado com sucesso";
    }

}
