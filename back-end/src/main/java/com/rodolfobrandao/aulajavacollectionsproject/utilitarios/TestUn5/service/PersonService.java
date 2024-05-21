package com.rodolfobrandao.aulajavacollectionsproject.utilitarios.TestUn5.service;

import com.rodolfobrandao.aulajavacollectionsproject.utilitarios.TestUn5.dominion.Person;

import java.util.Objects;

@Deprecated
public class PersonService {

    public boolean isAdult(Person person) {
        Objects.requireNonNull(person, "Person can't be null");
        return person.getAge() >= 18;
    }
}
