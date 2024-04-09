package com.leetcode.top.top175;

public class _209_Minimum_Size_Subarray_Sum {
    //https://leetcode.com/problems/minimum-size-subarray-sum/
    //209. Minimum Size Subarray Sum
    //todo todo

    //better
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        while (sum < target && end < nums.length) {
            sum += nums[end];
            end++;
            while (sum >= target) {
                min = Math.min(min, end - start);
                sum -= nums[start];
                start++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public int minSubArrayLen1(int target, int[] nums) {
        int sum = nums[0];
        int min = Integer.MAX_VALUE;
        int localMin = 1;
        int last = 0;
        boolean is = false;
        for (int i = 1; i <= nums.length + 1;) {
            if (sum >= target) {
                min = Math.min(min, localMin);
                localMin--;
                sum -= nums[last];
                last++;
                is = true;
            } else if (i < nums.length) {
                sum += nums[i];
                localMin++;
                i++;
            } else i++;

        }
        if (is) return min;
        return 0;
    }

    public static void main(String[] args) {
        _209_Minimum_Size_Subarray_Sum solution = new _209_Minimum_Size_Subarray_Sum();
//        int[] a = {2,3,1,2,4,3};
//        int target = 7;
        int[] a = {1,4,4};
        int target = 4;

        solution.minSubArrayLen(4, a);
    }
}
