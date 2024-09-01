package com.leetcode.dif.cf.div4._964;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class D {
    public static void solve() throws IOException {
        String a = in.nextLine();
        String b = in.nextLine();

        int i = 0, j = 0;
        StringBuilder aBuilder = new StringBuilder(a);

        while (i < aBuilder.length() && j < b.length()) {
            if (aBuilder.charAt(i) == b.charAt(j)) {
                i++;
                j++;
            } else if (aBuilder.charAt(i) == '?') {
                aBuilder.setCharAt(i, b.charAt(j));
                i++;
                j++;
            } else {
                i++;
            }
        }

        if (j < b.length()) {
            out.println("NO");
        } else {
            for (i = 0; i < aBuilder.length(); i++) {
                if (aBuilder.charAt(i) == '?') {
                    aBuilder.setCharAt(i, 'a');
                }
            }
            out.println("YES");
            out.println(aBuilder);
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