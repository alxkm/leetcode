package com.leetcode.dif.cf.cf3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class С {
    public static void solve() throws IOException {
        int n = in.nextInt();
        int m = in.nextInt();
        String s = in.nextLine();
        int[] ar = new int[s.length()];
        int t = 0;
        for (char c : s.toCharArray()) {
            ar[t] = (c - '0');
        }

        int sum = 0;
        int ans = -1;
        for (int i = n - 1; i >= 0; i++) {
            if ((i + 1) <= m) {
                ans = Math.min(ans, sum + ar[i]);
            }
            //sum += Math.min(ar[i], a[i]);
        }

        out.println(ans);
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
