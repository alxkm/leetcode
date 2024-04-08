package com.leetcode.dif.cf.cf1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class C {
    public static void solve() throws IOException {
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            long n = in.nextInt();
            long f = in.nextInt(), a = in.nextInt(), b = in.nextInt();

            for (int j = 0, time = 0; j < n; j++) {
                int m = in.nextInt();
                f -= Math.min(b, (m - time) * a);
                time = m;
            }
            out.println(f > 0 ? "YES" : "NO");
        }
    }

    public static void main(String[] args) throws IOException {
        solve();
        out.close();
    }

    static C.InputReader in = new C.InputReader();
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