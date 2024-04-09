package com.leetcode.top.top175;

public class _1493_Longest_Subarray_of_1_s_After_Deleting_One_Element {
    //https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/
    //1493. Longest Subarray of 1's After Deleting One Element

    //Array
    //Dynamic Programming
    //Sliding Window

    //NOT_OPTIMAL
    //FOREIGN_SOLUTION
    //sliding window
    //TOP

    public int longestSubarray(int[] nums) {
//        int max = 0;
//        boolean used = false;
//        int localMax = 0;
//        for (int i = 0, j = 0; i < nums.length; i++) {
//            if (nums[i] == 1) {
//                localMax++;
//            } else {
//                if (used) {
//                    while (nums[j] != 1 && j < i) {
//                        j++;
//                        localMax--;
//                    }
//                    if (localMax < 0) localMax = 0;
//                } else {
//                    j = i;
//                    used = true;
//                }
//            }
//            max = Math.max(localMax, max);
//        }
//        return localMax != nums.length ? max : max - 1;


            int max = 0;
            boolean used = false;
            int localMax = 0;
            for (int i = 0, j = 0, start = 0; i < nums.length; i++) {
                if (nums[i] == 1) {
                    localMax++;
                } else {
                    if (used) {
                        int counter = 0;
                        while (start <= j) {
                            if (nums[start] == 1) {
                                counter++;
                            }
                            start++;
                        }
                        localMax -= counter;
                        j = i;
                    } else {
                        j = i;
                        used = true;
                    }
                }
                max = Math.max(localMax, max);
            }
            return localMax != nums.length ? max : max - 1;
        }

    public static void main(String[] args) {
        var solution = new _1493_Longest_Subarray_of_1_s_After_Deleting_One_Element();
        int[] ar = new int[] {0,1,1,1,0,1,1,0,1};
        solution.longestSubarray(ar);
    }
}
