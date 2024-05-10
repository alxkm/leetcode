package com.leetcode.dif;

import com.leetcode.ArrayUtil;

import java.util.HashMap;
import java.util.Map;

public class DpExample {
    int[] nums;
    int fee;
    int n;
    Map<String, Integer> cache;

    public int maxProfit(int[] prices, int fee) {
        this.nums = prices;
        this.fee = fee;
        this.n = prices.length;

        //return f(0, 0, false);
        cache = new HashMap<>();
        int i = f1(0, false);
        return i;
    }

    int f(int i, int profit, boolean sell) {
        if (i == n) return profit;
        if (sell)
            return Math.max(
                    f(i + 1, profit + nums[i] - fee, false),
                    f(i + 1, profit, true)
            );
        return Math.max(
                f(i + 1, profit - nums[i], true),
                f(i + 1, profit, false)
        );
    }

    int f1(int i, boolean sell) {
        if (i == n) return 0;

        String key = i + "," + sell;
        Integer maxProfit = cache.get(key);
        if (maxProfit != null) return maxProfit;
        maxProfit = 0;
        if (sell) {
            maxProfit = Math.max(f1(i + 1, false) - nums[i] - fee, maxProfit);
        } else {
            maxProfit = Math.max(nums[i] + f1(i + 1, false), maxProfit);
        }
        maxProfit = Math.max(f1(i + 1, sell), maxProfit);
        cache.put(key, maxProfit);
        return maxProfit;
    }

    public static void main(String[] args) {
        var sol = new DpExample();
        System.out.println(sol.maxProfit(ArrayUtil.of(1, 3, 2, 8, 4, 9), 2));
        System.out.println(sol.maxProfit(ArrayUtil.of(1, 3, 7, 5, 10, 3), 3));
    }
}
