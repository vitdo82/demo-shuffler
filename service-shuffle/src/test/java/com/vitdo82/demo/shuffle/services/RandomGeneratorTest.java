package com.vitdo82.demo.shuffle.services;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class RandomGeneratorTest {

    @Test
    void generateRandomNumber() {
        RandomGenerator randomGenerator = new RandomGenerator();

        List<Integer> randomNumbers = randomGenerator.generateRandomNumber(10);

        assertThat(randomNumbers.isEmpty()).isFalse();
    }
}