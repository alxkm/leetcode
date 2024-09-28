package com.leetcode.dif.cf.edu._169;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class B {
    public static void solve() throws IOException {
        int first = in.nextInt();
        int second = in.nextInt();
        int third = in.nextInt();
        int fourth = in.nextInt();

        if (third > second || first > fourth) {
            out.println(1);
            return;
        }
        
        Map<Integer, Integer> map = new HashMap<>();
        
        if (third < first) {
            int temp = first;
            first = third;
            third = temp;
            temp = second;
            second = fourth;
            fourth = temp;
        }

        int minimumDoorsCounter = 0;
        fillMap(first, second, third, fourth, map);

        int left = -1;
        int right = -1;
        for (int i = 1; i <= 100; i++) {
            if (map.getOrDefault(i, 0) == 2) {
                minimumDoorsCounter++;
                if (left == -1) {
                    left = i;
                }
                right = i;
            }
        }
        minimumDoorsCounter--;
        if (isLessThanL(first, second, third, fourth, left)) {
            minimumDoorsCounter++;
        }
        if (isGreaterThanR(first, second, third, fourth, right)) {
            minimumDoorsCounter++;
        }
        out.println(minimumDoorsCounter);
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
