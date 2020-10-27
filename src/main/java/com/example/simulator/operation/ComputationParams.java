package com.example.simulator.operation;

import com.example.simulator.source.SourceType;

import java.util.Objects;
import java.util.Set;


public class ComputationParams {

    private final OperationType operationType;
    private final Set<SourceType> allowedSources;

    public ComputationParams(OperationType operationType, Set<SourceType> allowedSources) {
        if (allowedSources.size() < 2) {
            throw new IllegalArgumentException("Illegal number of sources");
        }
        this.operationType = operationType;
        this.allowedSources = allowedSources;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public Set<SourceType> getAllowedSources() {
        return allowedSources;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComputationParams that = (ComputationParams) o;
        return operationType == that.operationType &&
                Objects.equals(allowedSources, that.allowedSources);
    }

    @Override
    public int hashCode() {
        return Objects.hash(operationType, allowedSources);
    }
}
