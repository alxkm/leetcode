package com.leetcode.medium.hard;

import com.leetcode.Pair;

import java.util.HashMap;
import java.util.Map;

public class _1155_Number_of_Dice_Rolls_With_Target_Sum {
    //1155. Number of Dice Rolls With Target Sum
    //https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/description/
    //dp
    //top

    private Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();
    private final int mod = 1000000000 + 7;

    public int numRollsToTarget(int n, int k, int target) {
        return f(n, k, target, 0, 0);
    }

    private int f(int n, int k, int target, int used, int sum) {
        if (target == sum && used == n) return 1;
        if (sum > target) return 0;
        if (sum >= target && used != n) return 0;
        if (used >= n) return 0;

        var p = new Pair(used, sum);
        var ways = map.get(p);
        if (ways == null) {
            ways = 0;
            for (int i = 1; i <= k; i++) {
                ways += (f(n, k, target, used + 1, sum + i));
                ways %= mod;
            }
            map.put(p, ways);
        }

        return ways;
    }

/*    class Solution {
        private int mod = 1_000_000_007;

        public int numRollsToTarget(int n, int k, int target) {
            int[][] dp = new int[n + 1][target + 1];
            dp[0][0] = 1;

            for(int dice = 1; dice <= n; dice++) {
                for(int amount = dice; amount <= target; amount++) {
                    for(int currentNum = 1; currentNum <= Math.min(k, amount); currentNum++) {
                        long subResult = dp[dice][amount] + dp[dice - 1][amount - currentNum];
                        dp[dice][amount] = (int) (subResult % mod);
                    }
                }
            }

            return dp[n][target];
        }
    }*/

/*    class Solution {
        int[][] dp;
        int MOD = 1000000007;
        public int numRollsToTarget(int n, int k, int target) {
            if (n == 0 && target == 0)
                return 1;
            if (target < n || n * k < target)
                return 0;
            dp = new int[n + 1][target + 1];
            return f(n, k, target);
        }
        public int f(int n, int k, int target) {
            if (n == 0 && target == 0){
                return 1;
            }
            if (target < n || n * k < target) {
                return 0;
            }
            if (dp[n][target] != 0) {
                return dp[n][target];
            }
            int res = 0;
            for (int i = 1; i <= k; i++) {
                if (target < i) break;
                res = (res + f(n - 1, k, target - i) % MOD) % MOD;
            }
            dp[n][target] = res;
            return res;
        }
    }*/

    public static void main(String[] args) {
        var sol = new _1155_Number_of_Dice_Rolls_With_Target_Sum();
        System.out.println(sol.numRollsToTarget(2, 6, 7));
    }
}
