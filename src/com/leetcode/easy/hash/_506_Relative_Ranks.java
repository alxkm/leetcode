package com.leetcode.easy.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _506_Relative_Ranks {
    //506. Relative Ranks
    //https://leetcode.com/problems/relative-ranks/

    public String[] findRelativeRanks(int[] score) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < score.length; i++) {
            map.put(i, score[i]);
        }
        Arrays.sort(score);
        String[] a = new String[score.length];
        Map<Integer, String> map1 = new HashMap<>();
        for (int i = 0; i < score.length; i++) {
            if (i == 0) {
                map1.put(score[score.length - 1], "Gold Medal");
            } else if (i == 1) {
                map1.put(score[score.length - 2], "Silver Medal");
            } else if (i == 2) {
                map1.put(score[score.length - 3], "Bronze Medal");
            } else {
                map1.put(score[i], Integer.valueOf(i + 1).toString());
            }
        }
        for (int i = 0; i < score.length; i++) {
            a[i] = map1.get(map.get(i));
        }
        return a;
    }

    public String[] findRelativeRanks1(int[] score) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = score.length;
        for (int i = 0; i < n; i++) {
            map.put(score[i], i);
        }
        Arrays.sort(score);

        String[] ar = new String[n];
        ar[map.get(score[n - 1])] = "Gold Medal";
        if (n > 1) ar[map.get(score[n - 2])] = "Silver Medal";
        if (n > 2) ar[map.get(score[n - 3])] = "Bronze Medal";

        for (int i = n - 4, j = 4; i >= 0; i--, j++) {
            ar[map.get(score[i])] = "" + j;
        }
        return ar;
    }
}
