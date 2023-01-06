package com.leetcode.medium.hashtable;

import java.util.HashSet;
import java.util.Set;

public class _2442_Count_Number_of_Distinct_Integers_After_Reverse_Operations {
    public int countDistinctIntegers(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
            if (!(n <= 9)) {
                set.add(reverse(n));
            }
        }
        return set.size();
    }

    private int reverse(int i) {
        int r = 0;
        while(i != 0) {
            r = r * 10 + i % 10;
            i = i/10;
        }
        return r;
    }
}
