package com.leetcode.medium.greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _1833_Maximum_Ice_Cream_Bars {
    //1833. Maximum Ice Cream Bars
    //https://leetcode.com/problems/maximum-ice-cream-bars/

    public int maxIceCream(int[] costs, int coins) {
        int min = costs[0];
        int max = costs[0];

        for (int i = 0; i < costs.length; i++) {
            min = Math.min(min, costs[i]);
            max = Math.max(max, costs[i]);
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int n: costs) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        int s = 0;
        for (int i = min; i <= max; i++) {
            if (!map.keySet().contains(i)) continue;

            Integer cur = map.get(i);
            if (i <= coins) {
                int t = coins / i;
                if (cur <= t) {
                    s += cur;
                    coins -= cur * i;
                } else {
                    s += t;
                    break;
                }
            } else {
                break;
            }
        }
        return s;
    }

    public int maxIceCream1(int[] costs, int coins) {
        Arrays.sort(costs);
        int s = 0;
        for (int n: costs) {
            if (n <= coins) {
                coins -= n;
                s++;
            } else {
                break;
            }
        }
        return s;
    }
}
