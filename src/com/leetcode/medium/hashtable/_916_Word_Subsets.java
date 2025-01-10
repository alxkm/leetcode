package com.leetcode.medium.hashtable;

import com.leetcode.ArrayUtil;

import java.util.ArrayList;
import java.util.List;

public class _916_Word_Subsets {
    //916. Word Subsets
    //https://leetcode.com/problems/word-subsets/description/

    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<int[]> words = new ArrayList<>();
        for (var word : words1) {
            int[] counter = new int[26];
            for (char ch : word.toCharArray()) {
                counter[ch - 'a']++;
            }
            words.add(counter);
        }

        int[] max = new int[26];
        for (String s : words2) {
            int[] counter = new int[26];
            for (char ch : s.toCharArray()) {
                counter[ch - 'a']++;
                max[ch - 'a'] = Math.max(counter[ch - 'a'], max[ch - 'a']);
            }
        }

        List<String> l = new ArrayList<>();
        for (int i = 0; i < words.size(); i++) {
            boolean contains = true;
            int[] curWordCounter = words.get(i);

            for (int k = 0; k < max.length; k++) {
                if (curWordCounter[k] >= max[k]) continue;
                contains = false;
                break;
            }

            if (contains) {
                l.add(words1[i]);
            }
        }
        return l;
    }

    public static List<String> wordSubsets1(String[] words1, String[] words2) {
        List<int[]> words = new ArrayList<>();
        for (var word : words1) {
            int[] counter = new int[26];
            for (char ch : word.toCharArray()) {
                counter[ch - 'a']++;
            }
            words.add(counter);
        }

        int[] max = new int[26];
        for (String s : words2) {
            int[] counter = new int[26];
            for (char ch : s.toCharArray()) {
                counter[ch - 'a']++;
                max[ch - 'a'] = Math.max(counter[ch - 'a'], max[ch - 'a']);
            }
        }

        List<String> l = new ArrayList<>();
        for (int i = 0; i < words.size(); i++) {
            boolean contains = true;
            int[] curWordCounter = words.get(i);

            for (int k = 0; k < max.length; k++) {
                if (curWordCounter[k] >= max[k]) continue;
                contains = false;
                break;
            }

            if (contains) {
                l.add(words1[i]);
            }
        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println(wordSubsets1(ArrayUtil.of("amazon", "apple", "facebook", "google", "leetcode"), ArrayUtil.of("lo", "eo")));
        System.out.println(wordSubsets1(ArrayUtil.of("amazon", "apple", "facebook", "google", "leetcode"), ArrayUtil.of("e", "o")));
    }
}
