package com.leetcode.easy.hash;

import java.util.HashMap;
import java.util.Map;

public class _1854_Maximum_Population_Year {
    static public int maximumPopulation(int[][] logs) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int[] log : logs) {
            for (int j = log[0]; j < log[1]; j++) {
                map.put(j, map.getOrDefault(j, 0) + 1);
            }
        }

        int max = 1;
        int maxKey = logs[0][0];
        for (var entry : map.entrySet()) {
            if (max < entry.getValue()) {
                maxKey = entry.getKey();
                max = entry.getValue();
            } else if (max == entry.getValue() && maxKey > entry.getKey()) {
                maxKey = entry.getKey();
            }
        }

        return maxKey;
    }

    public static void main(String[] args) {
        //int a [][] = {{1950,1961},{1960,1971},{1970,1981}};
        //[[2008,2026],[2004,2008],[2034,2035],[1999,2050],[2049,2050],[2011,2035],[1966,2033],[2044,2049]]
        int a [][] = {
                {2008,2026},
                {2004,2008},
                {2034,2035},
                {1999,2050},
                {2049,2050},
                {2011,2035},
                {1966,2033},
                {2044,2049}
        };

        System.out.println(maximumPopulation(a));
    }
}
