package com.company.string;

public class _1295_Find_Numbers_with_Even_Number_of_Digits {
    public int findNumbers(int[] nums) {
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (String.valueOf(nums[i]).length() % 2 == 0) counter++;
        }
        return counter;
    }
}
