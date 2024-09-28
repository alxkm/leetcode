package com.leetcode.medium.slidingwindow;

public class _2134_Minimum_Swaps_to_Group_All_1_s_Together_II {
    //2134. Minimum Swaps to Group All 1's Together II
    //https://leetcode.com/problems/minimum-swaps-to-group-all-1s-together-ii/description/

    public int minSwaps(int[] nums) {
        int totalOnes = 0;
        for (int i = 0; i < nums.length; i++) totalOnes += nums[i] == 1 ? 1 : 0;

        int onesCount = nums[0];
        int end = 0;

        int minimumSwaps = nums.length;

        for (int start = 0; start < nums.length; ++start) {
            // Adjust onesCount by removing the element that is sliding out of
            // the window
            if (start != 0) {
                onesCount -= nums[start - 1];
            }

            // Expand the window to the right until it reaches the desired size
            while (end - start + 1 < totalOnes) {
                end++;
                onesCount += nums[end % nums.length];
            }
            minimumSwaps = Math.min(minimumSwaps, totalOnes - onesCount);
        }

        return minimumSwaps;
    }
}
