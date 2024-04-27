package com.leetcode.easy.array;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _2848_Points_That_Intersect_With_Cars {
    //2848. Points That Intersect With Cars
    //https://leetcode.com/problems/points-that-intersect-with-cars/description/

    public int numberOfPoints(List<List<Integer>> nums) {
        Set<Integer> set = new HashSet<>();
        for (List<Integer> l: nums) {
            for (int i = l.get(0); i <= l.get(1); i++) {
                set.add(i);
            }
        }
        return set.size();
    }
}
