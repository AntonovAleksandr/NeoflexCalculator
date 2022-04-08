package com.company.calck.service;

import java.util.Optional;

public interface CalculationService {
    Double calculate(Double a, Double b, String operationName) throws Exception;
}
