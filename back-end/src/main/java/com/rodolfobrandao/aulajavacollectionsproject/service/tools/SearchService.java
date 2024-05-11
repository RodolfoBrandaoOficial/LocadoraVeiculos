package com.rodolfobrandao.aulajavacollectionsproject.service.tools;

import com.rodolfobrandao.aulajavacollectionsproject.models.base.Carro;
import com.rodolfobrandao.aulajavacollectionsproject.repositories.impl.MapeadordeLinhas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class SearchService {

    @Autowired
    private NamedParameterJdbcOperations jdbcOperations;

    // Método para buscar Carros alugados por data
    public List<Carro> findCarsRentedByDateAndAvailability(LocalDate date, Boolean disponivel) {
        String query = "SELECT c.* FROM public.carro c " +
                "JOIN public.locacao l ON c.id = l.id_carro " +
                "WHERE :date BETWEEN l.datalocacao AND l.datadevolucao ";

        if (disponivel != null) {
            query += "AND c.disponivel = :disponivel ";
        }

        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("date", date);
        if (disponivel != null) {
            params.addValue("disponivel", disponivel);
        }

        return jdbcOperations.query(query, params, new MapeadordeLinhas<>(Carro.class));
    }

}
