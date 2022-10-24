package com.leetcode.easy.gold.array;

public class _1374_Generate_a_String_With_Characters_That_Have_Odd_Counts {
    public String generateTheString(int n) {
        StringBuilder sb = new StringBuilder();
        int r = 0;
        if (n % 2 == 0) {
            n = n - 1;
            r = 1;
        }
        for (int i = 0; i < n; i++) {
            sb.append("a");
        }
        if (r != 0) sb.append("b");

        return sb.toString();
    }
}
