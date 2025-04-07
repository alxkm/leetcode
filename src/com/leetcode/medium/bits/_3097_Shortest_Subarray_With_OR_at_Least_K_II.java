package com.leetcode.medium.bits;

import com.leetcode.ArrayUtil;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _3097_Shortest_Subarray_With_OR_at_Least_K_II {
    //3097. Shortest Subarray With OR at Least K II
    //https://leetcode.com/problems/shortest-subarray-with-or-at-least-k-ii/description/?envType=daily-question&envId=2024-11-10

    public int minimumSubarrayLength(int[] nums, int k) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < 32; i++) map.put(i, new HashSet<>());
        int len = -1;
        int cur = 0;
        for (int i = 0, j = 0; i < nums.length && j < nums.length; ) {
            if (cur >= k && !(cur == 0 && len == -1)) {
                int n = nums[i];
                int l = 0;
                while (n > 0) {
                    if (n % 2 != 0) {
                        map.get(l).remove(nums[i]);
                    }
                    n /= 2;
                    l++;
                }
                cur = 0;
                for (l = 0; l < 32; l++) {
                    if (map.get(l).size() > 0) {
                        cur += (Math.pow(2, l));
                    }
                }
                i++;
            } else {
                int n = nums[j];
                int l = 0;
                while (n > 0) {
                    if (n % 2 != 0) {
                        map.get(l).add(nums[j]);
                    }
                    n /= 2;
                    l++;
                }
                cur |= nums[j];
                j++;
            }

            if (cur >= k && (len == -1 || ((j - i) < len && (j - i) > 0))) {
                len = j - i;
            }
        }

        return len;
    }

    public static void main(String[] args) {
        var sol = new _3097_Shortest_Subarray_With_OR_at_Least_K_II();
        sol.minimumSubarrayLength(ArrayUtil.of(1,2), 0);
    }

}
