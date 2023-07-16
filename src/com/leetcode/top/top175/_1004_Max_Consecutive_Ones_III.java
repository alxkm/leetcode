package com.leetcode.top.top175;

public class _1004_Max_Consecutive_Ones_III {
    //https://leetcode.com/problems/max-consecutive-ones-iii/
    //NOT_OPTIMAL
    //sliding window

    public int longestOnes(int[] nums, int k) {
        int tempK = 0;
        int onesCounter = 0;
        int max = k;
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] == 1 && tempK <= k) {
                onesCounter++;
            } else if (nums[i] == 0 && tempK < k) {
                tempK++;
                onesCounter++;
            } else if (nums[i] == 0 && tempK == k) {
                if (tempK == k) {
                    while (nums[j] != 0 && j <= i) {
                        onesCounter--;
                        j++;
                    }
                    if (j <= i && (nums[j] == 0)) {
                        j++;
                        onesCounter--;
                        tempK--;
                    }
                }
                onesCounter++;
                max = Math.max(onesCounter, max);
                tempK++;
            }
            max = Math.max(onesCounter, max);
        }
        return max;
    }

    public static void main(String[] args) {
        //int[] ar = new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int[] ar = new int[]{0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        var solution = new _1004_Max_Consecutive_Ones_III();
        //int k = 2;
        int k = 3;
        System.out.println(solution.longestOnes(ar, k));
    }
}
