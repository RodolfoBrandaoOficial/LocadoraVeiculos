package com.rodolfobrandao.aulajavacollectionsproject.repositories.impl;

import org.springframework.jdbc.core.RowMapper;

import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeadordeLinhas<T> implements RowMapper<T> {

    private final Class<T> clazz;

    public MapeadordeLinhas(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public T mapRow(ResultSet rs, int rowNum) throws SQLException {
        try {
            return clazz.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new RuntimeException("Falha ao instanciar a classe " + clazz.getName(), e);
        }
    }
}


