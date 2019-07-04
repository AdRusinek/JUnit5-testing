package guru.springframework.sfgpetclinic.model;

import guru.springframework.sfgpetclinic.ModelTests;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class OwnerTest implements ModelTests {

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

    @DisplayName("Value Source Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @ValueSource(strings = {"Spring","Framework"})
    void testValueSource(String val) {
        System.out.println(val);
    }

    @DisplayName("Enum Source Test")
    @ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
    @EnumSource(OwnerType.class)
    void enumTest(OwnerType ownerType) {
        System.out.println(ownerType);
    }
}