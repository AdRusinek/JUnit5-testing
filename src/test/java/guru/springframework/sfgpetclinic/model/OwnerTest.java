package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class OwnerTest {

    @Test
    void dependentAssertions() {

        Owner owner = new Owner(1l, "Adrian", "Rusinek");
        owner.setCity("Krakow");
        owner.setTelephone("123123");

        assertAll("Test properties",
                () -> assertAll("Person properties",
                        () -> assertEquals("Adrian", owner.getFirstName(),"First Name did not match"),
                        () -> assertEquals("Rusinek", owner.getLastName())),
                () -> assertAll("Owner properties",
                        () -> assertEquals("Krakow", owner.getCity(),"City did not match"),
                        () -> assertEquals("123123", owner.getTelephone()))
        );

        assertThat(owner.getCity(), is("Krakow"));
    }
}