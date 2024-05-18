package com.rodolfobrandao.aulajavacollectionsproject.controllers.base;

import com.rodolfobrandao.aulajavacollectionsproject.models.advice.PaginatedResponse;
import com.rodolfobrandao.aulajavacollectionsproject.models.base.Clientetelefone;
import com.rodolfobrandao.aulajavacollectionsproject.service.base.ClientetelefoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author @RodolfoBrandaoOficial.dev.br
 * <p>
 * https://github.com/RodolfoBrandaoOficial
 * <p>
 * <p>
 * <p>
 * Controlador REST gerado automaticamente para a tabela clientetelefone
 */

@RestController
@RequestMapping("/api/v1/clientetelefone")
@CrossOrigin(origins = "*")
public class ClientetelefoneCtl {

    private final ClientetelefoneService clientetelefoneService;

    /**
     * Cria uma nova instância de ClientetelefoneCtl
     *
     * @param clientetelefoneService O DAO correspondente
     */

    @Autowired
    public ClientetelefoneCtl(ClientetelefoneService clientetelefoneService) {
        this.clientetelefoneService = clientetelefoneService;
    }

    @GetMapping("/list")
    public PaginatedResponse<Map<String, Object>> findAll() {
        return clientetelefoneService.findAll();
    }

    @GetMapping("/{id}")
    public Clientetelefone findById(@PathVariable("id") Long id) {
        return clientetelefoneService.findById(id);
    }

    @PostMapping("/create")
    public Clientetelefone create(@RequestBody Clientetelefone clientetelefone) {
        clientetelefoneService.save(clientetelefone);
        return clientetelefone;
    }

    @PutMapping("/{id}")
    public Clientetelefone update(@PathVariable("id") Integer id, @RequestBody Clientetelefone clientetelefone) {
        clientetelefone.setId(Math.toIntExact(id));
        clientetelefoneService.update(clientetelefone, id);
        return clientetelefone;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        clientetelefoneService.delete(id);
        return "Clientetelefone deletado com sucesso";
    }

}
