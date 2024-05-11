package com.rodolfobrandao.aulajavacollectionsproject.controllers.base;

import com.rodolfobrandao.aulajavacollectionsproject.service.base.MunicipioService;
import com.rodolfobrandao.aulajavacollectionsproject.models.base.Municipio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**

 *   

 *  @author @RodolfoBrandaoOficial.dev.br 

 *  https://github.com/RodolfoBrandaoOficial 

 *  

 * Controlador REST gerado automaticamente para a tabela municipio

 */

@RestController
@RequestMapping("/api/v1/municipio")
public class MunicipioCtl {

    private final MunicipioService municipioService;

    /**

     * Cria uma nova instância de MunicipioCtl

     * @param municipioService O DAO correspondente

     */

    @Autowired
    public MunicipioCtl(MunicipioService municipioService) {
        this.municipioService = municipioService;
    }

    @GetMapping("/list")
    public List<Municipio> list() {
        return municipioService.findAll();
    }

    @GetMapping("/{id}")
    public Municipio findById(@PathVariable("id") Long id) {
        return municipioService.findById(id);
    }

    @PostMapping("/create")
    public Municipio create(@RequestBody Municipio municipio) {
        municipioService.save(municipio);
        return municipio;
    }

    @PutMapping("/{id}")
    public Municipio update(@PathVariable("id") Integer id, @RequestBody Municipio municipio) {
        municipio.setId(Math.toIntExact(id));
        municipioService.update(municipio, id);
        return municipio;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        municipioService.delete(id);
        return "Municipio deletado com sucesso";
    }

}
