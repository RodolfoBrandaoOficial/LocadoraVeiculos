package com.rodolfobrandao.aulajavacollectionsproject.controllers.base;

import com.rodolfobrandao.aulajavacollectionsproject.service.base.LocacaoService;
import com.rodolfobrandao.aulajavacollectionsproject.models.base.Locacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**

 *   

 *  @author @RodolfoBrandaoOficial.dev.br 

 *  https://github.com/RodolfoBrandaoOficial 

 *  

 * Controlador REST gerado automaticamente para a tabela locacao

 */

@RestController
@RequestMapping("/api/v1/locacao")
public class LocacaoCtl {

    private final LocacaoService locacaoService;

    /**

     * Cria uma nova instância de LocacaoCtl

     * @param locacaoService O DAO correspondente

     */

    @Autowired
    public LocacaoCtl(LocacaoService locacaoService) {
        this.locacaoService = locacaoService;
    }

    @GetMapping("/list")
    public List<Locacao> list() {
        return locacaoService.findAll();
    }

    @GetMapping("/{id}")
    public Locacao findById(@PathVariable("id") Long id) {
        return locacaoService.findById(id);
    }

    @PostMapping("/create")
    public Locacao create(@RequestBody Locacao locacao) {
        locacaoService.save(locacao);
        return locacao;
    }

    @PutMapping("/{id}")
    public Locacao update(@PathVariable("id") Integer id, @RequestBody Locacao locacao) {
        locacao.setId(Math.toIntExact(id));
        locacaoService.update(locacao, id);
        return locacao;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        locacaoService.delete(id);
        return "Locacao deletado com sucesso";
    }

}
