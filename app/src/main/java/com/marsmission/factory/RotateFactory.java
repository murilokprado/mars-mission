package com.marsmission.factory;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class RotateFactory {

    static Map<String, Rotation> operationMap = new HashMap<>();

    static {
        operationMap.put("R", new RightRotation());
        operationMap.put("L", new LeftRotation());
    }

    public static Rotation getRotation(String operator) {
        return operationMap.get(operator);
    }
}
