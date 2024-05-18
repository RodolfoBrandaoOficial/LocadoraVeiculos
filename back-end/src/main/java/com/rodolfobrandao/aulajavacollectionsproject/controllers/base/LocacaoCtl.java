package com.rodolfobrandao.aulajavacollectionsproject.controllers.base;

import com.rodolfobrandao.aulajavacollectionsproject.models.advice.PaginatedResponse;
import com.rodolfobrandao.aulajavacollectionsproject.models.base.Locacao;
import com.rodolfobrandao.aulajavacollectionsproject.models.queries.QueryRequest;
import com.rodolfobrandao.aulajavacollectionsproject.service.base.LocacaoService;
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
 * Controlador REST gerado automaticamente para a tabela locacao
 */

@RestController
@RequestMapping("/api/v1/locacao")
public class LocacaoCtl {

    private final LocacaoService locacaoService;

    /**
     * Cria uma nova instância de LocacaoCtl
     *
     * @param locacaoService O DAO correspondente
     */


    @Autowired
    public LocacaoCtl(LocacaoService locacaoService) {
        this.locacaoService = locacaoService;
    }

    @GetMapping("/list")
    public PaginatedResponse<Map<String, Object>> findAll() {
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

//    @PostMapping("/findByQueryGeneric")
//    public List<Locacao> findByQuery(@RequestBody String qtype, String query, String oper, String page, String rp, String grid_param, String sortname, String sortorder) {
//        return locacaoService.findByQuery(qtype, query, oper, page, rp, grid_param, sortname, sortorder);
//    }

    @PostMapping("/findByQuery")
    public PaginatedResponse<Locacao> findByQueryquery(@RequestBody QueryRequest request) {
        return locacaoService.findByQuery(request.getQtype(), request.getQuery(), request.getOper(), request.getPage(), request.getRp(), request.getGrid_param(), request.getSortname(), request.getSortorder());
    }


}
