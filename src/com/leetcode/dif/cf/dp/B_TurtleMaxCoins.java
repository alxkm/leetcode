package com.leetcode.dif.cf.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class B_TurtleMaxCoins {

    static int m;
    static int n;

    public static void solve() throws IOException {
        m = in.nextInt();
        n = in.nextInt();

        int[][] mat = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = in.nextInt();
            }
        }

        int ans = getMaxCoins(mat);
        out.println(ans);
    }

    private static int getMaxCoins(int[][] coins) {
        int[][] max = new int[m][n];
        max[0][0] = coins[0][0];
        for (int i = 1; i < m; i++) {
            max[i][0] = coins[i][0] + max[i - 1][0];
        }
        for (int j = 1; j < n; j++) {
            max[0][j] = coins[0][j] + max[0][j - 1];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                max[i][j] = coins[i][j] + Math.max(max[i][j], max[i][j - 1]);
            }
        }

        return max[m - 1][n - 1];
    }

    public static void main(String[] args) throws IOException {
        solve();
        out.close();
    }

    static InputReader in = new InputReader();
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    static class InputReader {
        private StringTokenizer st;
        private BufferedReader bf;

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

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }
}