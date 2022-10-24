package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class _1002_Find_Common_Characters {
    static public List<String> commonChars(String[] words) {
        List<String> s = new ArrayList<>();
        String f = words[0];

        for (int i = 0; i < words[0].length(); i++) {
            boolean contains = true;
            for (int j = 1; j < words.length; j++) {
                int index = words[j].indexOf(f.charAt(i));
                if (index == -1) {
                    contains = false;
                    break;
                } else {
                    String str = words[j].substring(0, index) + words[j].substring(index + 1);
                    words[j] = str;
                }
            }
            if (contains) {
                s.add(String.valueOf(f.charAt(i)));
            }
        }
        return s;
    }

    public static void main(String[] args) {
        String[] s = {"cool","lock","cook"};

        System.out.println(commonChars(s));
    }
}
