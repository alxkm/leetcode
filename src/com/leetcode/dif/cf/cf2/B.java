package com.leetcode.dif.cf.cf2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class B {
    public static void solve() throws IOException {
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int[][] ar = new int[n][n];
            String[] ars = new String[n];
            for (int j = 0; j < n; j++) {
                ars[j] = in.nextLine();
            }

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    ar[j][k] = ars[j].charAt(k) - '0';
                }
            }
            out.println(detectFigure(ar));
        }
    }

    public static String detectFigure(int[][] ar) {
        int prev = -1;
        for (int[] a : ar) {
            int count = 0;
            for (int j : a) {
                if (j == 1) count++;
            }
            if (count > 0) {
                if (prev == -1) {
                    prev = count;
                } else {
                    if (prev == count) return "SQUARE";
                    break;
                }
            }
        }
        return "TRIANGLE";
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