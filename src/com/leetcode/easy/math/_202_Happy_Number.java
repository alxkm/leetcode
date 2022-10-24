package com.leetcode.easy.math;

import java.util.HashSet;
import java.util.Set;

public class _202_Happy_Number {
     static public boolean isHappy(int n) {
        int cnt = 0;
        while (n != 1) {
            int a = n % 10;
            int sum = a * a;
            int d = n / 10;
            while (d != 0) {
                int b = d % 10;
                sum += b * b;
                d /= 10;
            }
            cnt++;
            n = sum;
            if (cnt == 1000) break;
        }
        return n == 1;
    }

    static public boolean isHappy1(int n) {
        Set<Integer> set = new HashSet<>();
        while (n != 1) {
            int a = n % 10;
            int sum = a * a;
            int d = n / 10;
            while (d != 0) {
                int b = d % 10;
                sum += b * b;
                d /= 10;
            }
            n = sum;
            if (set.contains(sum)) break;
            set.add(sum);
        }
        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(isHappy1(116));
    }
}
