package com.leetcode.medium.remainder;

public class _1894_Find_the_Student_that_Will_Replace_the_Chalk {
    //1894. Find the Student that Will Replace the Chalk
    //https://leetcode.com/problems/find-the-student-that-will-replace-the-chalk/description/?envType=daily-question&envId=2024-09-02

    public int chalkReplacer(int[] chalk, int k) {
        long sum = 0;
        for (int n: chalk) {
            sum += n;
        }
        if (sum < k) {
            k %= sum;
        } else if (sum == k) {
            return 0;
        }
        int i = 0;
        while (i < chalk.length && k >= chalk[i]) {
            k -= chalk[i];
            i++;
        }
        return i;
    }
}
