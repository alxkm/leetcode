package com.leetcode.easy.string;

public class _387_First_Unique_Character_in_a_String {
    //387. First Unique Character in a String
    //https://leetcode.com/problems/first-unique-character-in-a-string/description/

    public int firstUniqChar(String s) {
        int [] map = new int [26];
        for (char ch: s.toCharArray()) map[ch - 'a']++;
        for (int i = 0; i < s.length(); i++) if (map[s.charAt(i) - 'a'] == 1) return i;
        return -1;
    }
}
