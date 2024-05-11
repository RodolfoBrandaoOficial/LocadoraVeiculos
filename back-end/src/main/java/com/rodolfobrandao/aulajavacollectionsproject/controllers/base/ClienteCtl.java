package com.rodolfobrandao.aulajavacollectionsproject.controllers.base;

import com.rodolfobrandao.aulajavacollectionsproject.service.base.ClienteService;
import com.rodolfobrandao.aulajavacollectionsproject.models.base.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**

 *   

 *  @author @RodolfoBrandaoOficial.dev.br 

 *  https://github.com/RodolfoBrandaoOficial 

 *  

 * Controlador REST gerado automaticamente para a tabela cliente

 */

@RestController
@RequestMapping("/api/v1/cliente")
public class ClienteCtl {

    private final ClienteService clienteService;

    /**

     * Cria uma nova instância de ClienteCtl

     * @param clienteService O DAO correspondente

     */

    @Autowired
    public ClienteCtl(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/list")
    public List<Cliente> list() {
        return clienteService.findAll();
    }

    @GetMapping("/{id}")
    public Cliente findById(@PathVariable("id") Long id) {
        return clienteService.findById(id);
    }

    @PostMapping("/create")
    public Cliente create(@RequestBody Cliente cliente) {
        clienteService.save(cliente);
        return cliente;
    }

    @PutMapping("/{id}")
    public Cliente update(@PathVariable("id") Integer id, @RequestBody Cliente cliente) {
        cliente.setId(Math.toIntExact(id));
        clienteService.update(cliente, id);
        return cliente;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        clienteService.delete(id);
        return "Cliente deletado com sucesso";
    }

}
