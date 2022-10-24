package com.company.array;

import java.util.ArrayList;
import java.util.List;

public class _1909_Remove_One_Element_to_Make_the_Array_Strictly_Increasing {
    static public boolean canBeIncreasing(int[] nums) {

        int prev = nums[0];
        int[] a = new int[nums.length - 1];
        int[] b = new int[nums.length - 1];

        int v1 = -1;
        int v2 = -1;

        for (int i = 1; i < nums.length; i++) {
            if (prev >= nums[i]) {
                v1 = i;
                v2 = i - 1;
                break;
            } else {
                prev = nums[i];
            }
        }
        if (v1 != -1) {
            for (int i = 0, j = 0, t = 0; i < nums.length; i++) {
                if (i != v1) {
                    a[j] = nums[i];
                    j++;
                }
                if (i != v2) {
                    b[t] = nums[i];
                    t++;
                }
            }
        } else {
            return true;
        }
        int preva = a[0];
        int prevb = b[0];
        boolean b1 = true, b2 = true;

        for (int i = 1; i < a.length; i++) {
            if (preva >= a[i]) {
                b1 = false;
            } else {
                preva = a[i];
            }

            if (prevb >= b[i]) {
                b2 = false;
            } else {
                prevb = b[i];
            }
        }
        return b1 || b2;
    }


    public boolean canBeIncreasing1(int[]nums) {

        int cnt = 0;
        for (int i = 1; i < nums.length && cnt < 2; ++i) {
            if (nums[i - 1] >= nums[i]) {
                ++cnt;
                if (i > 1 && nums[i - 2] >= nums[i])
                    nums[i] = nums[i - 1];
            }
        }
        return cnt < 2;
    }

    public static void main(String[] args) {
       // int [] a = {1, 10, 10, 11, 7};
        //int [] a = {1, 2, 1, 4, 2};
        int [] a = {1, 1};
        System.out.println(canBeIncreasing(a));

    }
}
