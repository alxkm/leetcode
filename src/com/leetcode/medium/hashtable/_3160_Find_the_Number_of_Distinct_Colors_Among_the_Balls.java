package com.leetcode.medium.hashtable;

import java.util.HashMap;
import java.util.Map;

public class _3160_Find_the_Number_of_Distinct_Colors_Among_the_Balls {
    //https://leetcode.com/problems/find-the-number-of-distinct-colors-among-the-balls/description/?envType=daily-question&envId=2025-02-07
    //3160. Find the Number of Distinct Colors Among the Balls

    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer, Integer> colorMap = new HashMap<>();   //color -> size
        Map<Integer, Integer> idMap = new HashMap<>();      //id -> color
        int[] queriesResult = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0], y = queries[i][1];
            var prevColor = idMap.get(x);

            if (prevColor != null && !colorMap.remove(prevColor, 1)) {
                colorMap.merge(prevColor, 1, (a, b) -> a - b);
            }

            idMap.put(x, y);
            colorMap.merge(y, 1, (a, b) -> a + b);

            queriesResult[i] = colorMap.size();
        }
        return queriesResult;
    }
}
