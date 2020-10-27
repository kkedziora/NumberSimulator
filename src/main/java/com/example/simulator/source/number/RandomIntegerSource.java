package com.example.simulator.source.number;

import com.example.simulator.operation.GeneratedValue;
import com.example.simulator.source.Source;
import com.example.simulator.source.SourceType;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;


@Component
public class RandomIntegerSource implements Source {

    private final SecureRandom secureRandom;

    public RandomIntegerSource() {
        this.secureRandom = new SecureRandom();
    }

    @Override
    public GeneratedValue getValue() {
        int randomValue = secureRandom.nextInt();
        return new GeneratedValue(randomValue);
    }

    @Override
    public SourceType getSource() {
        return SourceType.SYSTEM;
    }
}
