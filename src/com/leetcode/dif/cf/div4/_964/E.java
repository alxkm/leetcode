package com.leetcode.dif.cf.div4._964;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class E {
    public static void main(String[] args) throws IOException {
        int tests = in.nextInt();
        while (tests-- > 0) {
            solve();
        }
        out.close();
    }

    private static void solve() throws IOException {
        int left = in.nextInt();
        int right = in.nextInt();
        int result = 0;

        int nextLeft = left + 1;
        int currentLeft = left;

        while (currentLeft > 0) {
            currentLeft /= 3;
            result += 2;
        }

        while (nextLeft > 0) {
            nextLeft /= 3;
            result += 1;
        }

        for (int number = left + 2; number <= right; number++) {
            int currentNumber = number;
            while (currentNumber > 0) {
                currentNumber /= 3;
                result += 1;
            }
        }

        out.println(result);
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
