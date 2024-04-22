package com.leetcode.medium.math;

import java.util.ArrayList;
import java.util.List;

public class _1447_Simplified_Fractions {
    //https://leetcode.com/problems/simplified-fractions/
    //1447. Simplified Fractions

    int gcd(int a, int b) {
        if (b == 0) return a;
        return  gcd(b, a % b);
    }

    public List<String> simplifiedFractions(int n) {
        List<String> numbers = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                if (gcd(i, j) != 1) continue;
                numbers.add(j + "/" + i);
            }
        }
        return numbers;
    }

    public static void main(String[] args) {
        var sol = new _1447_Simplified_Fractions();
        System.out.println(sol.simplifiedFractions(3));
    }
}
