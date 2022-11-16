package com.leetcode.easy.math;

public class _2469_Convert_the_Temperature {
    public double[] convertTemperature(double celsius) {
        double[] temperatures = new double[2];

        temperatures[0] = celsius + 273.15;
        temperatures[1] = celsius*1.80 + 32.00;

        return temperatures;
    }
}
