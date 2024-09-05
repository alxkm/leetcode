package com.leetcode.dif.cf.div2._967;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class B {
    static final long MOD = 1000000007;

    public static void solve() throws IOException {
        long number = in.nextLong();
        if (number % 2 == 0) {
            out.println(-1);
            return;
        } else {
            for (int i = 1; i <= number / 2; i++) {
                out.print(i + " ");
            }
            for (int i = (int) number; i > number / 2; i--) {
                out.print(i + " ");
            }
            out.println();
        }
    }

    static long findCorresponding(long first, long second) {
        if (second == 0)
            return 1;
        long another = findCorresponding(first, second / 2);
        if (second % 2 == 0)
            return (another * another) % MOD;
        else
            return (another * another % MOD * first) % MOD;
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