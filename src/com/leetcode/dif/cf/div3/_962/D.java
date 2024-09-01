package com.leetcode.dif.cf.div3._962;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class D {
    public static void solve() throws IOException {
        int n = in.nextInt();
        int x = in.nextInt();
        int count = 0;

        for (int a = 1; a <= x; a++) {
            for (int b = 1; b <= x - a; b++) {
                int ab = a * b;
                int max_c = x - a - b;
                if (ab > n || max_c <= 0) {
                    break;
                }

                for (int c = 1; c <= max_c; c++) {
                    if (ab + a * c + b * c <= n) {
                        count++;
                    } else {
                        break;
                    }
                }
            }
        }

        out.println(count);
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
