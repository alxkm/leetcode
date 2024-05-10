package com.leetcode.dif.cf.div4._944;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class B {
    public static void solve() throws IOException {
        String s = in.nextLine();
        int[] ch = new int[26];
        for (int i = 0; i < s.toCharArray().length; i++) {
            ch[s.charAt(i) - 'a']++;
        }
        int counter = 0;
        for (int j : ch) {
            if (j > 0) counter++;
            if (counter >= 2) break;
        }
        if (counter <= 1) {
            out.println("NO");
        } else {
            out.println("YES");
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(0) != s.charAt(i)) {
                    String sb = s.charAt(i)
                            + s.substring(1, i)
                            +  s.charAt(0)
                            + s.substring(i + 1);
                    out.println(sb);
                    break;
                }
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