package com.leetcode.dif.cf.div2.epic_institute_of_technology;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class B {
    public static void solve() throws IOException {
        boolean check = true;
        int n = in.nextInt();
        long[] a = new long[n + 1];
        long[] b = new long[n + 1];
        long[] c = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            a[i] = in.nextLong();
        }

        for (int i = 1; i <= n; i++) {
            c[n - i + 1] = a[i];
        }

        for (int i = 1; i <= n; i++) {
            b[i] = in.nextLong();
        }

        for (int i = 1; i <= n; i++) {
            if (b[i] != a[i]) {
                check = false;
                break;
            }
        }

        if (!check) {
            check = true;
            for (int i = 1; i <= n; i++) {
                if (b[i] != c[i]) {
                    check = false;
                    break;
                }
            }
        }

        if (check) {
            out.println("Bob");
        } else {
            out.println("Alice");
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
