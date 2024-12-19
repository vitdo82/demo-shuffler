package com.vitdo82.demo.shuffle.services;

import com.vitdo82.demo.shuffle.ShuffleProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class LogsClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogsClient.class);

    private final RestTemplate restTemplate;
    private final ShuffleProperties shuffleProperties;

    public LogsClient(RestTemplate restTemplate, ShuffleProperties shuffleProperties) {
        this.restTemplate = restTemplate;
        this.shuffleProperties = shuffleProperties;
    }

    @Async
    public CompletableFuture<Void> log(List<Integer> generatedNumbers) {
        LOGGER.info("Send log message: {}, to endpoint: {}", generatedNumbers, shuffleProperties.getLogUrl());
        return CompletableFuture.runAsync(() -> {
            try {
                restTemplate.postForObject(shuffleProperties.getLogUrl(), generatedNumbers, Void.class);
            } catch (Exception e) {
                LOGGER.error("Error sending log message", e);
            }
        });
    }
}
