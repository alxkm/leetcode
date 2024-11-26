package com.leetcode.medium.arrayarray;

import java.util.Arrays;

public class _2070_Most_Beautiful_Item_for_Each_Query {
    //2070. Most Beautiful Item for Each Query
    //https://leetcode.com/problems/most-beautiful-item-for-each-query/description/

    public int[] maximumBeauty(int[][] items, int[] queries) {
        // Sort items by price
        Arrays.sort(items, (a, b) -> a[0] - b[0]);

        // Create an array q to store requests along with indexes
        int[][] q = new int[queries.length][3];
        for (int i = 0; i < queries.length; i++) {
            q[i][0] = i;
            q[i][1] = queries[i];
        }

        // Sort requests by price value (q[i][1])
        Arrays.sort(q, (a, b) -> a[1] - b[1]);

        // Create an array to accumulate maximum beauty at every step
        int maxBeauty = 0;
        int idx = 0;
        int[] result = new int[queries.length];

        // Go through each request
        for (int i = 0; i < q.length; i++) {
            int queryPrice = q[i][1];

            // Update maxBeauty for all items with a price <= the current request
            while (idx < items.length && items[idx][0] <= queryPrice) {
                maxBeauty = Math.max(maxBeauty, items[idx][1]);
                idx++;
            }

            // Save the result for the current request
            result[q[i][0]] = maxBeauty;
        }

        return result;
    }
}
