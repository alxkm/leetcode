package com.company.ennumeration;

public class _2176_Count_Equal_and_Divisible_Pairs_in_an_Array {
    static public int countPairs(int[] nums, int k) {
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if ((i < j) && (nums[i] == nums[j]) && ((i * j) % k == 0)) {
                    counter++;
                }
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4};
        System.out.println(countPairs(a, 1));
    }
}
