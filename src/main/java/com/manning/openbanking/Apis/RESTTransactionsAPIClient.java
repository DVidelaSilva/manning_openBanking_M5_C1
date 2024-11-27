package com.manning.openbanking.Apis;

import io.manning.openbanking.models.OBReadTransaction6;

import com.fasterxml.jackson.databind.JsonNode;
import com.manning.openbanking.adapters.openbanking.OBTransactionAdapter;
import com.manning.openbanking.entities.Transaction;
import com.manning.openbanking.repositories.TransactionApiClient;
import org.springframework.http.HttpHeaders;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;


import java.util.Collections;
import java.util.List;

import static java.util.stream.Collectors.toList;

import java.util.Base64;

@Slf4j
@Repository
public class RESTTransactionsAPIClient implements TransactionApiClient{
    
    private final WebClient client;

    //private OAuthTokenResponse  oAuthTokenResponse;

    private final OBTransactionAdapter adapter = new OBTransactionAdapter();

    // URL red de prueba


    // credenciales
    private final String clientId = "better-banking";
    private final String clientSecret = "7yrbR8XpY45bcKPP";


    @Autowired
    public RESTTransactionsAPIClient(WebClient client) {
        this.client = client;
    }
    

    @Override
    public List<Transaction> findAllByAccountNumber(Integer accountNumber) {
        OBReadTransaction6 res = null;
        log.info(clientId);
        String encodedClientData = Base64.getEncoder().encodeToString(String.format("%s:%s", clientId, clientSecret).getBytes());
        log.info(encodedClientData);
        //System.out.println(encodedClientData);

        String authorizationHeader = "Basic " + encodedClientData;
        log.info("Authorization header: {}", authorizationHeader); 
        try {
            res = client
                .post()
                .uri("/oauth/token")
                .header(HttpHeaders.AUTHORIZATION, authorizationHeader)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .bodyValue("grant_type=client_credentials")
                .retrieve()
                .bodyToMono(JsonNode.class)
                .flatMap(tokenResponse -> {
                    String accessTokenValue = tokenResponse.get("access_token")
                                .textValue();
                    return client.get()
                            .uri("accounts/" + accountNumber + "/transactions")
                            .headers(h -> h.setBearerAuth(accessTokenValue))
                            .retrieve()
                            .bodyToMono(OBReadTransaction6.class);   
                })
                .block();
        } catch (Exception e) {
            log.error("No se pudieron recuperar los datos de la cuenta del servidor remoto debido al siguiente error {}", e.getMessage());
        }

        if (res == null || res.getData() == null) {
            return Collections.emptyList();
        }

        return res.getData()
                .getTransaction()
                .stream()
                .map(adapter::adapt)
                .collect(toList());
    }


}