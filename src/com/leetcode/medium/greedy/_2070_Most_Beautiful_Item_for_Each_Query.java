package com.leetcode.medium.greedy;

import com.leetcode.ArrayUtil;

import java.util.Arrays;

public class _2070_Most_Beautiful_Item_for_Each_Query {
    //2070. Most Beautiful Item for Each Query
    //2070. Most Beautiful Item for Each Query
    //https://leetcode.com/problems/most-beautiful-item-for-each-query/description/

    public int[] maximumBeauty(int[][] items, int[] queries) {
        int[][] q = new int[queries.length][3];
        for (int i = 0; i < queries.length; i++) {
            q[i][0] = i;
            q[i][1] = queries[i];
        }
        Arrays.sort(q, (x, y) -> x[0] - y[0]);
        Arrays.sort(items, (x, y) -> x[0] - y[0]);

        for (int i = 0, prev = 0; i < queries.length; i++) {
            int best = 0;
            for (int j = Math.max(prev - 1, 0); j < items.length; j++) {
                if ((q[i][1] - items[j][0]) >= 0) {
                    if (best < items[j][1]) {
                        best = items[j][1];
                        prev = j;
                    } else {
                        prev = j - 1;
                    }
                } else {
                    break;
                }
            }
            q[i][2] = best;
        }

        int[] ar = new int[queries.length];
        for (int[] a : q) {
            ar[a[0]] = a[2];
        }
        return ar;
    }

    public static void main(String[] args) {
        var sol = new _2070_Most_Beautiful_Item_for_Each_Query();
        sol.maximumBeauty(ArrayUtil.to2d("[[1,2],[3,2],[2,4],[5,6],[3,5]]"), ArrayUtil.of(1, 2, 3, 4, 5, 6));
    }
}
