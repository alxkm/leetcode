package com.leetcode.medium.hashtable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class _1647_Minimum_Deletions_to_Make_Character_Frequencies_Unique {
    //1647. Minimum Deletions to Make Character Frequencies Unique
    //https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/description/

    public int minDeletions(String s) {
        int[] fr = new int[26];

        for (char ch: s.toCharArray()) {
            fr[ch - 'a']++;
        }

        int answ = 0;
        while (true) {
            Arrays.sort(fr);
            for (int i = fr.length - 2; i >= 0; i--) {
                if (fr[i] == 0) return answ;
                if (fr[i] == fr[i + 1]) {
                    fr[i]--;
                    answ++;
                    break;
                }
                if (i == 0) return answ;
            }
        }

        // return answ;
    }

    public int minDeletions1(String s) {
        int[] fr = new int[26];
        for (char ch: s.toCharArray()) {
            fr[ch - 'a']++;
        }
        int deletions = 0;
        Set<Integer> set = new HashSet<>();
        for (int freq: fr) {
            while (freq > 0 && set.contains(freq)) {
                deletions++;
                freq--;
            }
            set.add(freq);
        }
        return deletions;
    }

    public static void main(String[] args) {
        var sol = new _1647_Minimum_Deletions_to_Make_Character_Frequencies_Unique();
        String s = "abcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwzabcdefghijklmnopqrstuvwxwz";

        String s1 = "aaabbbcc";
        System.out.println(sol.minDeletions(s));
    }
}
