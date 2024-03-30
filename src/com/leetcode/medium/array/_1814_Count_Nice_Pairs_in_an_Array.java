package com.leetcode.medium.array;

import java.util.HashMap;
import java.util.Map;

public class _1814_Count_Nice_Pairs_in_an_Array {
    //1814. Count Nice Pairs in an Array
    //https://leetcode.com/problems/count-nice-pairs-in-an-array/

    public int countNicePairs(int[] nums) {
        int mod = 1000_000_007;
        int[] ar = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int t = nums[i];
            int n = 0;
            while (t != 0) {
                n = n * 10 + t % 10;
                t /= 10;
            }
            ar[i] = nums[i] - n;
        }
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int n: ar) {
            sum = (sum + map.getOrDefault(n, 0)) % mod;
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        return sum;
    }
}
