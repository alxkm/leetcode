package com.leetcode.medium.string;

import java.util.Set;

public class  _1456_Maximum_Number_of_Vowels_in_a_Substring_of_Given_Length {
    //https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/

    public int maxVowels(String s, int k) {
        Set<Character> set = Set.of('a', 'e', 'i', 'o', 'u');
        int size = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < k; i++) {
            if (set.contains(arr[i])) {
                size++;
            }
        }
        int max = size;
        for (int i = 1; i <= arr.length - k; i++) {
            if (set.contains(arr[i - 1])) size--;
            if (set.contains(arr[i + k - 1])) size++;
            max = Math.max(max, size);
        }
        return max;
    }
}
