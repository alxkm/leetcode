package com.leetcode.medium.backtrack1;

public class _2698_Find_the_Punishment_Number_of_an_Integer {
    //https://leetcode.com/problems/find-the-punishment-number-of-an-integer/description/
    //2698. Find the Punishment Number of an Integer

    public int punishmentNumber(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (f(i, Integer.valueOf(i * i).toString(), 0, 0)) {
                sum += i * i;
            }
        }
        return sum;
    }

    private boolean f(int n, String num, int i, int cur) {
        if (i == num.length() && cur == n) {
            return true;
        }

        for (int j = i; j < num.length(); j++) {
            int a = Integer.valueOf(num.substring(i, j + 1));
            if (f(n, num, j + 1, a + cur)) return true;
        }
        return false;
    }
}
