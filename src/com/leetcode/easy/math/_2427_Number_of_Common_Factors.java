package com.company.math;

import java.util.HashSet;
import java.util.Set;

public class _2427_Number_of_Common_Factors {
    public static int commonFactors(int a, int b) {
        var s1 = factors(a);
        var s2 = factors(b);

        s1.retainAll(s2);

        return s1.size();
    }

    public static Set<Integer> factors(int a) {
        Set<Integer> set = new HashSet<>();
        int b = 1;
        while (b <= (a/2 + 1)) {
            if (a % b == 0) set.add(b);
            b++;
        }
        set.add(a);
        return set;
    }

    public static void main(String[] args) {
        int a = 12, b = 6;

        System.out.println(commonFactors(a, b));
    }
}
