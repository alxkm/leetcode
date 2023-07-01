package com.leetcode.medium.math;

public class _319_Bulb_Switcher {
    //https://leetcode.com/problems/bulb-switcher/

    public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);

        // if (n == 0) return 0;
        // int counter = 1;
        // for (int i = 2; i <= n; i++) {
        //     int div = findDivisors(i);
        //     if (div % 2 != 0) counter++;
        // }
        // return counter;
    }

    static int findDivisors(int n) {
        int counter = 0;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                if (n / i == i) {
                    counter++;
                } else {
                    counter += 2;
                }
            }
        }
        return counter;
    }
}
