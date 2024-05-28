package com.leetcode.dif.cf.div3._946;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class C {
    public static void solve() throws IOException {
        int n = in.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = in.nextInt();
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= n - 3; i++) {
            String key = ar[i] + "," + ar[i + 1] + ",.";
            map.put(key, map.getOrDefault(key, 0) + 1);

            key = ar[i] + ",.," + ar[i + 2];
            map.put(key, map.getOrDefault(key, 0) + 1);

            key = ".," + ar[i + 1] + "," + ar[i + 2];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        long ans = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int x = entry.getValue();
            ans += (long) x * (x - 1) / 2;
        }

        Map<String, Integer> map2 = new HashMap<>();
        for (int i = 0; i <= n - 3; i++) {
            String s = ar[i] + "," + ar[i + 1] + "," + ar[i + 2];
            map2.put(s, map2.getOrDefault(s, 0) + 1);
        }

        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            int x = entry.getValue();
            ans -= 3 * (long) x * (x - 1) / 2;
        }
        out.println(ans);
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