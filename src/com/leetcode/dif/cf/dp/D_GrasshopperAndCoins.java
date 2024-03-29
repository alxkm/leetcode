package com.leetcode.dif.cf.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class D_GrasshopperAndCoins {
    public static void solve() throws IOException {
        int n = in.nextInt();
        int k = in.nextInt();
        int[] coins = new int[n + 1];
        coins[1] = 0;
        for (int i = 2; i < n; i++) coins[i] = in.nextInt();
        coins[n] = 0;

        int[] dp = new int[n + 1];
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = Integer.MIN_VALUE;
            for (int j = 1; j <= k && i - j >= 1; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + coins[i]);
            }
        }
        out.println(dp[n]);
    }

    public static void main(String[] args) throws IOException {
        solve();
        out.close();
    }

    static InputReader in = new InputReader();
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    static class InputReader {
        private StringTokenizer st;
        private final BufferedReader bf;

        public InputReader() {
            bf = new BufferedReader(new InputStreamReader(System.in));
            st = null;
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(bf.readLine());
            }
            return st.nextToken();
        }

        public String nextLine() throws IOException {
            return bf.readLine();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}