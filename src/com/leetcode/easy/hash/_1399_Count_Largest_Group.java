package com.leetcode.easy.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _1399_Count_Largest_Group {
    static public int countLargestGroup(int n) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int max = 0;
        for (int i = 1; i <= n; i++) {
            int num = i;
            int sum = 0;

            while (num != 0) {
                sum += num % 10;
                num /= 10;
            }
            var a = map.getOrDefault(sum, new ArrayList<>());
            a.add(i);
            map.put(sum, a);
            max = Math.max(max, a.size());
        }
        int counter = 0;
        for (var e : map.entrySet()) {
            if (e.getValue().size() == max) {
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        System.out.println(countLargestGroup(13));
    }
}
