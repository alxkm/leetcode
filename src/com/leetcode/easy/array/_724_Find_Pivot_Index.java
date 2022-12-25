package com.leetcode.easy.array;

public class _724_Find_Pivot_Index {
    public int pivotIndex(int[] nums) {
        int[] p = new int[nums.length + 1];
        int[] s = new int[nums.length + 1];

        for (int i = 1; i <= nums.length; i++) {
            p[i] = p[i - 1] + nums[i - 1];
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            s[i] = s[i + 1] + nums[i];
        }
        //System.out.println(Arrays.toString(p));
        //System.out.println(Arrays.toString(s));

        for (int i = 0; i < nums.length; i++) {
            if (p[i] == s[i + 1]) return i;
        }
        return -1;
    }
}
