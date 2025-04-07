package com.leetcode.medium.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class _3306_Count_of_Substrings_Containing_Every_Vowel_and_K_Consonants_II {
    //3306. Count of Substrings Containing Every Vowel and K Consonants II
    //https://leetcode.com/problems/count-of-substrings-containing-every-vowel-and-k-consonants-ii/

    public static long countOfSubstrings(String word, int k) {
        int counter = 0;
        int left = 0;
        int right = 0;
        Map<Character, Integer> vowels = new HashMap<>();
        vowels.put('a', 0);
        vowels.put('e', 0);
        vowels.put('i', 0);
        vowels.put('o', 0);
        vowels.put('u', 0);
        int cons = 0;
        while (right < word.length()) {

            char ch = word.charAt(right);

            if (vowels.containsKey(ch)) {
                vowels.merge(ch, 1, (x, y) -> x + 1);
            } else {
                cons++;
            }
            right++;

            boolean allWovels = true;
            for (var v: vowels.values()) {
                if (v <= 0) {
                    allWovels = false;
                }
            }

            if (!allWovels || cons < k) continue;

            if (cons == k && allWovels) {
                counter++;
                continue;
            }
            char firstCh = word.charAt(left);
            if (allWovels && cons > k && !vowels.containsKey(firstCh)) {
                cons--;
                counter++;
            } else {
                vowels.merge(word.charAt(left), 0, (x, y) -> x - 1);
            }
            left++;
        }

        return counter;
    }

    public static void main(String[] args) {
        System.out.println(countOfSubstrings("iqeaouqi", 2));
    }
}
