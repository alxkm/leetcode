package com.leetcode.medium.dp;

import com.leetcode.Pair;

import java.util.HashMap;
import java.util.Map;

public class _650_2_Keys_Keyboard {
    //650. 2 Keys Keyboard
    //https://leetcode.com/problems/2-keys-keyboard/?envType=daily-question&envId=2024-08-19

    class Solution {
        Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();
        int n;

        public int minSteps(int n) {
            if (n == 1) return 0;
            this.n = n;
            return 1 + f(1, 1);
        }

        private int f(int size, int paste) {
            if (size == n) return 0;
            if (size > n) return 1000;
            var key = new Pair<>(size, paste);
            var val = map.get(key);
            if (val != null) return val;

            val = Math.min(
                    1 + f(size + paste, paste),
                    2 + f(size * 2, size)
            );

            map.put(key, val);
            return val;
        }
    }

    class Solution1 {
        int n;
        int[][] dp;

        public int minSteps(int n) {
            if (n == 1) return 0;
            this.n = n;
            dp = new int[n][n];
            return 1 + f(1, 1);
        }

        private int f(int size, int paste) {
            if (size == n) return 0;
            if (size > n) return 1000;
            if (dp[size][paste] != 0) return dp[size][paste];

            dp[size][paste] = Math.min(
                    1 + f(size + paste, paste),
                    2 + f(size * 2, size)
            );
            return dp[size][paste];
        }
    }
}
