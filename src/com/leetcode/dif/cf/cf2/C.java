package com.leetcode.dif.cf.cf2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class C {
    public static void solve() throws IOException {
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int s = 0;
            int[] digitCount = new int[10];

            for (int position = 1; position <= n; position *= 10) {
                int quotient = n / (position * 10);
                int remainder = n % (position * 10);
                for (int digit = 0; digit <= 9; digit++) {
                    digitCount[digit] += quotient * position;
                    if (digit < remainder / position) {
                        digitCount[digit] += position;
                    } else if (digit == remainder / position) {
                        digitCount[digit] += remainder % position + 1;
                    }
                }
            }
            for (int digit = 0; digit <= 9; digit++) {
                s += digitCount[digit] * digit;
            }

            out.println(s);
        }
    }

    public static void main(String[] args) throws IOException {
        solve();
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