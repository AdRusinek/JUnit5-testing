package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


class PersonTest implements ModelTests {

    @Test
    void groupedAssertions() {

        Person person = new Person(1l, "Adrian", "Rusinek");

        assertAll("Test Props Set",
                () -> assertEquals(person.getFirstName(), "Adrian"),
                () -> assertEquals(person.getLastName(), "Rusinek"));
    }

    @Test
    void groupedAssertionsMessages() {

        Person person = new Person(1l, "Adrian", "Rusinek");

        assertAll("Test Props Set",
                () -> assertEquals(person.getFirstName(), "Adrian", "First name failed"),
                () -> assertEquals(person.getLastName(), "Rusinek", "Last name failed"));
    }

    @RepeatedTest(value = 10, name = "{displayName} : {currentRepetition} - {totalRepetitions}")
    @DisplayName("My repeated test")
    void myRepeatedTest() {
        // todo - impl
    }
}