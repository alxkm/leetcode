package com.leetcode.easy.binary;

public class _868_Binary_Gap {
    //https://leetcode.com/problems/binary-gap/
    //868. Binary Gap

    public int binaryGap(int n) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int max = 0;

        while (n > 0) {
            sb.append(n % 2);
            n /= 2;
        }
        sb.reverse();
        System.out.println(sb);

        while (i < sb.length() && sb.charAt(i) != '1') i++;
        int j = i + 1;
        while (j < sb.length()) {
            if (sb.charAt(j) != '0') {
                max = Math.max(j - i, max);
                i = j;
            }
            j++;
        }
        return max;
    }

    public static void main(String[] args) {
        var sol = new _868_Binary_Gap();
        System.out.println(sol.binaryGap(22));
    }
}
