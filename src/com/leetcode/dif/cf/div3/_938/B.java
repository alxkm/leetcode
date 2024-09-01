package com.leetcode.dif.cf.div3._938;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class B {
    public static void solve() throws IOException {
        int n = in.nextInt();
        int c = in.nextInt();
        int d = in.nextInt();

        int[][] a = new int[n][n];
        int min = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n * n; i++) {
            int temp = in.nextInt();
            map.put(temp, map.getOrDefault(temp, 0) + 1);
            min = Math.min(min, temp);
        }

        boolean ans = true;
        a[0][0] = min;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n && ans; i++) {
            for (int j = 0; j < n && ans; j++) {
                if (i + 1 < n) {
                    String key = (i + 1) + "," + j;
                    if (!set.contains(key))  {
                        int temp = a[i][j] + c;
                        a[i + 1][j] = temp;
                        Integer val = map.get(temp);
                        if (val == null) {
                            ans = false;
                        } else {
                            if (val == 1) {
                                map.remove(temp);
                            } else {
                                map.put(temp, val - 1);
                            }
                            set.add(key);
                        }
                    }
                }
                if (j + 1 < n) {
                    String key = i + "," + (j + 1);
                    if (!set.contains(key)) {
                        int temp = a[i][j] + d;
                        a[i][j + 1] = temp;
                        Integer val = map.get(temp);
                        if (val == null) {
                            ans = false;
                        } else {
                            if (val == 1) {
                                map.remove(temp);
                            } else {
                                map.put(temp, val - 1);
                            }
                            set.add(key);
                        }
                    }
                }
            }
        }

        out.println(ans ? "YES" : "NO");
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