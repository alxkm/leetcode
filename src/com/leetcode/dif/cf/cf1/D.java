package com.leetcode.dif.cf.cf1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D {
    public static void solve() throws IOException {
        for (int t = in.nextInt(); t > 0; t--) {
            int n = in.nextInt(), m = in.nextInt();
            int[] a = new int[n];
            int[] b = new int[m];

            for (int i = 0; i < n; i++) a[i] = in.nextInt();
            for (int i = 0; i < m; i++) b[i] = in.nextInt();
            Arrays.sort(a);
            Arrays.sort(b);

            long max = 0;
            int l = 0, r = n - 1, l1 = 0, r1 = m - 1;
            while (l <= r) {
                if (Math.abs(a[l] - b[r1]) > Math.abs(a[r] - b[l1])) {
                    max += Math.abs(a[l] - b[r1]);
                    r1--;
                    l++;
                } else {
                    max += Math.abs(a[r] - b[l1]);
                    l1++;
                    r--;
                }
            }

            out.println(max);
        }
    }

    public static void main(String[] args) throws IOException {
        solve();
        out.close();
    }

    static D.InputReader in = new D.InputReader();
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