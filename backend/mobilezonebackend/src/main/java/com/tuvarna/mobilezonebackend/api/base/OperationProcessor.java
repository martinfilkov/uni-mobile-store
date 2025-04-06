package com.tuvarna.mobilezonebackend.api.base;

import io.vavr.control.Either;
import org.springframework.validation.Errors;

public interface OperationProcessor<S extends OperationInput, T extends OperationResult>{
    T process(S input);
}
