package com.anth0o0ny.solving.systems;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.anth0o0ny.functions.systems.System;

public interface SystemMethod {

    public ObjectNode solve(double x, double y, double eps, System system);

}
