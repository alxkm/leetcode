package com.leetcode.medium.monotonic;

import java.util.Stack;

public class _962_Maximum_Width_Ramp {
    //962. Maximum Width Ramp
    //https://leetcode.com/problems/maximum-width-ramp/?envType=daily-question&envId=2024-10-10

    public int maxWidthRamp(int[] nums) {
        int max = 0;
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[st.peek()]) st.push(i);
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            while (st.size() > 0 && nums[i] >= nums[st.peek()]) {
                max = Math.max(max, i - st.pop());
            }
        }
        return max;
    }

    public int maxWidthRamp1(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] <= nums[j]) max = Math.max(max, j - i);
            }
        }
        return max;
    }
}
