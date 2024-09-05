package com.leetcode.dif.cf.div2._967;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class A {
    public static void solve() throws IOException {
        int n = in.nextInt();
        int[] array = new int[n];
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int i = 0; i < n; ++i) {
            array[i] = in.nextInt();
            frequencyMap.put(array[i], frequencyMap.getOrDefault(array[i], 0) + 1);
        }
        int maxFrequency = 0;
        for (Map.Entry<Integer, Integer> pair : frequencyMap.entrySet()) {
            if (pair.getValue() > maxFrequency) {
                maxFrequency = pair.getValue();
            }
        }
        out.println(n - maxFrequency);
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