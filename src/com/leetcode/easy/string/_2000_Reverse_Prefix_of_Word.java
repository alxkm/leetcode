package com.leetcode.easy.string;

public class _2000_Reverse_Prefix_of_Word {
    //2000. Reverse Prefix of Word
    //https://leetcode.com/problems/reverse-prefix-of-word/description/

    static public String reversePrefix(String word, char ch) {
        int index = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ch) {
                index = i;
                break;
            }
        }

        StringBuilder sb = new StringBuilder(word.substring(0, index + 1));
        sb.reverse();
        return sb + word.substring(index + 1);
    }

    public String reversePrefix1(String word, char ch) {
        int index = word.indexOf(ch);
        if (index == -1) return word;
        StringBuilder sb = new StringBuilder(word.substring(0, index + 1));
        StringBuilder s1 = new StringBuilder(word.substring(index + 1, word.length()));
        sb.reverse();
        return sb.toString() + s1.toString();
    }

    public static void main(String[] args) {
        System.out.println(reversePrefix("abcdefd", 'd'));
    }
}
