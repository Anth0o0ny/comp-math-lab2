package com.anth0o0ny.solving.equations;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.anth0o0ny.functions.equations.Function;

public class HalfDivisionMethod implements EquationMethod {
    private final int MAX_ITERATION = 1000000;

    @Override
    public ObjectNode solve(double a, double b, double eps, Function function) {
        ObjectNode node = new ObjectMapper().createObjectNode();

        int iterations = 0;
        double x;
        double futX;
        double answer;

        do {

            x = calculateX(a, b);
            if (function.func(a) * function.func(x) > 0) {
                a = x;
            } else {
                b = x;
            }
            x = calculateX(a, b);
            answer = x;
            iterations++;
//            if (iterations == MAX_ITERATION) {
//                node.put("error", "Метод половинного деления не справился за " + MAX_ITERATION + " итераций.");
//                return node;
//            }

        } while (Math.abs(a - b) > eps || Math.abs(function.func(x)) > eps);

        if (Double.isNaN(answer) || Double.isNaN(function.func(answer))) {
            node.put("error", "Метод половинного деления разошелся на " + iterations + " итерации. Попробуйте изменить приближение epsilon.");
            return node;
        }

        node.put("x", answer);
        node.put("f(x)", function.func(answer));
        node.put("iterations", iterations);

        return node;
    }

    private double calculateX(double a, double b) {
        return (a+b) / 2;
    }

}
