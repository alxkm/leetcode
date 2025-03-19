package com.leetcode.medium.string;

import java.util.ArrayList;
import java.util.List;

public class _1324_Print_Words_Vertically {
    //1324. Print Words Vertically
    //https://leetcode.com/problems/print-words-vertically/description/

    public static List<String> printVertically(String s) {
        List<StringBuilder> l = new ArrayList<>();
        String[] ar = s.split(" ");
        int j = 0;
        int max = 0;
        for (String str: ar) {
            max = Math.max(max, str.length());
        }

        for (int i = 0; i < s.length(); i++) {
            l.add(new StringBuilder());
        }

        int k = 0;
        while (true) {
            boolean end = false;
            for (int i = 0; i < ar.length; i++) {
                if (j >= ar[i].length()) {
                    l.get(k).append(" ");
                    continue;
                }
                l.get(k).append(ar[i].charAt(j));
                end = true;
            }
            j++;
            k++;
            if (!end) {
                break;
            }
        }
        List<String> list = new ArrayList<>();
        for (StringBuilder sb : l) {
            String str = sb.toString().stripTrailing();
            if (str.equals("") || str == null) continue;
            list.add(str);
        }
        return list;
    }

    public static List<String> printVertically1(String s) {
        List<StringBuilder> l = new ArrayList<>();
        String[] strs = s.split(" ");
        int max = 0;
        for (String str : strs) {
            max = Math.max(max, str.length());
        }
        for (int i = 0; i < s.length(); i++) {
            l.add(new StringBuilder());
        }

        for (int i = 0; i < max; i++) {
            for (String str : strs) {
                if (i < str.length()) {
                    l.get(i).append(str.charAt(i));
                } else {
                    l.get(i).append(" ");
                }
            }
        }

        List<String> list = new ArrayList<>();
        for (StringBuilder sb : l) {
            list.add(sb.toString().stripTrailing());
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(printVertically("HOW ARE YOU"));
    }
}
