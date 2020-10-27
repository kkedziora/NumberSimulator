package com.example.simulator.source;

import com.example.simulator.operation.GeneratedValue;

public interface Source {

    GeneratedValue getValue();

    SourceType getSource();
}
