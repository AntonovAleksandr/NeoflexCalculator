package com.company.calck.service.impl;

import com.company.calck.data.OperationListFactory;
import com.company.calck.service.CalculationService;
import com.company.calck.service.OperationService;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class BinOpCalckulationServiceImpl implements CalculationService {

    private final Map<String, OperationService> operations = OperationListFactory.getOperationList();

    @Override
    public Double calculate(Double a, Double b, String operationName) throws Exception {
        if (operationName == null || operationName.isEmpty())
            throw new NullPointerException("operator is not present!");
        else if (!operations.containsKey(operationName))
            throw new NullPointerException("Unknown operator!");
        if (a == null)
            throw new NullPointerException("a is not present!");
        if (b == null)
            throw new NullPointerException("b is not present!");
        return operations.get(operationName).calckulation(a, b);
    }
}
