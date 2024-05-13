package com.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class _2709_Greatest_Common_Divisor_Traversal {
    //2709. Greatest Common Divisor Traversal
    //https://leetcode.com/problems/greatest-common-divisor-traversal/
    //topsort
    //unionfind

    public boolean canTraverseAllPairs(int[] nums) {
        if (nums.length == 1) return true;
        int max = Integer.MIN_VALUE;
        Set<Integer> uniq = new HashSet<>();
        for (int n: nums) {
            if (n == 1) return false;
            max = Math.max(max, n);
            uniq.add(n);
        }
        if (uniq.size() == 1) return true;
        nums = new int[uniq.size()];
        List<Integer> l = new ArrayList<>(uniq);
        for (int i = 0; i < l.size(); i++) {
            nums[i] = l.get(i);
        }
        boolean[] primes = new boolean[max + 2];
        Arrays.fill(primes, true);
        for (int i = 2; i * i <= max + 2; i++) {
            if (primes[i]) {
                for (int j = i * i; j <= max; j += i) {
                    primes[j] = false;
                }
            }
        }
        Set<Integer> prime = new HashSet<>();
        for (int i = 2; i <= max; i++) {
            if (primes[i]) prime.add(i);
        }
        int primeCounter = 0;
        for (int n: uniq) {
            if (prime.contains(n)) {
                primeCounter++;
                if (primeCounter >= 10) return false;
            }
        }

        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int n : nums) {
            Set<Integer> set = new HashSet<>();
            for (int i: prime) {
                if (n % i == 0) set.add(i);
            }
            map.put(n, set);
        }

        Map<Integer, List<Integer>> gr = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                Set<Integer> s1 = map.get(nums[i]);
                Set<Integer> s2 = map.get(nums[j]);
                Set<Integer> intersect = s1.stream().filter(s2::contains).collect(Collectors.toSet());
                if (!intersect.isEmpty()) {
                    gr.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
                    gr.computeIfAbsent(j, k -> new ArrayList<>()).add(i);
                }
            }
        }
        Set<Integer> used = new HashSet<>();
        dfs(0, gr, used);
        return used.size() == nums.length;
    }

    private void dfs(int v, Map<Integer, List<Integer>> gr, Set<Integer> set) {
        if (gr.get(v) == null) return;
        if (set.contains(v)) return;

        set.add(v);

        for (Integer edge : gr.get(v)) {
            dfs(edge, gr, set);
        }
    }

    public static void main(String[] args) {
        var sol = new _2709_Greatest_Common_Divisor_Traversal();
        //System.out.println(sol.canTraverseAllPairs(new int[]{2, 3, 6}));
        //System.out.println(sol.canTraverseAllPairs(new int[]{4,3,12,8}));
        System.out.println(sol.canTraverseAllPairs(new int[]{10}));
    }
}
