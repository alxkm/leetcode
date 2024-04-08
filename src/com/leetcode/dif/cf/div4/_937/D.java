package com.leetcode.dif.cf.div4._937;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class D {
    private static int toBinary(int n) {
        StringBuilder binary = new StringBuilder();
        while (n > 0) {
            binary.insert(0, n % 2);
            n /= 2;
        }
        return Integer.parseInt(binary.toString());
    }

    public static void main(String[] args) throws IOException {
        int tests = in.nextInt();
        Map<Integer, Boolean> map = new HashMap<>();

        for (int a = 1; a <= 31; a++) {
            int ba = toBinary(a);
            if (ba > 100000) break;
            for (int b = 1; b <= 31; b++) {
                int bb = toBinary(b);
                if (ba * bb > 100000) break;
                for (int c = 1; c <= 31; c++) {
                    int bc = toBinary(c);
                    if (ba * bb * bc > 100000) break;
                    for (int d = 1; d <= 31; d++) {
                        int bd = toBinary(d);
                        if (ba * bb * bc * bd > 100000) break;
                        for (int e = 1; e <= 31; e++) {
                            int be = toBinary(e);
                            if (ba * bb * bc * bd * be > 100000) break;
                            map.put(ba * bb * bc * bd * be, true);
                        }
                    }
                }
            }
        }

        while (tests-- > 0) {
            int n = in.nextInt();
            Boolean num = map.get(n);
            if (num != null && num) {
                out.println("YES");
            } else {
                out.println("NO");
            }
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