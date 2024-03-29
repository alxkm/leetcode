package com.leetcode.dif.cf.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class F_HorseAndCoins {
    private static int INF = -100000;

    public static void solve() throws IOException {
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] mat = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = in.nextInt();
            }
        }

        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = INF;
            }
        }

        dp[0][0] = mat[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i - 1 >= 0 && j - 2 >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 2] + mat[i][j]);
                }
                if (i - 2 >= 0 && j - 1 >= 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 2][j - 1] + mat[i][j]);
                }
            }
        }

        int max = INF;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                max = Math.max(dp[i][j], max);
            }
        }

        out.println(max);
    }

    public static void main(String[] args) throws IOException {
        solve();
        out.close();
    }

    static C_GrasshopperWithObstacles.InputReader in = new C_GrasshopperWithObstacles.InputReader();
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
