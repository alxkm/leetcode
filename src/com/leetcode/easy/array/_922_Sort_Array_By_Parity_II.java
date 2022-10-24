package com.leetcode.easy.array;

import java.util.Arrays;

public class _922_Sort_Array_By_Parity_II {
    static public int[] sortArrayByParityII(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if ((i % 2 == 0 && nums[i] % 2 == 0) ||
                    (i % 2 != 0 && nums[i] % 2 != 0)) {
                continue;
            }
            int state = 0;
            //search even with not even
            if (!(i % 2 == 0)) state = 1;
            //search not even with even
            int j = i + 1;
            while (j < nums.length) {
                if (state == 1 && (j % 2 == 0 && nums[j] % 2 != 0)) {
                    int a = nums[i];
                    nums[i] = nums[j];
                    nums[j] = a;
                    break;
                } else if (state == 0 && (j % 2 != 0 && nums[j] % 2 == 0)) {
                    int a = nums[i];
                    nums[i] = nums[j];
                    nums[j] = a;
                    break;
                }
                j++;
            }
        }
        return nums;

//        for (int i = 0, j = nums.length - 1; i < j;) {
//            if ((i % 2 == 0 && nums[i] % 2 == 0) ||
//                    (i % 2 != 0 && nums[i] % 2 != 0)) {
//                i++;
//                continue;
//            }
//            if ((j % 2 == 0 && nums[j] % 2 == 0) ||
//                    (j % 2 != 0 && nums[j] % 2 != 0)) {
//                j--;
//                continue;
//            }
//
//            int a = nums[i];
//            nums[i] = nums[j];
//            nums[j] = a;
//        }
//        return nums;
    }

    static public int[] sortArrayByParityII_1(int[] nums) {
        int i = 0;
        int j = 1;

        while (i < nums.length && j < nums.length) {
            while (i < nums.length && nums[i] % 2 == 0) i += 2;
            while (j < nums.length && nums[j] % 2 == 1) j += 2;

            if (i < nums.length && j < nums.length) {
                int a = nums[i];
                nums[i] = nums[j];
                nums[j] = a;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] a = {2,3,1,1,4,0,0,4,3,3};
        //System.out.println(Arrays.toString(sortArrayByParityII(a)));
        System.out.println(Arrays.toString(sortArrayByParityII_1(a)));
    }
}
