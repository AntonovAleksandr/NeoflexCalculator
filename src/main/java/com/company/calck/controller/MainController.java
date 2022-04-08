package com.company.calck.controller;

import com.company.calck.service.CalculationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/app")
@Api(value = "", tags={"Calkulation (sum, sub, mult, dev)"})
public class MainController {
    @Autowired
    CalculationService calculationService;

    @RequestMapping(value = "calck", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<String> mainPageSort(
            @RequestParam("a") Double a,
            @RequestParam("b") Double b,
            @RequestParam("operator") String operator
    ) {
        try {
            return new ResponseEntity<>(
                    "Result: " + calculationService.calculate(a, b, operator), HttpStatus.OK);
        } catch (ArithmeticException | NullPointerException e) {
            return new ResponseEntity<>(
                    e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(
                    e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}