package com.college.calculator.service;

import java.util.function.DoubleBinaryOperator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CalculatorService {

    public double calculate(double a, double b, DoubleBinaryOperator operation) {
        return operation.applyAsDouble(a, b);
    }

    public DoubleBinaryOperator addition() {
        return Double::sum;
    }

    public DoubleBinaryOperator subtraction() {
        return (a, b) -> a - b;
    }

    public DoubleBinaryOperator multiplication() {
        return (a, b) -> a * b;
    }

    public DoubleBinaryOperator division() {
        return (a, b) -> {
            if (b == 0) throw new IllegalArgumentException("Division by zero is not allowed.");
            return a / b;
        };
    }

    public DoubleBinaryOperator exponentiation() {
        return Math::pow;
    }
}
