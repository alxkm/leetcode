package com.leetcode.dif.cf.div4._952;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class C {
    public static void solve() throws IOException {
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = in.nextInt();
        }
        out.println(countGoodPrefixes(ar));
    }

    public static int countGoodPrefixes(int[] a) {
        int n = a.length;
        int goodPrefixCount = 0;
        int prefixSum = 0;

        for (int i = 0; i < n; i++) {
            prefixSum += a[i];
            if (prefixSum % 2 == 0) {
                int halfSum = prefixSum / 2;
                if (contains(a, i, halfSum)) {
                    goodPrefixCount++;
                }
            }
        }

        return goodPrefixCount;
    }

    private static boolean contains(int[] a, int end, int sum) {
        for (int i = 0; i <= end; i++) {
            if (a[i] == sum) {
                return true;
            }
        }
        return false;
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