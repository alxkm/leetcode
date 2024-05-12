package com.leetcode.medium.prefix;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _1915_Number_of_Wonderful_Substrings {
    //1915. Number of Wonderful Substrings
    //https://leetcode.com/problems/number-of-wonderful-substrings/description/

    public long wonderfulSubstrings(String word) {
        long answer = 0;
        char[] w = word.toCharArray();
        int n = w.length;
        for (int i = 0; i < n; i++) {
            int[] cn = new int[26];
            for (int j = i; j < n; j++) {
                cn[w[j] - 'a']++;
                int counter = 0;
                for (int l = 0; l < 26; l++) {
                    int k = cn[l];
                    if (k % 2 != 0) {
                        counter++;
                        if (counter >= 2) break;
                    }
                }
                if (counter <= 1) {
                    answer++;
                }
            }
        }
        return answer;
    }

    public long wonderfulSubstrings1(String word) {
        // Map to store frequency of each mask encountered
        Map<Integer, Long> prefixCountMap = new HashMap<>();
        // Start with the empty string prefix, which is a valid "all even" count
        prefixCountMap.put(0, 1L);

        int mask = 0;
        long answer = 0;

        for (char ch : word.toCharArray()) {
            // Update the current mask by flipping the bit corresponding to the current character
            // 'a' at bit 0, 'b' at bit 1, ..., 'j' at bit 9
            mask ^= (1 << (ch - 'a'));

            // Check if the current mask has appeared before
            answer += prefixCountMap.getOrDefault(mask, 0L);

            // Check for masks where exactly one character's count is odd
            for (int i = 0; i < 10; i++) { // Checking for each character a-j
                int maskWithOneFlipped = mask ^ (1 << i);
                answer += prefixCountMap.getOrDefault(maskWithOneFlipped, 0L);
            }

            // Update the prefix count for the current mask
            prefixCountMap.put(mask, prefixCountMap.getOrDefault(mask, 0L) + 1);
        }

        return answer;
    }

    public static void main(String[] args) {
        var sol = new _1915_Number_of_Wonderful_Substrings();
        System.out.println(sol.wonderfulSubstrings("aabb"));
    }
}
