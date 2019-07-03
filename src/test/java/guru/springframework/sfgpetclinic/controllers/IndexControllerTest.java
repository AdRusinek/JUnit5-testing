package guru.springframework.sfgpetclinic.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class IndexControllerTest {

    IndexController controller;


    @BeforeEach
    void setUp() {
        controller = new IndexController();
    }

    @DisplayName("Test good view name is returned for index page")
    @Test
    void index() {
        assertEquals("index", controller.index());
        assertEquals("index", controller.index(), "Wrong view returned");

        assertThat(controller.index()).isEqualTo("index");
    }

    @DisplayName("Test exception")
    @Test
    void oupsHandler() {
        assertThrows(ValueNotFoundException.class, () -> {
            controller.oopsHandler();
        });
    }

    @Disabled("Timeout demo")
    @Test
    void testTimeOut() {
        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(2000);
            System.out.println("I got here");
        });
    }

    @Disabled("Timeout demo")
    @Test
    void testTimeOutPrempt() {
        assertTimeout(Duration.ofMillis(100), () -> {
            Thread.sleep(2000);
            System.out.println("I got here, method 2");
        });
    }

    @Disabled
    @Test
    void testAssumptionTrue() {

        assertTrue("ADEK".equalsIgnoreCase(System.getenv("ADEK_SA")));
    }

    @Test
    void testAssumptionTrueAssumptionIsTrue() {

        assertTrue("ADEK".equalsIgnoreCase("ADEK"));
    }

    @EnabledOnOs(OS.MAC)
    @Test
    void testMeOnMacOS() {

    }

    @EnabledOnOs(OS.WINDOWS)
    @Test
    void testMeOnWindows() {

    }

    @EnabledOnJre(JRE.JAVA_8)
    @Test
    void testMeOnJava8() {

    }

    @EnabledOnJre(JRE.JAVA_11)
    @Test
    void testMeOnJava11() {

    }

    @EnabledIfEnvironmentVariable(named = "GITHUB_USER", matches = "AdRusinek")
    @Test
    void testGithubUserName() {

    }

    @EnabledIfEnvironmentVariable(named = "GITHUB_USER", matches = "Adrian")
    @Test
    void testGithubUserNameIfAdrian() {

    }
}