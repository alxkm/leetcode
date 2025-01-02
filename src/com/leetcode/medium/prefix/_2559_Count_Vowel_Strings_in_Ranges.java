package com.leetcode.medium.prefix;

import com.leetcode.ArrayUtil;

import java.util.Set;

public class _2559_Count_Vowel_Strings_in_Ranges {
    //2559. Count Vowel Strings in Ranges
    //https://leetcode.com/problems/count-vowel-strings-in-ranges/?envType=daily-question&envId=2025-01-02

    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] pr = new int[words.length + 1];
        Set<Character> vowel = Set.of('a', 'e', 'i', 'o', 'u');
        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            int cnt = 0;
            if (vowel.contains(w.charAt(0)) && vowel.contains(w.charAt(w.length() - 1))) {
                cnt = 1;
            }
            pr[i + 1] = pr[i] + cnt;
        }

        int[] ar = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            ar[i] = pr[end + 1] - pr[start];
        }

        return ar;
    }

    public static void main(String[] args) {
        var sol = new _2559_Count_Vowel_Strings_in_Ranges();
        System.out.println(sol.vowelStrings(ArrayUtil.of("aba", "bcb", "ece", "aa", "e"), ArrayUtil.to2d("[[0,2],[1,4],[1,1]]")));
    }
}
