package com.leetcode.medium.slidingwindow;

public class _930_Binary_Subarrays_With_Sum {
    //930. Binary Subarrays With Sum
    //https://leetcode.com/problems/binary-subarrays-with-sum/
    //https://leetcode.com/problems/count-number-of-nice-subarrays/

    public int numSubarraysWithSum(int[] nums, int goal) {
        int counter = 0;
        int s = 0;

        for (int i = 0, j = 0; j < nums.length && i < nums.length;) {
            s += nums[j];
            if (nums[j] == goal) counter++;
            if (s == goal) counter++;

            if (s < goal) {
                s += nums[j];
                j++;
            } else {
                s -= nums[i];
                i++;
            }

        }
        return counter;
    }

    public int numSubarraysWithSum1(int[] nums, int goal) {
        return find(nums, goal) - find(nums, goal - 1);
    }

    public int find(int[] nums, int k) {
        int l = 0, r = 0, sum = 0, cnt = 0;
        while (r < nums.length) {
            sum += nums[r];

            while (sum > k) {
                sum = sum - nums[l];
                l++;
            }
            cnt += (r - l + 1);
            r++;
        }
        return cnt;
    }
}
