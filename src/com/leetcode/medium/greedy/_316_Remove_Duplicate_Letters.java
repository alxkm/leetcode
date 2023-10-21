package com.leetcode.medium.greedy;

import java.util.Stack;

public class _316_Remove_Duplicate_Letters {
    //https://leetcode.com/problems/remove-duplicate-letters/
    //316. Remove Duplicate Letters
    //FOREIGN_SOLUTION
    //list
    //NOT_OPTIMAL
    //TOP

    public String removeDuplicateLetters(String s) {
        int[] freq = new int[26];
        for (char ch: s.toCharArray()) {
            freq[ch - 'a']++;
        }
        boolean[] seen = new boolean[26];
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.toCharArray()[i];
            freq[ch - 'a']--;
            if (seen[ch - 'a']) continue;

            while (!st.isEmpty() && st.peek() > ch && freq[st.peek() - 'a'] != 0) {
                seen[st.peek() - 'a'] = false;
                st.pop();
            }

            seen[ch - 'a'] = true;
            st.push(ch);
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) {
            sb.append(st.pop());
        }
        sb.reverse();
        return sb.toString();
    }
}
