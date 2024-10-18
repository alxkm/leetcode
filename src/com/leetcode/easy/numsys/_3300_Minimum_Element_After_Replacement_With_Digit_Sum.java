package com.leetcode.easy.numsys;

public class _3300_Minimum_Element_After_Replacement_With_Digit_Sum {
    //https://leetcode.com/problems/minimum-element-after-replacement-with-digit-sum/description/
    //3300. Minimum Element After Replacement With Digit Sum

    public int minElement(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int n: nums) {
            int n1 = 0;

            while (n > 0) {
                n1 += n % 10;
                n /= 10;
            }

            if (n1 < min) min = n1;
        }

        return min;
    }
}
