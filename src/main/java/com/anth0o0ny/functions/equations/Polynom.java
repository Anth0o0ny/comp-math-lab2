package com.anth0o0ny.functions.equations;

public class Polynom extends Function {

    @Override
    public double func(double x) {
        return -0.38 * x * x * x - 3.42 * x * x + 2.51 * x + 8.75;
    }

    @Override
    public double firstDerivative(double x) {
        return -1.14 * x * x - 6.84 * x + 2.51;
    }

    @Override
    public double secondDerivative(double x) {
        return -2.28 * x - 6.84;
    }

}
