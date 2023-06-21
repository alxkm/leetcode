package com.leetcode.easy.math;

import java.math.BigInteger;

public class _2525_Categorize_Box_According_to_Criteria {
    //https://leetcode.com/problems/categorize-box-according-to-criteria/

    public String categorizeBox(int length, int width, int height, int mass) {
        boolean isBulky = false;
        boolean isHeavy = false;
        if (mass >= 100) isHeavy = true;
        int volume = BigInteger.valueOf(length)
                .multiply(BigInteger.valueOf(width))
                .multiply(BigInteger.valueOf(height))
                .compareTo(BigInteger.valueOf(1000000000));
        if ((length >= 10000 || width >= 10000 || height >= 10000)
                || volume == 0 || volume == 1) isBulky = true;
        System.out.println(volume);
        if (isBulky && isHeavy) return "Both";
        if (isBulky) return "Bulky";
        if (isHeavy) return "Heavy";

        return "Neither";
    }
}
