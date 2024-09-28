package com.leetcode.dif.cf.div2._967;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class C {

    private static int doQuery(int a, int b) throws IOException {
        out.println("? " + a + " " + b);
        out.flush();
        return in.nextInt();
    }

    private static void findAddEdges(int a, int b, int[] vis, List<int[]> edges) throws IOException {
        int x = doQuery(a, b);
        if (x == a || x == b) {
            edges.add(new int[]{a, b});
            vis[x] = 1;
            vis[b] = 1;
            return;
        }
        if (vis[a] == 1 && vis[x] == 1) {
            findAddEdges(x, b, vis, edges);
        } else {
            findAddEdges(a, x, vis, edges);
            findAddEdges(x, b, vis, edges);
        }
    }

    public static void main(String[] args) throws IOException {
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();

            if (n == 2) {
                out.println("! 1 2");
                out.flush();
                continue;
            }

            int[] visited = new int[n + 1];
            List<int[]> edgesConnections = new ArrayList<>();

            for (int i = 1; i < n; ++i) {
                for (int j = i + 1; j <= n; ++j) {
                    if (visited[j] == 1) continue;
                    findAddEdges(i, j, visited, edgesConnections);
                }
            }

            out.print("!");
            for (int[] edge : edgesConnections) {
                out.print(" " + edge[0] + " " + edge[1]);
            }
            out.println();
            out.flush();
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