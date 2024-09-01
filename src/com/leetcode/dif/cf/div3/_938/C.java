package com.leetcode.dif.cf.div3._938;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class C {
    public static void solve() throws IOException {
        long n = in.nextLong();
        long k = in.nextLong();

        Deque<Integer> deque = new LinkedList<>();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.add(num);
            sum += num;
        }

        if (sum <= k) {
            out.println(n);
            return;
        }

        long l = k / 2 + ((k % 2 != 0) ? 1 : 0);
        long r = k / 2;
        long counter = 0;
        while (l > 0 && !deque.isEmpty()) {
            int a = deque.pollFirst();
            if (l < a) break;
            l -= a;
            counter++;
        }

        while (r > 0 && !deque.isEmpty()) {
            int a = deque.pollLast();
            if (r < a) break;
            r -= a;
            counter++;
        }

        out.println(counter);
    }

    public int timeRequiredToBuy(int[] tickets, int k) {
        int i = 0;
        int counter = 0;
        while (tickets[k] != 0) {
            if (tickets[i] > 0) {
                tickets[i]--;
                counter++;
            }
            if (++i == tickets.length) i = 0;
        }
        return counter;
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