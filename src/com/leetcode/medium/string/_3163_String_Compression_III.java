package com.leetcode.medium.string;

public class _3163_String_Compression_III {
    //3163. String Compression III
    //https://leetcode.com/problems/string-compression-iii/description/?envType=daily-question&envId=2024-11-04

    public String compressedString(String word) {
        StringBuilder sb = new StringBuilder();
        char[] ch = word.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            int counter = 1;
            for (int j = i + 1; j < ch.length && ch[j] == c; j++) {
                counter++;
                i = j;
            }
            if (counter > 9) {
                while (counter > 9) {
                    counter -= 9;
                    sb.append(9).append(c);
                }
                if (counter > 0) {
                    sb.append(counter).append(c);
                }
            } else {
                sb.append(counter).append(c);
            }
        }
        return sb.toString();
    }
}
