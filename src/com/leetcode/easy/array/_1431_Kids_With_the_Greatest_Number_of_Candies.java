package com.leetcode.easy.array;

import java.util.ArrayList;
import java.util.List;

public class _1431_Kids_With_the_Greatest_Number_of_Candies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> l = new ArrayList<Boolean>();
        int max = 0;
        for (int i = 0; i < candies.length; i++) {
            max = Math.max(max, candies[i]);
        }
        for (int i = 0; i < candies.length; i++) {
            l.add(candies[i] + extraCandies >= max ? true : false);
        }
        return l;
    }
}
