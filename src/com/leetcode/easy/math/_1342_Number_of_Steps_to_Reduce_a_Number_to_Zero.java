package com.leetcode.easy.math;

public class _1342_Number_of_Steps_to_Reduce_a_Number_to_Zero {
    public int numberOfSteps(int num) {
        int counter = 0;
        while (num != 0) {
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num--;
            }
            counter++;
        }
        return counter;
    }
}
