package com.leetcode.dif.cf.cf1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A {
    public static void solve() throws IOException {
        int t = in.nextInt();
        int[][] ar = new int[4][2];
        for (int i = 0; i < t; i++) {
            ar[0][0] = in.nextInt();
            ar[0][1] = in.nextInt();
            ar[1][0] = in.nextInt();
            ar[1][1] = in.nextInt();
            ar[2][0] = in.nextInt();
            ar[2][1] = in.nextInt();
            ar[3][0] = in.nextInt();
            ar[3][1] = in.nextInt();
            out.println(findSquareArea(ar));
        }

    }

    public static int findSquareArea(int[][] coordinates) {
        int minX = Integer.MAX_VALUE, minY = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE, maxY = Integer.MIN_VALUE;

        for (int[] coord : coordinates) {
            minX = Math.min(minX, coord[0]);
            minY = Math.min(minY, coord[1]);
            maxX = Math.max(maxX, coord[0]);
            maxY = Math.max(maxY, coord[1]);
        }

        int sideLength = Math.max(maxX - minX, maxY - minY);
        return sideLength * sideLength;
    }

    public static void main(String[] args) throws IOException {
        solve();
        out.close();
    }

    static A.InputReader in = new A.InputReader();
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