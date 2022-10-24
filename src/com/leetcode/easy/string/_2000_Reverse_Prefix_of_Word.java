package com.leetcode.easy.string;

public class _2000_Reverse_Prefix_of_Word {
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

    public static void main(String[] args) {
        System.out.println(reversePrefix("abcdefd", 'd'));
    }
}
