package app;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;

import app.service.SimpleService;

import static org.hamcrest.Matchers.equalTo;

import java.util.Map;

import io.restassured.RestAssured;
import org.mockito.Mockito;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IntegrationTest {

    @LocalServerPort
    private int port;

    @MockBean
    private SimpleService service;

    @Test
    public void jsonTest() {
        Mockito.when(service.getData()).thenReturn(Map.of("top", Map.of("left", true)));
        RestAssured.given().port(port).when().get("/url").then().assertThat().body("top.left", equalTo(true));
    }
}