package TestUn5.service;

import com.rodolfobrandao.aulajavacollectionsproject.utilitarios.TestUn5.dominion.Person;
import com.rodolfobrandao.aulajavacollectionsproject.utilitarios.TestUn5.service.PersonService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;


@Deprecated
class PersonServiceTest {

    @Test
    @DisplayName("A person shold be not adult whem age is greater than 18")
    void isAdult_ReturnFalseWhenAgeIsLowerThan18() {
        PersonService personService = new PersonService();

        Person person = new Person(17);
        person.setAge(17);
        assertFalse(personService.isAdult(person));
    }
}
