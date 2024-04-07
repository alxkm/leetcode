package com.leetcode.medium.dp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _1306_Jump_Game_III {
    //1306. Jump Game III
    //https://leetcode.com/problems/jump-game-iii/
    //FOREIGN_SOLUTION
    //TOP

    public boolean canReach(int[] arr, int start) {
        if (start >= 0 && start < arr.length && arr[start] >= 0) {
            if (arr[start] == 0) return true;
            arr[start] = -arr[start];
            return canReach(arr, start + arr[start]) || canReach(arr, start - arr[start]);
        }
        return false;
    }

    public boolean canReach1(int[] arr, int start) {
        return f(start, arr, new HashMap<>(), new HashSet<>());
    }
    
    private boolean f(int i, int[] arr, Map<Integer, Boolean> map, Set<Integer> set) {
        if (i >= arr.length || i < 0) {
            map.put(i, false);
            return false;
        }
        if (arr[i] == 0) {
            map.put(i, true);
            return true;
        }
        if (map.containsKey(i)) {
            return map.get(i);
        }
        if (set.contains(i)) {
            return false;
        }
        int n = arr[i];
        set.add(i + n);
        var a = f(i + n, arr, map, set);
        map.put(i + n, a);
        set.add(i - n);
        var b = f(i - n, arr, map, set);
        map.put(i - n, b);

        map.put(i, a || b);
        return a || b;
    }
/*
All possible ways to reach at index 3 with value 0 are:
index 5 -> index 4 -> index 1 -> index 3
index 5 -> index 6 -> index 4 -> index 1 -> index 3
* */
    public static void main(String[] args) {
        var sol = new _1306_Jump_Game_III();
        System.out.println(sol.canReach(new int[]{4, 2, 3, 0, 3, 1, 2}, 5));
    }
}
