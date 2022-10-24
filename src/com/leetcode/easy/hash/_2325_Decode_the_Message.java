package com.leetcode.easy.hash;

import java.util.HashMap;
import java.util.Map;

public class _2325_Decode_the_Message {
   static public String decodeMessage(String key, String message) {
        Map<Character, Character> map = new HashMap<>();
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        for (int i = 0, j = 0; i < key.length(); i++) {
            if (key.charAt(i) == ' ' || map.get(key.charAt(i)) != null) continue;
            map.put(key.charAt(i), alphabet[j++]);
        }
        map.put(' ', ' ');
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            sb.append(map.get(message.charAt(i)));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String key = "the quick brown fox jumps over the lazy dog", message = "vkbs bs t suepuv";
        System.out.println(decodeMessage(key, message));
    }
}
