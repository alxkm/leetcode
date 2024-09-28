package com.leetcode.easy.numsys;

import java.util.ArrayList;
import java.util.List;

public class _476_Number_Complement {
    //476. Number Complement
    //https://leetcode.com/problems/number-complement/description/

    static public int findComplement(int num) {
        int a = 0;

        List<Integer> l = new ArrayList<>();
        while (num > 0) {
            l.add(num % 2 == 1 ? 0 : 1);
            num = num/2;
        }

        for (int i = 0; i < l.size(); i++) {
            a += l.get(i) * (int)Math.pow(2, i);
        }

        return a;
    }

    public int findComplement1(int num) {
        int s = 0;
        int two = 1;

        while (num > 0) {
            int r = (num % 2 == 1) ? 0 : 1;
            num /= 2;
            s += r * two;
            two *= 2;
        }

        return s;
    }

    public static void main(String[] args) {
        System.out.println(findComplement(5));
    }
}
