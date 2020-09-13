package de.kaiserpfalzedv.ocpmeetup.knative;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;

/**
 * @author rlichti
 * @version 1.0.0 2020-09-12
 * @since 1.0.0 2020-09-12
 */
@QuarkusTest
public class GreetingTest {
    private static final Logger LOG = LoggerFactory.getLogger(GreetingTest.class);

    @Test
    public void testHelloEndpoint() {
        given()
                .when().get("/")
                .then()
                .statusCode(200);
    }
}
