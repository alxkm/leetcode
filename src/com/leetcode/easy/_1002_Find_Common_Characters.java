package com.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class _1002_Find_Common_Characters {
    //1002. Find Common Characters
    //https://leetcode.com/problems/find-common-characters/description/

    static public List<String> commonChars1(String[] words) {
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

    public static List<String> commonChars(String[] words) {
        List<int[]> list = new ArrayList<>();

        for (String s: words) {
            char[] ch = s.toCharArray();
            int[] ar = new int[26];
            for (char c: ch) {
                ar[c - 'a']++;
            }
            list.add(ar);
        }
        List<String> l = new ArrayList<>();
        for (char ch: words[0].toCharArray()) {
            int counter = 0;
            for (int[] ar : list) {
                if (ar[ch - 'a'] <= 0) break;
                else ar[ch - 'a']--;
                counter++;
            }
            if (counter == list.size()) l.add(String.valueOf(ch));
        }
        return l;
    }

    public static void main(String[] args) {
        //String[] s = {"cool","lock","cook"};
        String[] s = {"bella","label","roller"};

        System.out.println(commonChars(s));
    }
}
