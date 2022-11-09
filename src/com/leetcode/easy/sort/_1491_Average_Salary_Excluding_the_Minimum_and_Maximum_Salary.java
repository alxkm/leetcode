package com.leetcode.easy.sort;

import java.util.Arrays;

public class _1491_Average_Salary_Excluding_the_Minimum_and_Maximum_Salary {
    public double average(int[] salary) {
        Arrays.sort(salary);

        double sum = 0;
        for (int i = 1; i < salary.length - 1; i++) {
            sum += salary[i];
        }
        return sum / (salary.length - 2);
    }
}
