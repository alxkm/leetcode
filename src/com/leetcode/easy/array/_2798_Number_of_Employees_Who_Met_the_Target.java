package com.leetcode.easy.array;

public class _2798_Number_of_Employees_Who_Met_the_Target {
    //https://leetcode.com/problems/number-of-employees-who-met-the-target/description/
    //2798. Number of Employees Who Met the Target

    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int count = 0;
        for (int i = 0; i < hours.length; i++) {
            if (hours[i] >= target) count++;
        }
        return count;
    }
}
