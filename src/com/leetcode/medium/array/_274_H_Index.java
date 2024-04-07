package com.leetcode.medium.array;

import java.util.Arrays;

public class _274_H_Index {
    //https://leetcode.com/problems/h-index/
    //274. H-Index
    //top

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int max = 0, n = citations.length;
        for (int i = 0; i < n; i++) {
            if (citations[i] >= (n - i)) {
                max = Math.max(max, n - i);
            }
        }
        return max;
    }
}
