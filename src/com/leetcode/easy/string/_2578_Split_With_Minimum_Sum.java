package com.leetcode.easy.string;

import java.util.Arrays;

public class _2578_Split_With_Minimum_Sum {
    //https://leetcode.com/problems/split-with-minimum-sum/

    public int splitNum(int num) {
        String s = Integer.valueOf(num).toString();
        int[] a = new int[s.toCharArray().length];
        System.out.println(a.length);
        for (int i = 0; i < s.length(); i++) {
            a[i] = s.charAt(i) - '0';
        }
        Arrays.sort(a);
        StringBuilder n1 = new StringBuilder();
        StringBuilder n2 = new StringBuilder();

        for (int i = 0; i < a.length; i++) {
            if (i % 2 == 0) {
                n1.append(a[i]);
            } else {
                n2.append(a[i]);
            }
        }
        return Integer.parseInt(n1.toString()) + Integer.parseInt(n2.toString());
    }
}
