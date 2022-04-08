package com.company.calck.service.impl.operations;

import com.company.calck.service.OperationService;
import org.springframework.stereotype.Service;

@Service
public class MultiplicationService implements OperationService {
    @Override
    public Double calckulation(Double a, Double b) {
        return a * b;
    }
}

