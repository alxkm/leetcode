package com.leetcode.medium.hashtable;

import java.util.HashMap;
import java.util.Map;

public class _1409_Queries_on_a_Permutation_With_Key {
    //https://leetcode.com/problems/queries-on-a-permutation-with-key/

    public int[] processQueries(int[] queries, int m) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= m; i++) {
            map.put(i, i - 1);
        }
        for (int i = 0; i < queries.length; i++) {
            int el = queries[i];
            int index = map.get(queries[i]);
            queries[i] = index;
            map.put(el, 0);
            for (var entry: map.entrySet()) {
                if (entry.getValue() <= index && entry.getKey() != el) {
                    entry.setValue(entry.getValue() + 1);
                }
            }
        }
        return queries;
    }
}
