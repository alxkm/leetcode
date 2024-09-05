package com.leetcode.dif.cf.div2._967;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class D {
    static final long MOD = 1000000007;
    static int[] counters = new int[300001];
    static int[] positions = new int[300001];
    static int[] a = new int[300001];
    static List<Integer>[] testList = new ArrayList[300001];
    static boolean[] visited = new boolean[300001];

    static {
        for (int i = 0; i < testList.length; i++) {
            testList[i] = new ArrayList<>();
        }
    }

    public static void solve() throws IOException {
        int n;
        int pt = (int) 1e9;
        n = in.nextInt();
        readArrays(n);
        pt = count(n, pt);
        List<Integer> theMostLong = new ArrayList<>();
        int i = 1;
        while (i <= n) {
            if (i == pt) {
                theMostLong.add(a[i]);
                counters[positions[a[i]]]--;
                while (counters[pt] == 0 && pt <= n) {
                    pt++;
                }
                i++;
            } else {
                if (theMostLong.size() % 2 == 0) {
                    int tempMax = 0;
                    for (int j = i; j <= Math.min(pt, n); ++j) {
                        if (!visited[j]) {
                            tempMax = Math.max(tempMax, a[j]);
                        }
                    }
                    int j = i;
                    while (j <= Math.min(pt, n)) {
                        if (a[j] == tempMax) {
                            i = j + 1;
                            break;
                        }
                        ++j;
                    }
                    if (tempMax == 0) {
                        break;
                    }
                    theMostLong.add(tempMax);
                    counters[positions[tempMax]]--;
                    while (counters[pt] == 0 && pt <= n) {
                        pt++;
                    }
                } else {
                    int tempMax = (int) 1e9;
                    for (int j = i; j <= Math.min(pt, n); ++j) {
                        if (!visited[j]) {
                            tempMax = Math.min(tempMax, a[j]);
                        }
                    }
                    int j = i;
                    while (j <= Math.min(pt, n)) {
                        if (a[j] == tempMax) {
                            i = j + 1;
                            break;
                        }
                        ++j;
                    }
                    if (tempMax == (int) 1e9) {
                        break;
                    }
                    theMostLong.add(tempMax);
                    counters[positions[tempMax]]--;
                    while (counters[pt] == 0 && pt <= n) {
                        pt++;
                    }
                }
            }
            for (int index : testList[theMostLong.get(theMostLong.size() - 1)]) {
                visited[index] = true;
            }
        }
        out.println(theMostLong.size());
        for (int value : theMostLong) {
            out.print(value + EMPTY);
        }
        out.println();
    }
    private static String EMPTY = " ";

    private static int count(int n, int pt) {
        for (int i = 1; i <= n; ++i) {
            positions[a[i]] = i;
            testList[a[i]].add(i);
        }
        for (int i = 1; i <= n; ++i) {
            if (positions[i] != -1) {
                counters[positions[i]]++;
                pt = Math.min(pt, positions[i]);
            }
        }
        return pt;
    }

    private static void readArrays(int n) throws IOException {
        for (int i = 1; i <= n; ++i) {
            a[i] = in.nextInt();
            positions[i] = -1;
            counters[i] = 0;
            visited[i] = false;
            testList[i].clear();
        }
    }

    static long findCorresponding(long first, long second) {
        if (second == 0)
            return 1;
        long another = findCorresponding(first, second / 2);
        if (second % 2 == 0)
            return (another * another) % MOD;
        else
            return (another * another % MOD * first) % MOD;
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