package com.college.calculator.controller;

import com.college.calculator.service.CalculatorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/math")
@Slf4j
public class CalculatorController {

    private final CalculatorService calculatorService;

    @RequestMapping("/add")
    public ResponseEntity<Double> add(@RequestParam double a, @RequestParam double b) {
        double result = calculatorService.calculate(a, b, calculatorService.addition());
        return ResponseEntity.ok(result);
    }

    @RequestMapping("/subtract")
    public ResponseEntity<Double> subtract(@RequestParam double a, @RequestParam double b) {
        double result = calculatorService.calculate(a, b, calculatorService.subtraction());
        return ResponseEntity.ok(result);
    }

    @RequestMapping("/multiply")
    public ResponseEntity<Double> multiply(@RequestParam double a, @RequestParam double b) {
        double result = calculatorService.calculate(a, b, calculatorService.multiplication());
        return ResponseEntity.ok(result);
    }

    @RequestMapping("/divide")
    public ResponseEntity<Double> divide(@RequestParam double a, @RequestParam double b) {
        if (b == 0) {
            return ResponseEntity.badRequest().body(null);
        }
        double result = calculatorService.calculate(a, b, calculatorService.division());
        return ResponseEntity.ok(result);
    }

    @RequestMapping("/exponent")
    public ResponseEntity<Double> exponent(@RequestParam double a, @RequestParam double b) {
        double result = calculatorService.calculate(a, b, calculatorService.exponentiation());
        return ResponseEntity.ok(result);
    }

}
