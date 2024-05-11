package com.rodolfobrandao.aulajavacollectionsproject.controllers.tools;

import com.rodolfobrandao.aulajavacollectionsproject.service.tools.SearchService;
import com.rodolfobrandao.aulajavacollectionsproject.models.base.Carro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class SearchCtl {

    @Autowired
    private SearchService searchService;

    @GetMapping("/cars/rented")
    public List<Carro> getCarsRentedByDate(
            @RequestParam(value = "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestParam(value = "disponivel", required = false) Boolean disponivel) {

        // Agora vamos chamar o método correto do DAO
        return searchService.findCarsRentedByDateAndAvailability(date, disponivel);
    }
}
