package com.leetcode.dif.cf.div3._962;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class E {
    public static void solve() throws IOException {
        String t = in.nextLine();
        int s = 1;

        int[] p = new int[t.length() + 1];
        int[] e = new int[2 * t.length() + 2];

        for (int i = 0; i < t.length(); i++) {
            p[i + 1] = p[i] + (t.charAt(i) != '0' ? 1 : -1);
        }

        for (int j = 1; j <= t.length(); j++) {
            e[p[j - 1] + t.length()] += j;
            s = (int) ((s + (long) e[p[j] + t.length()] * (t.length() - j + 1)) % 1000000007);
        }

        out.println(s - 1);
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
