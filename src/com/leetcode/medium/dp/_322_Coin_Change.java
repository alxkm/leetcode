package com.leetcode.medium.dp;

import java.util.ArrayList;
import java.util.List;

public class _322_Coin_Change {
    //https://leetcode.com/problems/coin-change/

    class Solution {
        public int coinChange(int[] coins, int amount) {
            return f(coins, amount, new int[amount]);
        }

        private int f(int[] coins, int amount, int[] cache) {
            if (amount < 0) return -1;
            if (amount == 0) return 0;
            if (cache[amount - 1] != 0) return cache[amount - 1];

            int minCount = Integer.MAX_VALUE;
            for (int x: coins) {
                int a = f(coins, amount - x, cache);
                if (a >= 0 && a < minCount) {
                    minCount = 1 + a;
                }
            }
            cache[amount - 1] = (minCount == Integer.MAX_VALUE) ? -1 : minCount;
            return cache[amount - 1];
        }
    }

    public int coinChange(int[] coins, int amount) {
        List<Integer> list = new ArrayList<>();
        f(coins.length - 1, coins, amount, list);
        return !list.isEmpty() ? list.size() : -1;
    }

    private void f(int i, int[] coins, int amount, List<Integer> list) {
        if (amount == 0 || i < 0) {
            return;
        }

        if (coins[i] <= amount) {
            list.add(coins[i]);
            f(i - 1, coins, amount - coins[i], list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        _322_Coin_Change solution = new _322_Coin_Change();
        System.out.println(solution.coinChange(new int[] {1, 2, 5}, 11));
    }
}
