package com.leetcode.medium.math;

import com.leetcode.ArrayUtil;

import java.util.Arrays;

public class _3115_Maximum_Prime_Difference {
    //3115. Maximum Prime Difference
    //https://leetcode.com/problems/maximum-prime-difference/description/

    public int maximumPrimeDifference(int[] nums) {
        int max = Arrays.stream(nums).max().getAsInt();
        int limit = Math.max(max + 1, 10);
        boolean[] ar = new boolean[limit];
        Arrays.fill(ar, true);
        ar[0] = false;
        ar[1] = false;

        for (int i = 2; i < Math.sqrt(limit); i++) {
            for (int j = i + i; j < limit; j += i) {
                ar[j] = false;
            }
        }

        int maxDistance = 0;
        for (int i = 0; i < nums.length; i++) {
            if (ar[nums[i]]) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (ar[nums[j]])
                        maxDistance = Math.max(maxDistance, j - i);
                }
                break;
            }
        }
        return maxDistance;
    }

    public static void main(String[] args) {
        var sol = new _3115_Maximum_Prime_Difference();
        System.out.println(sol.maximumPrimeDifference(ArrayUtil.of(1,7)));
    }
}
