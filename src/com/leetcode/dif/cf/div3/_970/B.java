package com.leetcode.dif.cf.div3._970;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class B {

    public static void solve() throws IOException {
        int n = in.nextInt();
        String s = in.next();
        out.println(isBeautifulSquareMatrix(s, n) ? "Yes" : "No");
    }

    private static boolean isBeautifulSquareMatrix(String s, int n) {
        int r = (int) Math.sqrt(n);
        if (checkPerfectSquare(n, r)) return false;
        if (checkFirstAndLastRow(s, n, r)) return false;
        return !checkFirstAndLastColumnPerRow(s, r);
    }

    private static boolean checkFirstAndLastColumnPerRow(String s, int r) {
        for (int i = 1; i < r - 1; ++i) {
            if (s.charAt(i * r) != '1' || s.charAt(i * r + r - 1) != '1') return true;

            for (int j = 1; j < r - 1; ++j) {
                if (s.charAt(i * r + j) != '0') return true;
            }
        }
        return false;
    }

    private static boolean checkFirstAndLastRow(String s, int n, int r) {
        for (int i = 0; i < r; ++i) {
            if (s.charAt(i) != '1' || s.charAt(n - r + i) != '1') return true;
        }
        return false;
    }

    private static boolean checkPerfectSquare(int n, int r) {
        return r * r != n;
    }

    public static void main(String[] args) throws IOException {
        int t = in.nextInt();
        while (t-- > 0) {
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
