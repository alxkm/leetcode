package com.leetcode.medium.hard;

import java.util.Arrays;

public class _670_Maximum_Swap {
    //https://leetcode.com/problems/maximum-swap/
    //https://leetcode.com/problems/maximum-swap/?envType=daily-question&envId=2024-10-17
    //670. Maximum Swap
    //TOP
    //FOREIGN_SOLUTION

    public int maximumSwap(int num) {
        char[] ch = Integer.valueOf(num).toString().toCharArray();
        int[][] ar = new int[ch.length][2];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = new int[] {ch[i], i};
        }
        Arrays.sort(ar, (x, y) -> y[0] - x[0]);
        System.out.println(Arrays.deepToString(ar));
        for (int i = 0; i < ar.length; i++) {
            if (ch[i] != ar[i][0]) {
                int j = i;
                while (j + 1 < ar.length && ar[j][0] == ar[j + 1][0]) j++;
                char c = ch[i];
                ch[i] = (char)ar[j][0];
                ch[ar[j][1]] = c;
                break;
            }
        }
        return Integer.parseInt(new String(ch));
    }

    public int maximumSwap1(int num) {
        if (num <= 11) return num;
        String s = num + "";
        boolean gt = false;
        int max = num;
        char[] ch = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (ch[i] < ch[j]) {
                    gt = true;
                    swap(ch, i, j);
                    int newNum = Integer.parseInt(String.valueOf(ch));
                    max = Math.max(max, newNum);
                    swap(ch, i, j);
                }
            }
            if (gt) return max;
        }
        return num;
    }

    private void swap(char[] ch, int i, int j) {
        char cht = ch[j];
        ch[j] = ch[i];
        ch[i] = cht;
    }

    public static void main(String[] args) {
        var sol = new _670_Maximum_Swap();
        System.out.println(sol.maximumSwap(98368));
    }
}
