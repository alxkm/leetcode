package com.leetcode.easy.array;

import java.util.ArrayList;
import java.util.List;

public class _3285_Find_Indices_of_Stable_Mountains {
    //3285. Find Indices of Stable Mountains
    //https://leetcode.com/problems/find-indices-of-stable-mountains/description/

    public List<Integer> stableMountains(int[] height, int threshold) {
        List<Integer> l = new ArrayList<>();
        for (int i = 1; i < height.length; i++) {
            if (height[i - 1] > threshold && height[i] != 0) l.add(i);
        }
        return l;
    }
}
