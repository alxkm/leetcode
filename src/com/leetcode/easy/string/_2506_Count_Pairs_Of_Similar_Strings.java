package com.leetcode.easy.string;

public class _2506_Count_Pairs_Of_Similar_Strings {
    //2506. Count Pairs Of Similar Strings
    //https://leetcode.com/problems/count-pairs-of-similar-strings/

    public int similarPairs(String[] words) {
        int counter = 0;
        for (int i = 0; i < words.length - 1; i++) {

            boolean[] s = new boolean[26];
            for (char ch: words[i].toCharArray()) s[ch - 'a'] = true;

            for (int j = i + 1; j < words.length; j++) {
                boolean[] s1 = new boolean[26];
                for (char ch: words[j].toCharArray()) s1[ch - 'a'] = true;

                boolean equals = true;
                for (int k = 0; k < 26; k++) {
                    if (s[k] != s1[k]) {
                        equals = false;
                        break;
                    }
                }
                if (equals) counter++;
            }
        }
        return counter;
    }
}
