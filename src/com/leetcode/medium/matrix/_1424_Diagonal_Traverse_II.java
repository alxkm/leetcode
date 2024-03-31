package com.leetcode.medium.matrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _1424_Diagonal_Traverse_II {
    //https://leetcode.com/problems/diagonal-traverse-ii/
    //1424. Diagonal Traverse II

    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int size = 0;
        int max = 0;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.get(i).size(); j++) {
                if (map.get(i + j) == null) map.put(i + j, new ArrayList<>());
                map.get(i + j).add(nums.get(i).get(j));
                max = Math.max(max, i + j);
                size++;
            }
        }
        int[] ar = new int[size];

        for (int i = 0, t = 0; i <= max; i++) {
            for (int j = map.get(i).size() - 1; j >= 0; j--) {
                ar[t] = map.get(i).get(j);
                t++;
            }
        }
        return ar;
    }
}
