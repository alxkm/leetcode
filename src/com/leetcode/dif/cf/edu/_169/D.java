package com.leetcode.dif.cf.edu._169;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

public class D {
    public static void solve() throws IOException {
        int n = in.nextInt();
        int q = in.nextInt();

        String[] portals = new String[n];
        for (int i = 0; i < n; i++) {
            portals[i] = in.next();
        }

        HashMap<String, Integer> lastSeen = new HashMap<>();
        int[] leftCost = new int[n];
        int[] rightCost = new int[n];

        // Process from left to right
        for (int i = 0; i < n; i++) {
            leftCost[i] = Integer.MAX_VALUE;
            for (char color : portals[i].toCharArray()) {
                String key = String.valueOf(color);
                if (lastSeen.containsKey(key)) {
                    leftCost[i] = Math.min(leftCost[i], i - lastSeen.get(key));
                }
                lastSeen.put(key, i);
            }
        }

        lastSeen.clear();

        // Process from right to left
        for (int i = n - 1; i >= 0; i--) {
            rightCost[i] = Integer.MAX_VALUE;
            for (char color : portals[i].toCharArray()) {
                String key = String.valueOf(color);
                if (lastSeen.containsKey(key)) {
                    rightCost[i] = Math.min(rightCost[i], lastSeen.get(key) - i);
                }
                lastSeen.put(key, i);
            }
        }

        for (int i = 0; i < q; i++) {
            int x = in.nextInt() - 1;
            int y = in.nextInt() - 1;

            if (portals[x].equals(portals[y])) {
                out.println(Math.abs(x - y));
            } else {
                int minCost = Integer.MAX_VALUE;

                for (char colorX : portals[x].toCharArray()) {
                    for (char colorY : portals[y].toCharArray()) {
                        if (colorX == colorY) {
                            minCost = Math.min(minCost, Math.abs(x - y));
                        }
                    }
                }

                if (leftCost[x] != Integer.MAX_VALUE && rightCost[y] != Integer.MAX_VALUE) {
                    minCost = Math.min(minCost, leftCost[x] + rightCost[y] + Math.abs(x - y));
                }

                out.println(minCost == Integer.MAX_VALUE ? -1 : minCost);
            }
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
