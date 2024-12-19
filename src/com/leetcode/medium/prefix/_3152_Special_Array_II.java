package com.leetcode.medium.prefix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class _3152_Special_Array_II {
    //https://leetcode.com/problems/special-array-ii/description/
    //3152. Special Array II

    //own
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        boolean[] ans = new boolean[queries.length];
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> map1 = new HashMap<>();
        int start = 0;
        boolean even = (nums[0] % 2 == 0);
        for (int i = 1; i < nums.length; i++) {
            if (even) {
                if (nums[i] % 2 != 0) {
                    even = false;
                    map.put(start, i);
                    map1.put(i, start);
                } else {
                    start = i;
                }
            } else {
                if (nums[i] % 2 == 0) {
                    even = true;
                    map.put(start, i);
                    map1.put(i, start);
                } else {
                    start = i;
                }
            }
        }

        for (int i = 0; i < ans.length; i++) {
            int from = queries[i][0];
            int to = queries[i][1];
            if (from == to) {
                ans[i] = true;
                continue;
            }
            boolean ok = false;
            var e = map.get(from);
            if (e != null && e >= to) {
                ok = true;
            } else {
                e = map1.get(from);
                if (e != null && map.get(e) >= to) {
                    ok = true;
                }
            }
            ans[i] = ok;
        }
        return ans;
    }
}

class Solution {

    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        boolean[] ans = new boolean[queries.length];
        int[] prefix = new int[nums.length];
        prefix[0] = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] % 2 == nums[i - 1] % 2) {
                // new violative index found
                prefix[i] = prefix[i - 1] + 1;
            } else {
                prefix[i] = prefix[i - 1];
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int start = query[0];
            int end = query[1];

            ans[i] = prefix[end] - prefix[start] == 0;
        }

        return ans;
    }
}

class Solution1 {

    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        boolean[] ans = new boolean[queries.length];
        ArrayList<Integer> violatingIndices = new ArrayList<>();

        for (int i = 1; i < nums.length; i++) {
            // same parity, found violating index
            if (nums[i] % 2 == nums[i - 1] % 2) {
                violatingIndices.add(i);
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int start = query[0];
            int end = query[1];

            boolean foundViolatingIndex = binarySearch(
                    start + 1,
                    end,
                    violatingIndices
            );

            if (foundViolatingIndex) {
                ans[i] = false;
            } else {
                ans[i] = true;
            }
        }

        return ans;
    }

    private boolean binarySearch(
            int start,
            int end,
            ArrayList<Integer> violatingIndices
    ) {
        int left = 0;
        int right = violatingIndices.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int violatingIndex = violatingIndices.get(mid);

            if (violatingIndex < start) {
                // check right half
                left = mid + 1;
            } else if (violatingIndex > end) {
                // check left half
                right = mid - 1;
            } else {
                // violatingIndex falls in between start and end
                return true;
            }
        }

        return false;
    }
}
