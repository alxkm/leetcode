package com.leetcode.algorithm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TestForPriorityQueue {

    public static void main(String[] args) {
        //System.out.println(reductionOperations(new int[]{1, 1, 2, 2, 3}));
        System.out.println(garbageCollection(new String[]{"G","P","GP","GG"}, new int[] {2,4,3}));

        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = List.of(5, 1, 2, 2, 2, 1, 3, 4);
        PriorityQueue<Integer> q = new PriorityQueue<>
                ((a,b) -> map.get(a) == map.get(b) ? b-a: map.get(b) - map.get(a));
        //((a, b) -> {return map.getOrDefault(b, 0) - map.getOrDefault(a, 0);});
        for (Integer i : list) {
            map.put(i, map.getOrDefault(i, map.getOrDefault(i, 0) + 1));
            q.offer(i);
        }

        var a = q.poll();
        map.put(a, map.get(a) - 1);
        System.out.println(a);
        a = q.poll();
        map.put(a, map.get(a) - 1);
        System.out.println(a);
        a = q.poll();
        map.put(a, map.get(a) - 1);
        System.out.println(a);


    }

    public static int reductionOperations(int[] nums) {
        int n = nums.length;
        int[] freq = new int[50001];
        for (int i = 0; i < n; i++) {
            freq[nums[i]]++;
        }
        int res = 0, operations = 0;
        for (int i = 50000; i >= 1; i--) {
            if (freq[i] > 0) {
                operations += freq[i];
                res += operations - freq[i];
                System.out.println("operations = " + operations);
                System.out.println("freq[i] = " + freq[i]);
            }
        }
        return res;
    }

    public static int garbageCollection(String[] garbage, int[] travel) {
        int gmax = -1, mmax = -1, pmax = -1;
        int gs = 0, ms = 0, ps = 0;
        for (int i = 0; i < garbage.length; i++) {
            String s = garbage[i];
            if (s.contains("G")) {
                gmax = Math.max(gmax, i);
                for (char ch: s.toCharArray()) {
                    if (ch == 'G') gs++;
                }
            }
            if (s.contains("M")) {
                mmax = Math.max(mmax, i);
                for (char ch: s.toCharArray()) {
                    if (ch == 'M') ms++;
                }
            }
            if (s.contains("P")) {
                for (char ch: s.toCharArray()) {
                    if (ch == 'P') ps++;
                }
                pmax = Math.max(pmax, i);
            }
        }

        // int[] prefix = new int[garbage.length + 1];
        // for (int i = 1; i < garbage.length; i++) {
        //     System.out.println("i " + i);
        //     System.out.println(travel[i - 1]);
        //     prefix[i] = travel[i - 1];
        // }

        for (int i = 1; i < garbage.length; i++) {
            String s = garbage[i];
            if (i > gmax && gmax != -1) {
                gs += travel[i - 1];
            }
            if (i > mmax && mmax != -1) {
                ms += travel[i - 1];
            }
            if (i > pmax && pmax != -1) {
                ps += travel[i - 1];
            }
        }

        return gs + ms + ps;
    }
}
