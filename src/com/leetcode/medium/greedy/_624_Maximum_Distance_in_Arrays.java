package com.leetcode.medium.greedy;

import java.util.List;

public class _624_Maximum_Distance_in_Arrays {
    //624. Maximum Distance in Arrays
    //https://leetcode.com/problems/maximum-distance-in-arrays/description/

    public int maxDistance(List<List<Integer>> arrays) {
        int min = arrays.get(0).get(0);
        int max = arrays.get(0).get(arrays.get(0).size() - 1);

        int maxDist = 0;

        for (int i = 1; i < arrays.size(); i++) {
            int curMin = arrays.get(i).get(0);
            int curMax = arrays.get(i).get(arrays.get(i).size() - 1);

            maxDist = Math.max(maxDist, Math.abs(curMax - min));
            maxDist = Math.max(maxDist, Math.abs(max - curMin));

            min = Math.min(min, curMin);
            max = Math.max(max, curMax);

        }
        return maxDist;
    }
}
