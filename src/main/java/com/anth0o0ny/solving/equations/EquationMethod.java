package com.anth0o0ny.solving.equations;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.anth0o0ny.functions.equations.Function;

public interface EquationMethod {

    public ObjectNode solve(double a, double b, double eps, Function function);

}
