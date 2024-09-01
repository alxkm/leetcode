package com.leetcode.dif.cf.edu._169;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class C {
    public static void solve() throws IOException {
        int n = in.nextInt();
        int k = in.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) array[i] = in.nextInt();
        Arrays.sort(array);
        for (int i = n - 1; i >= 0; i -= 2) {
            if (k == 0) break;
            if (i == 0) break;
            int difference = array[i] - array[i - 1];
            int min = Math.min(difference, k);
            array[i - 1] += min;
            k -= min;
        }
        int[] oddEven = new int[2];
        oddEvenCalculation(array, oddEven, n);
        out.println(Math.abs(oddEven[0] - oddEven[1]));
    }

    public static void main(String[] args) throws IOException {
        int tests = in.nextInt();
        while (tests-- > 0) {
            solve();
        }
        out.close();
    }

    private static void fillMap(int first, int second, int third, int fourth, Map<Integer, Integer> map) {
        for (int i = first; i <= second; i++) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int i = third; i <= fourth; i++) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
    }

    private static boolean isGreaterThanR(int a, int b, int c, int d, int r) {
        return Math.max(Math.max(a, b), Math.max(c, d)) > r;
    }

    private static boolean isLessThanL(int a, int b, int c, int d, int l) {
        return Math.min(Math.min(a, b), Math.min(c, d)) < l;
    }

    private static void oddEvenCalculation(int[] array, int[] oddEven, int n) {
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                oddEven[0] += array[i];
            } else {
                oddEven[1] += array[i];
            }
        }
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
