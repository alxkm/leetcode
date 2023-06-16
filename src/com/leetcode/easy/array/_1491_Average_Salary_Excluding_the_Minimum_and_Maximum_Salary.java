package com.leetcode.easy.array;

public class _1491_Average_Salary_Excluding_the_Minimum_and_Maximum_Salary {
    //https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/

    public double average(int[] salary) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;

        for (int i = 0; i < salary.length; i++) {
            max = Math.max(max, salary[i]);
            min = Math.min(min, salary[i]);
            sum += salary[i];
        }
        return (double)(sum - max - min) / (salary.length - 2);
    }
}
