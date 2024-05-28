package com.leetcode.dif.cf.div3._946;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class B {
    public static void solve() throws IOException {
        int size = in.nextInt();
        char[] s = in.nextLine().toCharArray();
        Set<Character> set = new HashSet<>();
        for (char ch: s) {
            set.add(ch);
        }
        List<Character> list = new ArrayList<>(set);
        Collections.sort(list);

        Map<Character, Character> map = new HashMap<>();

        for (int i = 0, j = list.size() - 1; i <= j; i++, j--) {
            map.put(list.get(j), list.get(i));
            map.put(list.get(i), list.get(j));
        }
        StringBuilder sb = new StringBuilder();
        for (char c : s) {
            sb.append(map.get(c));
        }

        out.println(sb);
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