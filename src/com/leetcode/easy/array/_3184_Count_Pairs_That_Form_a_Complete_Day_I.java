package com.leetcode.easy.array;

public class _3184_Count_Pairs_That_Form_a_Complete_Day_I {
    //3184. Count Pairs That Form a Complete Day I
    //https://leetcode.com/problems/count-pairs-that-form-a-complete-day-i/description/

    public int countCompleteDayPairs(int[] hours) {
        int counter = 0;
        for (int i = 0; i < hours.length; i++) {
            for (int j = i + 1; j < hours.length; j++) {
                if ((hours[i] + hours[j]) % 24 == 0) counter++;
            }
        }
        return counter;
    }
}
