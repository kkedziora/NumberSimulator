package com.example.simulator.source.number.integer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;


@Component
public class RandomIntegerSource implements IntegerSource {

    private final SecureRandom secureRandom;

    @Autowired
    public RandomIntegerSource() {
        this.secureRandom = new SecureRandom();
    }

    @Override
    public Integer getNumber() {
        return secureRandom.nextInt();
    }
}
