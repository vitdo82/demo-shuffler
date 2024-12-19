package com.vitdo82.demo.shuffle.resources;

import com.vitdo82.demo.shuffle.services.LogsClient;
import com.vitdo82.demo.shuffle.services.RandomGenerator;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class NumberGenerateResource {

    private final RandomGenerator randomGenerator;

    private final LogsClient logsClient;

    public NumberGenerateResource(RandomGenerator randomGenerator, LogsClient logsClient) {
        this.randomGenerator = randomGenerator;
        this.logsClient = logsClient;
    }

    @PostMapping("/generate")
    public List<Integer> generate(@RequestBody Integer number) {
        if (number == null || number <= 0) {
            throw new IllegalArgumentException("Number must be positive integer.");
        }
        if (number > 1000) {
            throw new IllegalArgumentException("Number must be less than 1000.");
        }

        List<Integer> generateList = randomGenerator.generateRandomNumber(number);
        logsClient.log(generateList);

        return generateList;
    }
}
