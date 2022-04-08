package com.company.calck.data;

import com.company.calck.service.OperationService;
import com.company.calck.service.impl.operations.AdditionService;
import com.company.calck.service.impl.operations.DivisionService;
import com.company.calck.service.impl.operations.MultiplicationService;
import com.company.calck.service.impl.operations.SubtractionService;

import java.util.HashMap;
import java.util.Map;

public class OperationListFactory{
    private static Map<String, OperationService> instance;

    private static void add(String sortName, OperationService sorting) {
        instance.put(sortName, sorting);
    }

    private static void newMap(){
        instance = new HashMap<>();
        add("sum", new AdditionService());
        add("sub", new SubtractionService());
        add("dev", new DivisionService());
        add("mult", new MultiplicationService());
    }

    public static Map<String, OperationService> getOperationList() {
        if (instance == null)
            newMap();
        return instance;
    }
}
