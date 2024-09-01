package com.leetcode.medium.graph;

import com.leetcode.ArrayUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class _2976_Minimum_Cost_to_Convert_String_I {
    //2976. Minimum Cost to Convert String I
    //https://leetcode.com/problems/minimum-cost-to-convert-string-i/?envType=daily-question&envId=2024-07-27

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long[][] map = new long[26][26];
        List<int[]>[] gr = new ArrayList[26];
        for (int i = 0; i < 26; i++) gr[i] = new ArrayList<>();
        for (int i = 0; i < original.length; i++) {
            int from = original[i] - 'a';
            int to = changed[i] - 'a';
            int weight = cost[i];
            gr[from].add(new int[] {to, weight});
        }
        long totalCost = 0;

        for (int i = 0; i < 26; i++) {
            map[i] = dijkstra(i, gr);
        }

        for (int i = 0; i < source.length(); i++) {
            int from = source.charAt(i) - 'a';
            int to = target.charAt(i) - 'a';
            if (map[from][to] == Long.MAX_VALUE) return -1;
            totalCost += map[from][to];
        }
        return totalCost;
    }

    private long[] dijkstra(int from, List<int[]>[] gr) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        boolean[] visit = new boolean[26];
        long[] dist = new long[26];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[from] = 0;
        pq.add(new int[] {from, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            visit[cur[0]] = true;
            for (int[] v: gr[cur[0]]) {
                if (!visit[v[0]]) pq.add(new int[] {v[0], cur[1] + v[1]});

                int d = cur[1] + v[1];

                if (dist[v[0]] > d) {
                    dist[v[0]] = d;
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        var sol = new _2976_Minimum_Cost_to_Convert_String_I();
        System.out.println(sol.minimumCost("abcd", "acbe",
                ArrayUtil.parseAndConvertToCharArray("[\"a\",\"b\",\"c\",\"c\",\"e\",\"d\"]"),
                ArrayUtil.parseAndConvertToCharArray("[\"b\",\"c\",\"b\",\"e\",\"b\",\"e\"]"),
                ArrayUtil.parseAndConvertToIntArray("[2,5,5,1,2,20]")));
    }
}
