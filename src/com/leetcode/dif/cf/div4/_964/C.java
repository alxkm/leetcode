package com.leetcode.dif.cf.div4._964;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class C {
    public static void solve() throws IOException {
        int n = in.nextInt();  // Number of tasks
        int s = in.nextInt();  // Minutes needed to shower
        int m = in.nextInt();  // Total minutes in a day

        int[][] tasks = new int[n][2];
        for (int j = 0; j < n; j++) {
            tasks[j][0] = in.nextInt();
            tasks[j][1] = in.nextInt();
        }
        // Check if Alex can find a free interval of at least s minutes
        boolean canShower = canAlexShower(tasks, s, m);
        System.out.println(canShower ? "YES" : "NO");
    }

    public static boolean canAlexShower(int[][] tasks, int s, int m) {
        Arrays.sort(tasks, Comparator.comparingInt(a -> a[0]));

        // Check if there's time before the first task
        if (tasks[0][0] >= s) {
            return true;
        }

        // Check intervals between tasks
        for (int i = 1; i < tasks.length; i++) {
            if (tasks[i][0] - tasks[i - 1][1] >= s) {
                return true;
            }
        }

        // Check if there's time after the last task
        if (m - tasks[tasks.length - 1][1] >= s) {
            return true;
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