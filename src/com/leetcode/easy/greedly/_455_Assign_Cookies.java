package com.leetcode.easy.greedly;

import java.util.Arrays;

public class _455_Assign_Cookies {
    //https://leetcode.com/problems/assign-cookies/
    //455. Assign Cookies

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int counter = 0;
        int k = 0;
        for (int i = 0; i < g.length; i++) {
            for (int j = k; j < s.length; j++) {
                if (g[i] <= s[j]) {
                    counter++;
                    k = j + 1;
                    break;
                }
            }
        }
        return counter;
    }
}
