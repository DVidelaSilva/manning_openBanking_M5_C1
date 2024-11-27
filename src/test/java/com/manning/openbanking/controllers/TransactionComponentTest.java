package com.manning.openbanking.controllers;

import com.manning.openbanking.OpenbankingApplication;
import com.manning.openbanking.entities.Transaction;
import com.manning.openbanking.repositories.InMemoryMerchantDetailsRepository;
import com.manning.openbanking.Apis.RESTTransactionsAPIClient;
import com.manning.openbanking.repositories.TransactionApiClient;
import com.manning.openbanking.repositories.TransactionRepository;
import com.manning.openbanking.services.TransactionService;
import com.manning.openbanking.controllers.TransactionalController;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.web.reactive.function.client.WebClient;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.*;

import java.util.Arrays;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import io.manning.openbanking.models.OBActiveOrHistoricCurrencyAndAmount9;
import io.manning.openbanking.models.OBCreditDebitCode1;
import io.manning.openbanking.models.OBMerchantDetails1;
import io.manning.openbanking.models.OBReadDataTransaction6;
import io.manning.openbanking.models.OBReadTransaction6;
import io.manning.openbanking.models.OBTransaction6;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import com.fasterxml.jackson.databind.ObjectMapper;



import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;


@SpringBootTest(classes = {OpenbankingApplication.class}, webEnvironment = RANDOM_PORT)
public class TransactionComponentTest {
    // @LocalServerPort
    // private int port;

    // @MockBean
    // private TransactionRepository transactionRepository;

    // @MockBean
    // private TransactionApiClient transactionApiClient;

    // private TransactionService transactionService;

    // @Autowired
    // private TransactionalController transactionController;

    // @BeforeEach
    // public void setup() {
    //     // Inicializamos el servicio y el controlador para las pruebas.
    //     transactionService = new TransactionService(transactionApiClient, new InMemoryMerchantDetailsRepository(), transactionRepository);
    //     RestAssuredMockMvc.standaloneSetup(transactionController);  // Establece el controlador para las pruebas
    // }

    // @Test
    // @WithMockUser(username = "nbcrocker", password = "abc", roles = "read")
    // public void testApplicationEndToEnd() throws Exception {
    //     // Creamos una transacción de ejemplo.
    //     var transaction = createTransaction();
        
    //     // Simulamos la respuesta del servicio `TransactionApiClient`.
    //     when(transactionApiClient.findAllByAccountNumber(anyInt())).thenReturn(Arrays.asList(transaction));

    //     // Realizamos la solicitud GET al endpoint de transacciones.
    //     var response = given()
    //             .accept(MediaType.APPLICATION_JSON_VALUE)
    //             .when()
    //             .get(String.format("http://localhost:%s/api/v1/transactions/1234567", port))
    //             .then()
    //             .statusCode(200)
    //             .extract()
    //             .body()
    //             .as(Transaction[].class);

    //     // Verificamos que la transacción contiene la cantidad esperada.
    //     assertThat(response[0].getAmount(), equalTo(100.00d));
    // }

    // private Transaction createTransaction() {
    //     // Método que crea una transacción simulada.
    //     Transaction transaction = new Transaction();
    //     transaction.setAccountNumber(1234567);
    //     transaction.setType("DEBIT");
    //     transaction.setAmount(100.00d);
    //     transaction.setMerchantName("acme");
    //     transaction.setMerchantLogo("http://someurl.com/logo");
    //     return transaction;
    // }
}
