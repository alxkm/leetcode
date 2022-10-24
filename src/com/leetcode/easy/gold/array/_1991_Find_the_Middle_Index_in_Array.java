package com.company.gold.array;

public class _1991_Find_the_Middle_Index_in_Array {
    static public int findMiddleIndex(int[] nums) {
        int sum = nums[0];
        int sumWithoutLast= 0;
        int sumWithoutFirst = 0;
        if (nums.length == 2 && (nums[0] == 0 && nums[1] != 0)) return 1;
        if (nums.length == 2 && (nums[0] != 0 && nums[1] == 0)) return 0;
        boolean allNulls = true;
        for (int i = 0; i < nums.length; i++) {
            if (i != 0) sumWithoutFirst += nums[i];
            if (i != nums.length - 1) sumWithoutLast += nums[i];
            if (nums[i] != 0) allNulls = false;

        }
        if (allNulls) return 0;
        if (sumWithoutFirst == 0) return 0;
        for (int i = 1; i < nums.length; i++) {
            int afterSum = 0;

            for (int j = i + 1; j < nums.length; j++) {
                afterSum += nums[j];
            }
            if (afterSum == sum) return i;
            sum += nums[i];
        }

        if (sumWithoutLast == 0) return nums.length -1;
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {3,2,-1,-4,8};    //1
        //int[] a = {4,2,1,-3};       //0
        //int[] a = {0,0,0,0};        //0
        //int[] a = {1};              //0
        //int[] a = {4, 0};           //0
        //int[] a = {0, 4};           //1
        //int[] a = {1, 1};           //-1
        //int[] a = {4,-4,-1,3,0,3,-5,2,3,-2,1};
        System.out.println(findMiddleIndex(a));
    }
}
