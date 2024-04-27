package com.leetcode.medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1291_Sequential_Digits {
    //1291. Sequential Digits
    //https://leetcode.com/problems/sequential-digits/

    private List<Integer> list = new ArrayList<>();
    private int low = 0;
    private int high = 0;

    public List<Integer> sequentialDigits1(int low, int high) {
        List<Integer> list = new ArrayList<>();
        char[] s = Integer.valueOf(low).toString().toCharArray();
        int n = Integer.parseInt(String.valueOf(s));
        while (n <= high) {
            if (s[0] == '9' || s[s.length - 1] == 9) {
                s = new char[s.length + 1];
                Arrays.fill(s, '0');
                s[0] = '1';
            }

            n = Integer.parseInt(String.valueOf(s));
            if (n > high) break;

            boolean isNumber = true;
            for (int i = 1; i < s.length; i++) {
                char ch = (char)((s[i - 1] - '0' + 1) + '0');
                if (ch > '9') {
                    isNumber = false;
                    break;
                }
                s[i] = ch;
                if (s[i] == s[i - 1]) {
                    isNumber = false;
                    break;
                }
            }
            n = Integer.parseInt(String.valueOf(s));
            if (n >= low && n <= high && isNumber) {
                list.add(n);
            }
            s[0]++;
        }

        return list;
    }

    public List<Integer> sequentialDigits(int low, int high) {
        this.low = low;
        this.high = high;
        dfs(new StringBuilder(), 1);
        return list;
    }

    private void dfs(StringBuilder sb, int i) {
        int n = 0;
        if (sb.length() != 0) n = Integer.parseInt(String.valueOf(sb));
        if (i > 9) return;
        if (high < n) return;
        if (low <= n && n <= high) {
            list.add(n);
            return;
        }

        for (int j = i; j <= 9; j++) {
            sb.append(j);
            dfs(sb, j + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        var sol = new _1291_Sequential_Digits();
        System.out.println(sol.sequentialDigits(1000, 13000));
    }
}
