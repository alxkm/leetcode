package com.leetcode.easy.math;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _728_Self_Dividing_Numbers {
    static     public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            int x = i;
            boolean div = true;
            while (x > 0) {
                int a = x % 10;
                if (a == 0 || i % a != 0) {
                    div = false;
                    break;
                }
                x = x/10;
            }
            if (div) list.add(i);
        }
        return list;
    }

    public static void main(String[] args) {
        int left = 1, right = 22;

        System.out.println(selfDividingNumbers(left, right));
    }
}
