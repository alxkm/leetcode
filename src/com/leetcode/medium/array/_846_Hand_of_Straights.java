package com.leetcode.medium.array;

import com.leetcode.ArrayUtil;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class _846_Hand_of_Straights {
    //https://leetcode.com/problems/hand-of-straights/
    //846. Hand of Straights
    //https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;

        //Set<Integer> set = new HashSet<>();
        //for (int n: hand) set.add(n);
        //if (set.size() == groupSize && hand.length == groupSize) return true;

        Arrays.sort(hand);
        Set<Integer> used = new HashSet<>();
        int kParts = hand.length / groupSize;

        while (kParts > 0) {
            int counter = 0;
            int prev = -1;
            for (int i = 0; i < hand.length && counter != groupSize; i++) {
                int cur = hand[i];
                if (prev != cur && (prev == -1 || prev + 1 == cur) && !used.contains(i)) {
                    used.add(i);
                    prev = cur;
                    counter++;
                }
            }
            if (counter != groupSize) return false;
            kParts--;
        }
        return true;
    }

    public boolean isNStraightHand1(int[] hand, int groupSize) {
        int n = hand.length;
        if (groupSize == 1) return true;
        if (n % groupSize != 0) return false;
        Map<Integer, LinkedList<Integer>> fr = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            fr.computeIfAbsent(hand[i], k -> new LinkedList<>()).add(i);
        }

        for (Integer k: fr.keySet()) {
            while (!fr.get(k).isEmpty()) {
                int prev = hand[fr.get(k).poll()];
                for (int i = 1; i < groupSize; i++) {
                    LinkedList<Integer> list = fr.get(prev + 1);
                    if (list != null && !list.isEmpty()) {
                        Integer index = list.poll();
                        hand[index] = -1;
                        prev++;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public boolean isNStraightHand2(int[] hand, int groupSize) {
        if (groupSize == 1) return true;
        int n = hand.length;
        if (n % groupSize != 0) return false;
        Map<Integer, int[]> map = new TreeMap<>();
        for (int num : hand) {
            map.computeIfAbsent(num, key -> new int[1])[0]++;
        }

        for (var entry: map.entrySet()) {
            while (entry.getValue()[0] > 0) {
                int prev = entry.getKey();
                entry.getValue()[0]--;
                prev++;
                for (int i = 1; i < groupSize; i++) {
                    int[] ar = map.get(prev);
                    if (ar != null && ar[0] > 0) {
                        ar[0]--;
                        prev++;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        var sol = new _846_Hand_of_Straights();
        System.out.println(sol.isNStraightHand(ArrayUtil.of(233722108,386144634,221638886,175028874,408337082,91410299,793763682,972910825,627251147,135020779), 2));
        System.out.println(sol.isNStraightHand(ArrayUtil.of(1, 2, 3, 6, 2, 3, 4, 7, 8), 3));
        System.out.println(sol.isNStraightHand(ArrayUtil.of(0, 1), 2));
    }
}
