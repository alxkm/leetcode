package com.leetcode.dif.cf.cf1;

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
            int[] a = new int[n];
            String line = in.nextLine();
            for (int j = 0; j < n; j++) a[j] = line.charAt(j) - '0';
            int c1 = 0;
            int c2 = 0;
            line = in.nextLine();
            for (int j = 0; j < n; j++) {
                int f = line.charAt(j) - '0';
                if (a[j] == f) continue;
                if (a[j] == 1 && f == 0) {
                    c1++;
                } else if (a[j] == 0 && f == 1) {
                    c2++;
                }
            }
            out.println(Math.max(c1, c2));
        }
    }

    public static void main(String[] args) throws IOException {
        solve();
        out.close();
    }

    static B.InputReader in = new B.InputReader();
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