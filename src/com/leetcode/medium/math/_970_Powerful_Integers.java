package com.leetcode.medium.math;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _970_Powerful_Integers {
    //970. Powerful Integers
    //https://leetcode.com/problems/powerful-integers/

    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 50; i++) {
            int a = (int)Math.pow(x, i);
            if (a > bound) break;
            int diff = bound - a;

            for (int j = 0; j < 50; j++) {
                int b = (int)Math.pow(y, j);
                if (diff < b) break;;
                int n = a + b;
                set.add(n);
            }
        }
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        var sol = new _970_Powerful_Integers();
        System.out.println(sol.powerfulIntegers(2, 3, 10));
    }
}
