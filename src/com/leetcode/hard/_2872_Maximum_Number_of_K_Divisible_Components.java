package com.leetcode.hard;

import java.util.ArrayList;
import java.util.List;

public class _2872_Maximum_Number_of_K_Divisible_Components {
    //2872. Maximum Number of K-Divisible Components
    //https://leetcode.com/problems/maximum-number-of-k-divisible-components/description/

    class Solution {
        int q;

        public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
            List<Integer>[] t = new List[n];
            for (int i = 0; i < n; i++) {
                t[i] = new ArrayList<>();
            }
            for (int[] ar: edges) {
                t[ar[0]].add(ar[1]);
                t[ar[1]].add(ar[0]);
            }
            dfs(0, -1, t, values, k);
            return q;
        }

        int dfs(int cur, int parent, List<Integer>[] t, int[] values, int k) {
            int sum = 0;

            for (int node: t[cur]) {
                if (node != parent) {
                    sum += dfs(node, cur, t, values, k);
                }
            }

            sum += values[cur];
            sum %= k;

            if (sum == 0) q++;

            return sum;
        }
    }
}
