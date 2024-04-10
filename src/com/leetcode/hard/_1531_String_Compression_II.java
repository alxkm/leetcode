package com.leetcode.hard;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class _1531_String_Compression_II {
    //1531. String Compression II
    //https://leetcode.com/problems/string-compression-ii/

    public static class CompressionInfo {
        public int i;
        public int k;
        public char prev;
        public int prevCnt;

        public CompressionInfo(int i, int k, char prev, int prevCnt) {
            this.i = i;
            this.k = k;
            this.prev = prev;
            this.prevCnt = prevCnt;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CompressionInfo that = (CompressionInfo) o;
            return i == that.i && k == that.k && prev == that.prev && prevCnt == that.prevCnt;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, k, prev, prevCnt);
        }
    }

    private Map<String, Integer> memo = new HashMap<>();

    public int getLengthOfOptimalCompression1(String s, int k) {
        return f(s.toCharArray(), 0, k, '_', 0);
    }

    private int f(char[] s, int i, int k, char prev, int prevCnt) {
        var key = i + "_" + k + "_" + prev + "_" + prevCnt;

        Integer cachedVal = memo.get(key);
        if (cachedVal != null) return cachedVal;

        if (k < 0) return Integer.MAX_VALUE;
        if (i == s.length) return 0;

        if (s[i] == prev) {
            int increment = (prevCnt == 1 || prevCnt == 9 || prevCnt == 99) ? 1 : 0;
            cachedVal = increment + f(s, i + 1, k, prev, prevCnt + 1);
        } else {
            cachedVal = Math.min(
                    f(s, i + 1, k - 1, prev, prevCnt),    //delete
                    1 + f(s, i + 1, k, s[i], 1)); // don't delete
        }

        memo.put(key, cachedVal);
        return cachedVal;
    }


    Map<String, Integer> map = new HashMap<>();

    public int getLengthOfOptimalCompression(String s, int k) {
        return getLengthOfOptimalCompression(s.toCharArray(), k, 0, ' ', 0);
    }

    public int getLengthOfOptimalCompression(char[] chArray, int k, int prevCount, char prevChar, int i) {
        String key = k + "," + prevCount + "," + prevChar + "," + i;
        Integer cachedValue = map.get(key);
        if (cachedValue != null) return cachedValue;

        if (k < 0) return Integer.MAX_VALUE;
        if (i == chArray.length) return 0;

        if (chArray[i] == prevChar) {
            int incr = (prevCount == 1 || prevCount == 9 || prevCount == 99) ? 1 : 0;
            cachedValue = incr + getLengthOfOptimalCompression(chArray, k, prevCount + 1, prevChar, i + 1);
        } else {
            cachedValue = Math.min(
                    getLengthOfOptimalCompression(chArray, k - 1, prevCount, prevChar, i + 1),

                    1 + getLengthOfOptimalCompression(chArray, k, 1, chArray[i], i + 1)
            );
        }

        map.put(key, cachedValue);
        return cachedValue;
    }

    public static void main(String[] args) {
        var sol = new _1531_String_Compression_II();
        System.out.println(sol.getLengthOfOptimalCompression("aaabcccd", 2));
    }
}

class Solution {
    private int[][][][] dp;
    private char[] s;

    public int getLengthOfOptimalCompression(String s1, int k) {
        this.s = s1.toCharArray();
        int n = s1.length();
        dp = new int[n + 1][k + 1][27][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < k + 1; j++) {
                for (int l = 0; l < 27; l++) {
                    Arrays.fill(dp[i][j][l], 1000);
                }
            }
        }
        dp[0][k][26][0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                for (int prev = 0; prev < 27; prev++) {
                    for (int prevCnt = 0; prevCnt <= i; prevCnt++) {
                        int curVal = dp[i][j][prev][prevCnt];
                        int curChar = (int)(s[i] - 'a');
                        if (j > 0) {
                            dp[i + 1][j - 1][prev][prevCnt] = Math.min(
                                    dp[i + 1][j - 1][prev][prevCnt],
                                    curVal
                            );
                        }
                        if (curChar == prev) {
                            int increment = (prevCnt == 1 || prevCnt == 9 || prevCnt == 99) ? 1 : 0;
                            dp[i + 1][j][prev][prevCnt + 1] = Math.min(
                                    dp[i + 1][j][prev][prevCnt + 1],
                                    curVal + increment
                            );
                        } else {
                            dp[i + 1][j][curChar][1] = Math.min(
                                    dp[i + 1][j][curChar][1],
                                    curVal + 1
                            );
                        }
                    }
                }
            }
        }
        int ans = 1000;
        for (int j = 0; j < k + 1; j++) {
            for (int prev = 0; prev < 27; prev++) {
                for (int prevCnt = 0; prevCnt <= n; prevCnt++) {
                    ans = Math.min(
                            ans,
                            dp[n][j][prev][prevCnt]
                    );
                }
            }
        }
        return ans;
    }
}
