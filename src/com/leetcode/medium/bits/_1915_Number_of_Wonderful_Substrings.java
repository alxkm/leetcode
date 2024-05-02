package com.leetcode.medium.bits;

import java.util.HashMap;
import java.util.Map;

public class _1915_Number_of_Wonderful_Substrings {
    //1915. Number of Wonderful Substrings
    //https://leetcode.com/problems/number-of-wonderful-substrings/description/

    //tl
    public long wonderfulSubstrings(String word) {
        int answer = 0;
        char[] w = word.toCharArray();
        int n = w.length;
        for (int i = 0; i < n; i++) {
            int[] cn = new int[26];
            for (int j = i; j < n; j++) {
                cn[w[j] - 'a']++;
                int counter = 0;
                for (int l = 0; l < 26; l++) {
                    int k = cn[l];
                    if (k % 2 != 0) counter++;
                    if (counter >= 2) break;
                }
                if (counter <= 1) {
                    answer++;
                }
            }
        }
        return answer;
    }

    public long wonderfulSubstrings1(String word) {
        Map<Integer, Long> prefixCountMap = new HashMap<>();
        prefixCountMap.put(0, 1L);

        int mask = 0;
        long answer = 0;

        for (char ch : word.toCharArray()) {
            mask ^= (1 << (ch - 'a'));

            answer += prefixCountMap.getOrDefault(mask, 0L);

            for (int i = 0; i < 10; i++) {
                int maskWithOneFlipped = mask ^ (1 << i);
                answer += prefixCountMap.getOrDefault(maskWithOneFlipped, 0L);
            }

            prefixCountMap.put(mask, prefixCountMap.getOrDefault(mask, 0L) + 1);
        }

        return answer;
    }
}
