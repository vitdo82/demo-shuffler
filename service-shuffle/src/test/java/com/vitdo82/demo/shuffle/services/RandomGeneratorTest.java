package com.vitdo82.demo.shuffle.services;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class RandomGeneratorTest {

    @Test
    void shouldGenerateRandomNumberListTest() {
        // when
        RandomGenerator randomGenerator = new RandomGenerator();

        // then
        List<Integer> randomNumbers = randomGenerator.generateRandomNumber(10);
        assertThat(randomNumbers.size()).isEqualTo(10);
        assertThat(randomNumbers).containsOnly(1,2,3,4,5,6,7,8,9,10);
        assertThat(randomNumbers).doesNotContainSequence(1,2,3,4,5,6,7,8,9,10);
    }
}