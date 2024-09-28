package com.leetcode.dif.cf.div4._971;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class C {
    public static void solve() throws IOException {
        long x = in.nextLong();
        long y = in.nextLong();
        long k = in.nextLong();

        long s1 = 0;
        long s = 0;

        if (x % k == 0) {
            s1 = x / k;
        } else {
            s1 = (x / k) + 1;
        }

        if (y % k == 0) {
            s = y / k;
        } else {
            s = (y / k) + 1;
        }


        long minx = Math.min(s1, s);
        long miny = Math.max(s1, s);
        long j = minx + miny + (miny - minx);

        if (s1 > s) {
            j--;
        }

        out.println(j);
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
