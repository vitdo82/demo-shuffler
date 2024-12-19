package com.vitdo82.demo.shuffle.resources;

import com.vitdo82.demo.shuffle.services.RandomGenerator;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class NumberGenerateResourceTest {

    @LocalServerPort
    private int port;

    @MockitoBean
    private RandomGenerator randomGenerator;

    @Autowired
    private TestRestTemplate testRestTemplate;


    @Test
    void shouldReturnBadRequestWhenInputIsNegativeTest() {
        // when
        ResponseEntity<Map> response = testRestTemplate.exchange("http://localhost:" + port + "/api/v1/generate",
                HttpMethod.POST, new HttpEntity<>(-1), Map.class);

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        assertThat(response.getBody()).isEqualTo(Map.of("message", "Number must be positive integer."));
    }

    @Test
    void shouldReturnBadRequestWhenInputExceedsMaxLimitTest() {
        // when
        ResponseEntity<Map> response = testRestTemplate.exchange(
                "http://localhost:" + port + "/api/v1/generate",
                HttpMethod.POST, new HttpEntity<>(1001), Map.class);

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        assertThat(response.getBody()).isEqualTo(Map.of("message", "Number must be less than 1000."));
    }

    @Test
    void shouldReturnListWhenInputIsValidTest() {
        // before
        Mockito.doReturn(List.of(1)).when(randomGenerator).generateRandomNumber(999);

        // when
        ResponseEntity<List> response = testRestTemplate.exchange(
                "http://localhost:" + port + "/api/v1/generate",
                HttpMethod.POST, new HttpEntity<>(999), List.class);

        // then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody()).hasSize(1);
    }
}