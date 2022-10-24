package com.leetcode.easy.string.additional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _748_Shortest_Completing_Word {
    static public String shortestCompletingWord(String licensePlate, String[] words) {
        List<Character> list = new ArrayList<>();

        for (char ch : licensePlate.toCharArray()) {
            if (Character.isAlphabetic(ch)) {
                list.add(Character.toLowerCase(ch));
            }
        }

        int foundIndex = 0;
        int counter = -1;

        for (int i = 0; i < words.length; i++) {
            int localCounter = 0;
            Map<Character, Integer> map = new HashMap<>();
            for (char ch : list) {
                Integer key = map.get(ch);
                int from = key == null ? 0 : key + 1;
                int a = words[i].indexOf(ch, from);
                if (a != -1) {
                    map.put(ch, a);
                    localCounter++;
                }
            }
            if (localCounter == counter && words[i].length() < words[foundIndex].length()) {
                foundIndex = i;
                continue;
            }
            if (localCounter > counter) {
                foundIndex = i;
                counter = localCounter;
            }
        }
        return words[foundIndex];
    }

    public static void main(String[] args) {
        // String s = "1s3 PSt";
        // String[] a = {"step","steps","stripe","stepple"};
        // String s = "1s3 456";
        // String[] a = {"looks","pest","stew","show"};


        String s = "OgEu755";
        String[] a = {"enough","these","play","wide","wonder","box","arrive","money","tax","thus"};

        System.out.println(shortestCompletingWord(s, a));
    }
}
