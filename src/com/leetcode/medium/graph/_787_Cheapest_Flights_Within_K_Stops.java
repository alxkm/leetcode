package com.leetcode.medium.graph;

import com.leetcode.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class _787_Cheapest_Flights_Within_K_Stops {
    //787. Cheapest Flights Within K Stops
    //https://leetcode.com/problems/cheapest-flights-within-k-stops/


    public int findCheapestPrice1(int n, int[][] flights, int src, int dst, int k) {

        Map<Integer, List<int[]>> gr = new HashMap<>();
        Map<Integer, Integer> cost = new HashMap<>();
        Map<Integer, Integer> len = new HashMap<>();

        for (int[] ar: flights) {
            gr.computeIfAbsent(ar[0], k1 -> new ArrayList<>());
            gr.get(ar[0]).add(ar);
        }

        // Queue<int[]]> q = new Queue<>();
        // for (int[] ar: gr.get(i)) {
        //     q.add(ar);
        //     cost.put(ar[1], Math.min(cost.getOrDefault(ar[1], Integer.MAX_VALUE), ar[2]));
        //     len.put(ar[1], 1);
        // }
        // Set<Integer> used = new HashSet<>();
        // while(!q.isEmpty()) {
        //     int[] v = q.poll();

        //     used.add(v[0]);

        //     for (int[] ar: gr.get(v[1])) {
        //         if (used.contains(ar[1])) continue;
        //         q.add(ar);
        //         cost.put(ar[1], Math.min(cost.getOrDefault(ar[1], Integer.MAX_VALUE), ar[2]));
        //         len.put(ar[1], len.get(v[0]) + 1);
        //         if (v[0] == dst) {
        //             if (len.get(v[0]) <= k) {
        //                 cost.put(ar[1], Math.min(cost.getOrDefault(ar[1], Integer.MAX_VALUE), ar[2]));
        //             }
        //         } else {
        //             cost.put(ar[1], Math.min(cost.getOrDefault(ar[1], Integer.MAX_VALUE), ar[2]));
        //         }
        //     }
        // }

        int[] dp = new int[100];
        Arrays.fill(dp, Integer.MAX_VALUE);
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        Set<Integer> used = new HashSet<>();
        for (int i = 0; i <= k; i++) {
            while (!q.isEmpty()) {
                int p = q.poll();
                List<int[]> ints = gr.get(p);
                if (ints == null) continue;
                if (used.contains(p)) continue;
                used.add(p);
                for (int[] ar: ints) {
                    int from = ar[0];
                    int to = ar[1];
                    int price = ar[2];
                    if (dp[from] == Integer.MAX_VALUE) dp[from] = 0;
                    dp[i] = Math.min(dp[to], dp[from] + price);
                    if (!used.contains(to)) {
                        q.add(to);
                    }
                }
            }
        }

        return dp[dst] == Integer.MAX_VALUE ? -1 : dp[dst];
    }


    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[src] = 0;
        for (int i = 0; i <= k; i++) {
            int[] temp = Arrays.copyOf(dp, n);
            for (int j = 0; j < flights.length; j++) {
                int from = flights[j][0];
                int to = flights[j][1];
                int price = flights[j][2];
                temp[to] = Math.min(temp[to], dp[from] + price);
            }
            dp = temp;
        }

        return dp[dst] == Integer.MAX_VALUE / 2 ? -1 : dp[dst];
    }

    public static void main(String[] args) {


        var sol = new _787_Cheapest_Flights_Within_K_Stops();

        int n = 4;
        int[][] flights = {{0,1,100},{1,2,100},{2,0,100},{1,3,600},{2,3,200}};
        int src = 0;
        int dst = 3;
        int k = 1;


        System.out.println(sol.findCheapestPrice(n, flights, src, dst, k));
    }

}
