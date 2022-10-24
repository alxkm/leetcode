package com.leetcode.easy.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1078_Occurrences_After_Bigram {
    static public String[] findOcurrences(String text, String first, String second) {
        String[] ar = text.split(" ");
        List<String> l = new ArrayList<>();
        for (int i = 0; i < ar.length; i++) {
            if (i + 2 < ar.length && ar[i].equals(first) && ar[i + 1].equals(second)) {
                l.add(ar[i + 2]);
//                i += 2;
//                if (first.equals(ar[i])) {
//                    i--;
//                }
            }
        }
        String[] s = new String[l.size()];
        for (int i = 0; i < l.size(); i++) {
            s[i] = l.get(i);
        }
        return s;
    }

    public static void main(String[] args) {
        String a = "we will we will rock you";
        String f = "we", s ="will";


//        String a = "alice is a good girl she is a good student";
//        String f = "a", s = "good";

//        ["we","we","will"]
//        String a = "we we we we will rock you";
//        String f = "we", s = "we";

        System.out.println(Arrays.toString(findOcurrences(a, f, s)));
    }
}
