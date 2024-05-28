package com.leetcode.dif.cf.div3._946;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A {
    public static void solve() throws IOException {
        int x = in.nextInt();
        int y = in.nextInt();
        int r = 0;
        int counter = 0;
        if (y > 0) {
            if (y == 1) {
                counter = 1;
                r = 5 * 3 - 4;
            } else {
                counter = y / 2;
                r = (5 * 3 * counter) - (8 * counter);
                if (y % 2 != 0) {
                    counter++;
                    r += 5 * 3 - 4;
                }
            }
        }
        if (x > r) {
            x -= r;
            if (x <= 5 * 3) {
                counter++;
            } else {
                counter += x / 15;
                x -= 15 * (x / 15);
                if (x > 0) counter++;
            }
        }
        out.println(counter);
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