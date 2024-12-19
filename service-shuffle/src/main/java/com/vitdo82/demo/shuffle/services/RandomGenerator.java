package com.vitdo82.demo.shuffle.services;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Service
public class RandomGenerator {

    public List<Integer> generateRandomNumber(Integer toNumber) {
        Random random = new Random();
        Integer[] resultArray = new Integer[toNumber];

        for (int i = 0; i < toNumber; i++) {
            resultArray[i] = i + 1;
        }
        for (int i = 0; i < toNumber; i++) {
            int randomIndex = random.nextInt(toNumber);
            int tmpValue = resultArray[i];
            resultArray[i] = resultArray[randomIndex];
            resultArray[randomIndex] = tmpValue;
        }
        return Arrays.asList(resultArray);
    }
}
