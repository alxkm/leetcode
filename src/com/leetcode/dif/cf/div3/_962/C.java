package com.leetcode.dif.cf.div3._962;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class C {
    public static void solve() throws IOException {
        int n = in.nextInt();
        int q = in.nextInt();

        String a = in.next();
        String b = in.next();

        int[][] prefixA = new int[n + 1][26];
        int[][] prefixB = new int[n + 1][26];

        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j < 26; ++j) {
                prefixA[i][j] = prefixA[i - 1][j];
                prefixB[i][j] = prefixB[i - 1][j];
            }
            prefixA[i][a.charAt(i - 1) - 'a']++;
            prefixB[i][b.charAt(i - 1) - 'a']++;
        }

        while (q-- > 0) {
            int l = in.nextInt();
            int r = in.nextInt();
            int operations = 0;

            for (int j = 0; j < 26; ++j) {
                int countA = prefixA[r][j] - prefixA[l - 1][j];
                int countB = prefixB[r][j] - prefixB[l - 1][j];
                operations += Math.abs(countA - countB);
            }

            out.println(operations / 2);
        }
    }

    public static void main(String[] args) throws IOException {
        int tests = in.nextInt();
        while (tests-- > 0) {
            solve();
        }
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
