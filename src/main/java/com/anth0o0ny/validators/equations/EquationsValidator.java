package com.anth0o0ny.validators.equations;

import com.anth0o0ny.functions.equations.Function;
import com.anth0o0ny.functions.equations.Logarithm;
import com.anth0o0ny.functions.equations.Polynom;
import com.anth0o0ny.functions.equations.Sinus;
import com.anth0o0ny.requestdata.EquationData;
import com.anth0o0ny.solving.equations.HalfDivisionMethod;
import com.anth0o0ny.solving.equations.EquationMethod;
import com.anth0o0ny.solving.equations.SecondMethod;
import com.anth0o0ny.solving.equations.SimpleIterationMethod;

import java.util.HashMap;

public class EquationsValidator {

    private static final HashMap<String, Function> functions = new HashMap<>();
    private static final HashMap<String, EquationMethod> methods = new HashMap<>();

    static {
        functions.put("polynomial", new Polynom());
        functions.put("sinus", new Sinus());
        functions.put("logarithm", new Logarithm());

        methods.put("chord", new HalfDivisionMethod());
        methods.put("secand", new SecondMethod());
        methods.put("simpleIteration", new SimpleIterationMethod());
    }

    public static boolean validateData(EquationData data) {
        try {
            double a = Double.parseDouble(data.getA().replaceAll(",", "."));
            double b = Double.parseDouble(data.getB().replaceAll(",", "."));
            double eps = Double.parseDouble(data.getEps().replaceAll(",", "."));
            if (!(a < b) || eps < 0 || !(functions.containsKey(data.getGraphic()) || !(methods.containsKey(data.getMethod())))) {
                return false;
            }

        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }

    public static Function getFunction(String functionName) {
        return functions.get(functionName);
    }

    public static EquationMethod getMethod(String methodName) {
        return methods.get(methodName);
    }

}
