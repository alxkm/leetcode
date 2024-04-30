package com.leetcode.K_package;

public class _992_Subarrays_with_K_Different_Integers {
    //992. Subarrays with K Different Integers
    //https://leetcode.com/problems/subarrays-with-k-different-integers/description/
    //hard
    //todo
    //foreign

    public int subarraysWithKDistinct(int[] nums, int k) {
        int answer = 0, n = nums.length;
        int[] cnt = new int[n + 1];
        for (int i = 0, m = 0, j = 0; j < n; j++) {
            cnt[nums[j]]++;
            if (cnt[nums[j]] == 1) {
                if (--k < 0) {
                    cnt[nums[m++]] = 0;
                    i = m;
                }
            }
            if (k <= 0) {
                while (cnt[nums[m]] > 1) {
                    cnt[nums[m++]]--;
                }
                answer += m - i + 1;
            }
        }
        return answer;
    }
}
