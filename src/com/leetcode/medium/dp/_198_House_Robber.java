package com.leetcode.medium.dp;

public class _198_House_Robber {
    static public int rob(int[] nums) {
        int rob1 = 0;
        int rob2 = 0;
        for (int n : nums) {
            int temp = Math.max(n + rob1, rob2);
            rob1 = rob2;
            rob2 = temp;
            System.out.println(String.format("rob1 {%s} , rob2 {%s}", rob1, rob2));
        }
        return rob2;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(rob(nums));
    }
}
