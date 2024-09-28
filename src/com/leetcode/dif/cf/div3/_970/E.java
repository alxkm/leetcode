package com.leetcode.dif.cf.div3._970;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

public class E {

    public static void solve() throws IOException {
        int n = in.nextInt();
        String s = in.next();
        if (n % 2 == 0) {
            processEven(s, n);
        } else {
            processOdd(n, s);
        }
    }

    private static void processOdd(int n, String s) {
        if (n == 1) {
            out.println(1);
            return;
        }
        Map<Character, Integer> evenMap = new HashMap<>();
        Map<Character, Integer> oddMap = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            if (i % 2 == 0) {
                evenMap.put(s.charAt(i), evenMap.getOrDefault(s.charAt(i), 0) + 1);
            } else {
                oddMap.put(s.charAt(i), oddMap.getOrDefault(s.charAt(i), 0) + 1);
            }
        }

        var evenCounter = 0;
        for (int count : evenMap.values()) {
            evenCounter = Math.max(evenCounter, count);
        }

        int oddCounter = 0;
        for (int count : oddMap.values()) {
            oddCounter = Math.max(oddCounter, count);
        }

        int ratio = Integer.MAX_VALUE;
        ratio = calculateEvenOdd(n, s, ratio, evenCounter, oddCounter, evenMap, oddMap);

        out.println(n < 2 ? ratio + 2 : ratio + 1);
    }

    private static int calculateEvenOdd(int n, String str, int answer, int evenCounter, int oddCounter, Map<Character, Integer> evenMap, Map<Character, Integer> oddMap) {
        Map<Character, Integer> evenCounterAfter = new HashMap<>();
        Map<Character, Integer> oddCounterAfter = new HashMap<>();
        answer = Math.min(answer, n / 2 - evenCounter + n / 2 - oddCounter);

        for (int i = n - 2; i >= 0; i--) {
            if (i % 2 == 0) {
                evenMap.put(str.charAt(i), evenMap.get(str.charAt(i)) - 1);
                evenCounterAfter.put(str.charAt(i + 1), evenCounterAfter.getOrDefault(str.charAt(i + 1), 0) + 1);
            } else {
                oddMap.put(str.charAt(i), oddMap.get(str.charAt(i)) - 1);
                oddCounterAfter.put(str.charAt(i + 1), oddCounterAfter.getOrDefault(str.charAt(i + 1), 0) + 1);
            }

            Map<Character, Integer> mergeMap = new HashMap<>(evenMap);
            for (Iterator<Map.Entry<Character, Integer>> iterator = evenCounterAfter.entrySet().iterator(); iterator.hasNext(); ) {
                Map.Entry<Character, Integer> entry = iterator.next();
                mergeMap.put(entry.getKey(), mergeMap.getOrDefault(entry.getKey(), 0) + entry.getValue());
            }

            Map<Character, Integer> oddCounterMerged = new HashMap<>(oddMap);
            for (Iterator<Map.Entry<Character, Integer>> iterator = oddCounterAfter.entrySet().iterator(); iterator.hasNext(); ) {
                Map.Entry<Character, Integer> entry = iterator.next();
                oddCounterMerged.put(entry.getKey(), oddCounterMerged.getOrDefault(entry.getKey(), 0) + entry.getValue());
            }

            evenCounter = 0;
            for (int j : mergeMap.values()) {
                evenCounter = Math.max(evenCounter, j);
            }

            oddCounter = 0;
            for (int j : oddCounterMerged.values()) {
                oddCounter = Math.max(oddCounter, j);
            }

            answer = Math.min(answer, n / 2 - evenCounter + n / 2 - oddCounter);
        }
        return answer;
    }

    private static void processEven(String s, int n) {
        Map<Character, Integer> evenCounterMap = new HashMap<>();
        Map<Character, Integer> oddCounterMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                evenCounterMap.put(s.charAt(i), evenCounterMap.getOrDefault(s.charAt(i), 0) + 1);
            } else {
                oddCounterMap.put(s.charAt(i), oddCounterMap.getOrDefault(s.charAt(i), 0) + 1);
            }
        }

        int evenMaxCount = 0;
        for (int i : evenCounterMap.values()) {
            evenMaxCount = Math.max(evenMaxCount, i);
        }

        int oddMaxCount = 0;
        for (int i : oddCounterMap.values()) {
            oddMaxCount = Math.max(oddMaxCount, i);
        }

        int answer = n / 2 - evenMaxCount + n / 2 - oddMaxCount;
        out.println(answer);
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
