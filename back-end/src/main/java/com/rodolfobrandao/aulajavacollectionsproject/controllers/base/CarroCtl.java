package com.rodolfobrandao.aulajavacollectionsproject.controllers.base;

import com.rodolfobrandao.aulajavacollectionsproject.models.advice.PaginatedResponse;
import com.rodolfobrandao.aulajavacollectionsproject.service.base.CarroService;
import com.rodolfobrandao.aulajavacollectionsproject.models.base.Carro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**

 *

 *  @author @RodolfoBrandaoOficial.dev.br

 *  https://github.com/RodolfoBrandaoOficial

 *

 * Controlador REST gerado automaticamente para a tabela carro

 */

@RestController
@RequestMapping("/api/v1/carro")
@CrossOrigin(origins = "*")
public class CarroCtl {

    private final CarroService carroService;
    /**

     * Cria uma nova instância de CarroCtl

     * @param carroService O DAO correspondente

     */

    @Autowired
    public CarroCtl(CarroService carroService) {
        this.carroService = carroService;
    }

    @GetMapping("/list")
    public PaginatedResponse<Map<String, Object>> findAll() {
        return carroService.findAll();
    }
    @GetMapping("/{id}")
    public Carro findById(@PathVariable("id") Integer id) { // Mudança no tipo do parâmetro de Long para Integer
        return carroService.findById(id);
    }

    @PostMapping("/create")
    public Carro create(@RequestBody Carro carro) {
        carroService.save(carro);
        return carro;
    }

    @PutMapping("/{id}")
    public Carro update(@PathVariable("id") Integer id, @RequestBody Carro carro) { // Mudança no tipo do parâmetro de Long para Integer
        carroService.update(carro, id); // Passando o ID para o método update
        return carro;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Integer id) { // Mudança no tipo do parâmetro de Long para Integer
        carroService.delete(id);
        return "Carro deletado com sucesso";
    }

}
