package com.leetcode.medium.math;

public class _670_Maximum_Swap {
    //https://leetcode.com/problems/maximum-swap/
    //TOP
    //FOREIGN_SOLUTION

    public int maximumSwap(int num) {
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
