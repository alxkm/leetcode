package com.leetcode.dif.cf.div3._970;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class D {

    public static void solve() throws IOException {
        int n = in.nextInt();
        int[] p = new int[n];
        int[] functions = new int[n];
        boolean[] visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            p[i] = in.nextInt() - 1;
        }
        String s = in.nextLine();

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                List<Integer> list = new ArrayList<>();
                int j = i;

                int count = 0;
                count = processCycle(visit, j, list, s, count, p);

                processFunctions(list, functions, count);
            }
        }

        for (int i = 0; i < n; i++) {
            out.print(functions[i] + " ");
        }
        out.println();
    }

    private static int processCycle(boolean[] visit, int j, List<Integer> list, String s, int count, int[] p) {
        while (!visit[j]) {
            visit[j] = true;
            list.add(j);
            if (s.charAt(j) == '0') {
                count++;
            }
            j = p[j];
        }
        return count;
    }

    private static void processFunctions(List<Integer> list, int[] functions, int count) {
        for (int k : list) {
            functions[k] = count;
        }
    }

    public static void main(String[] args) throws IOException {
        int t = in.nextInt();
        while (t-- > 0) {
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
