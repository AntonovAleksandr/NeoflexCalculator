package com.company.calck.service.impl.operations;

import com.company.calck.service.OperationService;
import org.springframework.stereotype.Service;

@Service
public class DivisionService implements OperationService {
    @Override
    public Double calckulation(Double a, Double b) throws ArithmeticException {
        if (b != 0)
            return a / b;
        else throw new ArithmeticException("Division by zero");
    }
}
