package com.vitdo82.demo.shuffle.services;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class RandomGenerator {

    public List<Integer> generateRandomNumber(Integer toNumber) {

        // TODO: Implement random number generation

        Random random = new Random();
        return List.of(random.nextInt(toNumber));
    }
}
