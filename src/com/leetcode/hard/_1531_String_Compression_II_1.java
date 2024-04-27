package com.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

public class _1531_String_Compression_II_1 {
    //1531. String Compression II
    //https://leetcode.com/problems/string-compression-ii/description/

    Map<String, Integer> memo = new HashMap<>();

    public int getLengthOfOptimalCompression(String s, int k) {
        return f(s.toCharArray(), ' ', 0, k, 0);
    }

    private int f(char[] s, char prevChar, int prevCharCount, int k, int i) {
        if (i == s.length) return 0;
        String key = prevChar + ", " + prevCharCount + ", " + k + ", " + i;
        Integer cachedValue = memo.get(key);
        if (cachedValue != null) return cachedValue;
        char ch = s[i];
        int count = 1;
        int nextIndex = i + 1;

        for (int j = i + 1; j < s.length; j++) {
            if (s[j] == ch) {
                count++;
                nextIndex = j + 1;
            } else {
                nextIndex = j;
                break;
            }
        }
        int totalCount = count;
        int prevCountRepresentation = 0;

        if (ch == prevChar) {
            totalCount += prevCharCount;
            prevCountRepresentation = getLength(prevCharCount);
        }

        int representationLength = getLength(totalCount);
        int ans = representationLength + f(s, ch, totalCount, k, nextIndex) - prevCountRepresentation;

        if (k > 0) {
            for (int j = 1; j <= k && j <= count; j++) {
                int currentCount = totalCount - j;
                int length = getLength(currentCount);
                int holder = length + f(s, currentCount == 0 ? prevChar : ch,
                        currentCount == 0 ? prevCharCount : currentCount, k - j, nextIndex) -
                        prevCountRepresentation;
                ans = Math.min(ans, holder);
            }
        }
        memo.put(key, ans);
        return ans;
    }

    private int getLength(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n < 10) {
            return 2;
        } else if (n < 100) {
            return 3;
        } else {
            return 4;
        }
    }

    public static void main(String[] args) {
        var sol = new _1531_String_Compression_II_1();
        System.out.println(sol.getLengthOfOptimalCompression("aaabcccd", 2));
    }
}
