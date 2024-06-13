package com.leetcode.easy.string;

import java.util.Deque;
import java.util.LinkedList;

public class _2697_Lexicographically_Smallest_Palindrome {
    //2697. Lexicographically Smallest Palindrome
    //https://leetcode.com/problems/lexicographically-smallest-palindrome/description/

    public String makeSmallestPalindrome(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        if (n == 1) return s;
        if (n == 3) {
            char ch = (s.charAt(0) < s.charAt(n - 1)) ? s.charAt(0) : s.charAt(n - 1);
            sb.append(ch).append(s.charAt(1)).append(ch);
            return sb.toString();
        }
        int i = n / 2 - 1, j = n / 2;
        Deque<Character> deq = new LinkedList<>();
        if (n % 2 != 0) {
            deq.add(s.charAt(j));
            j++;
        }
        while (i >= 0 && j < n) {
            char ch = (s.charAt(i) < s.charAt(j)) ? s.charAt(i) : s.charAt(j);
            deq.addFirst(ch);
            deq.addLast(ch);
            i--;
            j++;
        }
        for (Character ch : deq) {
            sb.append(ch);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        var sol = new _2697_Lexicographically_Smallest_Palindrome();
        System.out.println(sol.makeSmallestPalindrome("egcfe"));
        //System.out.println(sol.makeSmallestPalindrome("abcd"));
        //System.out.println(sol.makeSmallestPalindrome("aksguou"));
    }
}
