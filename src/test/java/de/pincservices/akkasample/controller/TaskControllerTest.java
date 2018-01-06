package de.pincservices.akkasample.controller;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TaskControllerTest {

    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @Value("${local.server.port}")
    private int port;

    @Test
    public void createTask() {
        given().port(port)
            .when().post("/tasks")
            .then().statusCode(HttpStatus.ACCEPTED.value());

        assertThat(outputCapture.toString()).contains("I should create task");
    }

}