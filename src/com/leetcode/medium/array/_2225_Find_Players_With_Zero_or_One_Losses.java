package com.leetcode.medium.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _2225_Find_Players_With_Zero_or_One_Losses {
    //2225. Find Players With Zero or One Losses
    //https://leetcode.com/problems/find-players-with-zero-or-one-losses/description/

    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> winners = new HashSet<>();
        Set<Integer> one = new HashSet<>();
        for (int[] ar: matches) {
            int curScore = map.getOrDefault(ar[1], 0) + 1;
            map.put(ar[1], curScore);

            if (map.get(ar[0]) == null) {
                winners.add(ar[0]);
            }
            if (winners.contains(ar[1])) {
                winners.remove(ar[1]);
            }

            if (curScore == 1) {
                one.add(ar[1]);
            } else if (curScore == 2) {
                one.remove(ar[1]);
            }
        }
        List<Integer> oneList = new ArrayList<>(one);
        List<Integer> winList = new ArrayList<>(winners);
        Collections.sort(oneList);
        Collections.sort(winList);
        return List.of(winList, oneList);
    }

    public List<List<Integer>> findWinners1(int[][] matches) {
        int[] map = new int[100001];
        boolean[] ones = new boolean[100001];
        boolean[] winners = new boolean[100001];
        int min = 100001, max = 0;

        for (int[] ar: matches) {
            min = Math.min(Math.min(min, ar[0]), ar[1]);
            max = Math.max(Math.max(max, ar[0]), ar[1]);
            map[ar[1]]++;

            if (map[ar[0]] == 0) winners[ar[0]] = true;
            if (winners[ar[1]]) winners[ar[1]] = false;

            if (map[ar[1]] == 1) ones[ar[1]] = true;
            else if (map[ar[1]] == 2) ones[ar[1]] = false;
        }

        List<Integer> winList = new ArrayList<>();
        for (int i = min; i <= max; i++) if (winners[i]) winList.add(i);
        List<Integer> oneList = new ArrayList<>();
        for (int i = min; i <= max; i++) if (ones[i]) oneList.add(i);

        return List.of(winList, oneList);
    }

    public List<List<Integer>> findWinners2(int[][] matches) {
        int min = 100001, max = 0;
        for (int[] ar: matches) {
            if (min > ar[0]) min = ar[0];
            if (min > ar[1]) min = ar[1];
            if (max < ar[0]) max = ar[0];
            if (max < ar[1]) max = ar[1];
        }

        int[] map = new int[max + 1];
        boolean[] ones = new boolean[max + 1];
        boolean[] winners = new boolean[max + 1];
        for (int[] ar: matches) {
            map[ar[1]]++;

            if (map[ar[0]] == 0) winners[ar[0]] = true;
            if (winners[ar[1]]) winners[ar[1]] = false;

            if (map[ar[1]] == 1) ones[ar[1]] = true;
            else if (map[ar[1]] == 2) ones[ar[1]] = false;
        }

        List<Integer> winList = new ArrayList<>();
        for (int i = min; i <= max; i++) if (winners[i]) winList.add(i);
        List<Integer> oneList = new ArrayList<>();
        for (int i = min; i <= max; i++) if (ones[i]) oneList.add(i);

        return List.of(winList, oneList);
    }
}
