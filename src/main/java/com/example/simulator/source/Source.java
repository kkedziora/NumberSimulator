package com.example.simulator.source;

public interface Source<T> {

    T getValue();

    SourceType getSource();
}
