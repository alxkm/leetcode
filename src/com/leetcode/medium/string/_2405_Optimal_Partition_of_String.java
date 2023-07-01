package com.leetcode.medium.string;

import java.util.HashSet;
import java.util.Set;

public class _2405_Optimal_Partition_of_String {
    //https://leetcode.com/problems/optimal-partition-of-string/

    public int partitionString(String s) {
        Set<Character> set = new HashSet<>();
        int counter = 1;
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                counter++;
                set.clear();
            }
            set.add(s.charAt(i));
        }
        return counter;
    }
}
