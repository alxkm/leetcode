package com.leetcode.dif.cf.div3._966;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class D {
    public static void solve() throws IOException {
        int n = in.nextInt();
        int[] ar = new int[n];
        long sum = 0;

        for (int i = 0; i < n; i++) {
            ar[i] = in.nextInt();
            sum += ar[i];
        }

        char[] directions = in.nextLine().toCharArray();
        long maxScore = 0;
        int left = 0;
        int right = n - 1;

        while (right > left) {
            while (left < n && directions[left] == 'R') {
                sum -= ar[left];
                left++;
            }
            while (right >= 0 && directions[right] == 'L') {
                sum -= ar[right];
                right--;
            }
            if (right < left) break;

            maxScore += sum;
            sum -= ar[left];
            left++;
            sum -= ar[right];
            right--;
        }

        out.println(maxScore);
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