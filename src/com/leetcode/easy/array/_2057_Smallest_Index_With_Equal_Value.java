package com.company.array;

public class _2057_Smallest_Index_With_Equal_Value {
    static     public int smallestEqual(int[] nums) {
        int min = 100;
        for (int i = 0; i < nums.length; i++) {
            if (i % 10 == nums[i]) {
                min = Math.min(min, i);
            }
        }
        return min == 100 ? -1 : min;
    }

    public static void main(String[] args) {
        int[] a = {0,1,2};

        System.out.println(smallestEqual(a));
    }
}
