package com.leetcode.top.top75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _347_Top_K_Frequent_Elements {
    //https://leetcode.com/problems/top-k-frequent-elements/
    //FOREIGN_SOLUTION
    //TOP

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int n: nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int[] answer = new int[k];
        int initK = k;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(new ArrayList<>());
        }
        for (var entry: map.entrySet()) {
            list.get(entry.getValue()).add(entry.getKey());
        }
        for (int i = list.size() - 1; i > 0; i--) {
            for (int n: list.get(i)) {
                answer[initK - k] = n;
                k--;
                if (k == 0) return answer;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] a = {1};
        int k = 1;
        _347_Top_K_Frequent_Elements solution = new _347_Top_K_Frequent_Elements();
        System.out.println(Arrays.toString(solution.topKFrequent(a, k)));

        List<Integer>[] list = new List[10];
    }
}
