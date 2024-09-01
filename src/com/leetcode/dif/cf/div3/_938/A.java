package com.leetcode.dif.cf.div3._938;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A {
    public static void solve() throws IOException {
        int n = in.nextInt();
        int a = in.nextInt();
        int b = in.nextInt();

        int part = n / 2;
        int totalPrice = part * b;
        totalPrice += (n - part * 2) > 0 ? a : 0;

        int totalPrice2 = n * a;

        out.println(Math.min(totalPrice, totalPrice2));
    }

    public static long getMost(int[] ar) {
        long s = 0;
        for (int n: ar) {
            if (n < 0) n *= -1;
            s += n;
        }
        return s;
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