package com.company.array;

public class _2239_Find_Closest_Number_to_Zero {
    public int findClosestNumber(int[] nums) {
        int neg = -100000;
        int pos = 1000000;
        boolean isNegative = false;
        boolean isPositive = false;
        for (int n : nums) {
            if (n < 0) {
                isNegative = true;
                neg = Math.max(neg, n);
            } else {
                isPositive = true;
                pos = Math.min(pos, n);
            }
        }
        if (isPositive && isNegative) {
            int b = Math.abs(neg);
            if (pos > b) return neg;
            return pos;
        } else if (isNegative) {
            return neg;
        }
        return pos;
    }
}
