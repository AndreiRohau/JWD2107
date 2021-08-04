package com.jwdl;

public class CircleProcessor {
    public static final double PI_CUSTOM = 3.14666666;

    public static double findArea(int radius) {
        double result = 0.0d;

        result = PI_CUSTOM * (radius * radius);

        return result;
    }

    public static double findCircleLength(int radius) {
        double result = 0.0d;

        result = PI_CUSTOM * radius * 2;

        return result;
    }
}
