package com.company.array;

import java.util.Arrays;

public class _1389_Create_Target_Array_in_the_Given_Order {
    public static int[] createTargetArray(int[] nums, int[] index) {
        int[] s = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            s[i] = -1;
        }
        for (int i = 0; i < nums.length; i++) {
            int ind = index[i];
            int value = nums[i];
            if (s[ind] != -1) {
                int prev = s[ind];
                for (int j = ind + 1; j < nums.length; j++) {
                    int a = s[j];
                    s[j] = prev;
                    prev = a;
                }
            }
            s[ind] = value;
        }
        return s;
    }

    public static void main(String[] args) {
        /*
[0,1,0]
[0,1,0]
        * */
        int[] v = {0,1,0};
        int[] i = {0,1,0};

        System.out.println(Arrays.toString(createTargetArray(v, i)));
    }
}
