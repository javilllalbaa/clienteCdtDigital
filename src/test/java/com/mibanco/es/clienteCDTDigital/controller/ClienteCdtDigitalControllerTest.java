package com.mibanco.es.clienteCDTDigital.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mibanco.es.clienteCDTDigital.gen.type.ClienteCDTDigitalType;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@QuarkusTest
public class ClienteCdtDigitalControllerTest {

    @Inject
    ObjectMapper objectMapper;

    @Mock
    private ObjectMapper mockObjectMapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    /*@Test
    public void testCrearClienteType() throws IOException {
        // Configurar el mock del ObjectMapper
        when(mockObjectMapper.readValue(any(byte[].class), any(Class.class))).thenReturn(new ClienteCDTDigitalType());

        // Preparación de datos
        String jsonString = new String(Files.readAllBytes(Paths.get("src/main/resources/es-ClienteCdtDigital-api.json")), StandardCharsets.UTF_8);
        ClienteCDTDigitalType clienteType = objectMapper.readValue(jsonString, ClienteCDTDigitalType.class);

        // Envío de solicitud
        given()
                .contentType(ContentType.JSON)
                .body(clienteType)
                .when()
                .post("/v1/es/ClienteCDTDigital")
                .then()
                .statusCode(200);
    }*/
}
