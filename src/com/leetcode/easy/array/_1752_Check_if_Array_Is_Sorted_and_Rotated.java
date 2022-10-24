package com.company.array;

public class _1752_Check_if_Array_Is_Sorted_and_Rotated {
    static public boolean check(int[] nums) {

        for (int i = 0; i < nums.length - 1; i++) {
            int prevIndex = (1 + i) % nums.length;
            int n = (2 + i) % nums.length;
            if (nums[2] == nums[n])
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
            int[] a = {3,4,5,1,2};

        System.out.println(check(a));

    }
}
