package com.leetcode.hard;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class _1531_String_Compression_II_2 {
    //1531. String Compression II
    //https://leetcode.com/problems/string-compression-ii/description/

    private Map<CompressionInfo, Integer> memo = new HashMap<>();
    private char[] s;
    public int getLengthOfOptimalCompression(String s, int k) {
        this.s = s.toCharArray();
        return f(0, k, '_', 0);
    }

    private int f(int i, int k, char prev, int prevCnt) {
        var optInfo = new CompressionInfo(i, k, prev, prevCnt);

        Integer cachedVal = memo.get(optInfo);
        if (cachedVal != null) return cachedVal;

        if (k < 0) return Integer.MAX_VALUE;
        if (i == s.length) return 0;

        if (s[i] == prev) {
            int increment = (prevCnt == 1 || prevCnt == 9 || prevCnt == 99) ? 1 : 0;
            System.out.println("prev");
            cachedVal = increment + f(i + 1, k, prev, prevCnt + 1);
        } else {
            System.out.println("new");
            cachedVal = Math.min(
                    f(i + 1, k - 1 , prev, prevCnt),     //delete
                    1 + f(i + 1, k, s[i], 1));           // don't delete
        }

        memo.put(optInfo, cachedVal);
        return cachedVal;
    }

    public class CompressionInfo {
        public int i;
        public int k;
        public char prev;
        public int prevCnt;

        public CompressionInfo(int i, int k, char prev, int prevCnt) {
            this.i = i;
            this.k = k;
            this.prev = prev;
            this.prevCnt = prevCnt;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CompressionInfo that = (CompressionInfo) o;
            return i == that.i && k == that.k && prev == that.prev && prevCnt == that.prevCnt;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, k, prev, prevCnt);
        }
    }

    public static void main(String[] args) {
        var sol = new _1531_String_Compression_II_2();
        System.out.println(sol.getLengthOfOptimalCompression("aaaaaaaaaa", 2));
    }
}
