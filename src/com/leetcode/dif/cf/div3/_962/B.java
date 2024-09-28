package com.leetcode.dif.cf.div3._962;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B {
    public static void solve() throws IOException {
        int n = in.nextInt();
        int k = in.nextInt();

        List<String> grid = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            grid.add(in.nextLine());
        }

        int reducedSize = n / k;

        for (int i = 0; i < reducedSize; ++i) {
            for (int j = 0; j < reducedSize; ++j) {
                int blockStartRow = i * k;
                int blockStartCol = j * k;

                out.print(grid.get(blockStartRow).charAt(blockStartCol));
            }
            out.println();
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
