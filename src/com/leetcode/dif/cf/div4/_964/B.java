package com.leetcode.dif.cf.div4._964;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class B {
    public static void solve() throws IOException {
        int a1 = in.nextInt();
        int a2 = in.nextInt();
        int b1 = in.nextInt();
        int b2 = in.nextInt();

        // Count the number of ways Suneet can win
        int suneetWins = countWins(a1, a2, b1, b2);
        out.println(suneetWins);
    }

    public static int countWins(int a1, int a2, int b1, int b2) {
        int[][] suneetCards = {{a1, a2}, {a2, a1}};
        int[][] slavicCards = {{b1, b2}, {b2, b1}};
        int suneetWins = 0;

        for (int[] sCards : suneetCards) {
            for (int[] lCards : slavicCards) {
                int suneetRoundWins = 0;
                int slavicRoundWins = 0;

                if (sCards[0] > lCards[0]) {
                    suneetRoundWins++;
                } else if (sCards[0] < lCards[0]) {
                    slavicRoundWins++;
                }

                if (sCards[1] > lCards[1]) {
                    suneetRoundWins++;
                } else if (sCards[1] < lCards[1]) {
                    slavicRoundWins++;
                }

                if (suneetRoundWins > slavicRoundWins) {
                    suneetWins++;
                }
            }
        }

        return suneetWins;
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