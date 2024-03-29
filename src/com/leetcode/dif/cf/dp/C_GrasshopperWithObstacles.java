package com.leetcode.dif.cf.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class C_GrasshopperWithObstacles {
    private static int mod = 1_000_000_000 + 7;

    public static void solve() throws IOException {
        int n = in.nextInt();
        int k = in.nextInt();
        String input = in.nextLine();
        char[] line = new char[n + 1];
        line[1] = '.';
        for (int i = 2, j = 0; i < n; i++, j++) line[i] = input.charAt(j);
        line[n] = '.';

        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (line[i] == 'X') continue;
            for (int j = 1; j <= k && i - j >= 1; j++) {
                dp[i] = (dp[i] + dp[i - j]) % mod;
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