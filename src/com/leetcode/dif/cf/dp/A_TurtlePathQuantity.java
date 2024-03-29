package com.leetcode.dif.cf.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A_TurtlePathQuantity {

    static int m;
    static int n;
    static int mod = 1_000_000_000 + 7;

    public static void solve() throws IOException {
        m = in.nextInt();
        n = in.nextInt();

        boolean[][] mat = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            String line = in.nextLine();
            for (int j = 0; j < n; j++) {
                mat[i][j] = line.charAt(j) != 'X';
            }
        }
        int ans = getWaysQuantity(mat);
        out.println(ans);
    }

    private static int getWaysQuantity(boolean[][] mat) {
        int[][] mt = new int[m][n];
        mt[0][0] = mat[0][0] ? 1 : 0;
        for (int i = 1; i < m; i++) {
            mt[i][0] = (mt[i - 1][0] == 1 && mat[i][0]) ? 1 : 0;
        }
        for (int j = 1; j < n; j++) {
            mt[0][j] = (mt[0][j - 1] == 1 && mat[0][j]) ? 1 : 0;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                mt[i][j] = (!mat[i][j]) ? 0 : (mt[i - 1][j] + mt[i][j - 1]) % mod;
            }
        }
        return mt[m - 1][n - 1];
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