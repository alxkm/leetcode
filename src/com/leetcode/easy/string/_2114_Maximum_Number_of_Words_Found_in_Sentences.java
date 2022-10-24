package com.company.string;

public class _2114_Maximum_Number_of_Words_Found_in_Sentences {
    static public int mostWordsFound(String[] sentences) {
        int max = 0;
        for (int i = 0; i < sentences.length; i++) {
            String[] sentence = sentences[i].split(" ");
            max = Math.max(max, sentence.length);
        }
        return max;
    }

    public static void main(String[] args) {
        String[] sentences = {"alice and bob love leetcode", "i think so too", "this is great thanks very much"};
        System.out.println(mostWordsFound(sentences));
    }
}
