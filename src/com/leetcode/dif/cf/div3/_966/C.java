package com.leetcode.dif.cf.div3._966;

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

        int[] template = new int[n];

        for (int i = 0; i < n; i++) {
            template[i] = in.nextInt();
        }

        n = in.nextInt();

        for (int i = 0; i < n; i++) {
            String s = in.nextLine();
            if (matchesTemplate(template, s)) {
                out.println("YES");
            } else {
                out.println("NO");
            }
        }
    }

    public static boolean matchesTemplate(int[] template, String s) {
        if (template.length != s.length()) {
            return false;
        }

        Map<Integer, Character> templateToChar = new HashMap<>();
        Map<Character, Integer> charToTemplate = new HashMap<>();

        for (int i = 0; i < template.length; i++) {
            int num = template[i];
            char c = s.charAt(i);

            if (templateToChar.containsKey(num)) {
                if (templateToChar.get(num) != c) {
                    return false;
                }
            } else {

                templateToChar.put(num, c);
            }

            if (charToTemplate.containsKey(c)) {
                if (charToTemplate.get(c) != num) {
                    return false;
                }
            } else {
                charToTemplate.put(c, num);
            }
        }

        return true;
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
