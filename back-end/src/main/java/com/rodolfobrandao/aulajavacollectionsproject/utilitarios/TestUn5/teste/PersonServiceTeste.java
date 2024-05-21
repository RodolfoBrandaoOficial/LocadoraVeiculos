package com.rodolfobrandao.aulajavacollectionsproject.utilitarios.TestUn5.teste;


import com.rodolfobrandao.aulajavacollectionsproject.utilitarios.TestUn5.dominion.Person;
import com.rodolfobrandao.aulajavacollectionsproject.utilitarios.TestUn5.service.PersonService;
import lombok.extern.log4j.Log4j2;

@Deprecated
@Log4j2
public class PersonServiceTeste {

    // @Test
    public static void main(String[] args){
        Person person = new Person(15);
        PersonService personService = new PersonService();
        log.info("Is Adult? '{}", personService.isAdult(person));
    }
}
