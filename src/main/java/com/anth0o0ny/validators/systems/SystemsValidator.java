package com.anth0o0ny.validators.systems;

import com.anth0o0ny.functions.systems.Baseball;
import com.anth0o0ny.functions.systems.System;
import com.anth0o0ny.functions.systems.Tennis;
import com.anth0o0ny.requestdata.SystemData;
import com.anth0o0ny.solving.systems.SimpleIterationMethod;
import com.anth0o0ny.solving.systems.SystemMethod;

import java.util.HashMap;

public class SystemsValidator {

    private static final HashMap<String, System> systems = new HashMap<>();

    private static final HashMap<String, SystemMethod> methods = new HashMap<>();

    static {
        systems.put("baseball", new Baseball());
        systems.put("tennis", new Tennis());

        methods.put("simpleIteration", new SimpleIterationMethod());
    }

    public static boolean validateData(SystemData data) {
        try {
            double x = Double.parseDouble(data.getX().replaceAll(",", "."));
            double y = Double.parseDouble(data.getY().replaceAll(",", "."));
            double eps = Double.parseDouble(data.getEps().replaceAll(",", "."));

            if (eps < 0 || !(systems.containsKey(data.getGraphic())) || !(methods.containsKey(data.getMethod()))) {
                return false;
            }
        } catch (NumberFormatException exception) {
            return false;
        }
        return true;
    }

    public static System getSystem(String systemName) {
        return systems.get(systemName);
    }

    public static SystemMethod getMethod(String methodName) {
        return methods.get(methodName);
    }
}
