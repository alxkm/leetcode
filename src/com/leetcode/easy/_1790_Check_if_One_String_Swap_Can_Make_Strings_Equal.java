package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _1790_Check_if_One_String_Swap_Can_Make_Strings_Equal {

    static public boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        if (s1.equals(s2)) return true;

        Set<Character> set1 = new HashSet<>();
        for (Character ch : s1.toCharArray()) {
            set1.add(ch);
        }
        Set<Character> set2 = new HashSet<>();
        for (Character ch : s2.toCharArray()) {
            set2.add(ch);
        }

        if (!set1.containsAll(set2)) return false;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(i)) continue;
            char ch1 = s1.charAt(i);
            if (s2.indexOf(ch1) == -1) {
                return false;
            }
            char ch2 = s2.charAt(i);
            int index = -1;
            for (int j = i + 1; j < s2.length(); j++) {
                if (s1.charAt(j) == s2.charAt(j)) continue;
                if (s2.charAt(j) != s1.charAt(i)) return false;
                index = j;
            }

            if (index == -1) {
                return false;
            }

            String str = s1.substring(0, i) + ch2 + s1.substring(i + 1, index) + ch1 + s1.substring(index + 1);
            return str.equals(s2);
        }
        return false;
    }

    static public boolean areAlmostEqual1(String s1, String s2) {
        if(s1.equals(s2)) return true;
        if(s1.length() != s2.length()) return false;
        List<Character> l1 = new ArrayList<>();
        List<Character> l2 = new ArrayList<>();

        for(int i=0; i<s1.length(); i++){
            if(s1.charAt(i) != s2.charAt(i)){
                l1.add(s1.charAt(i));
                l2.add(s2.charAt(i));
            }
            if(l1.size()>2) return false;
        }

        return (l1.size()==2) && (l1.get(0) == l2.get(1) && l2.get(0) == l1.get(1));
    }

    public static void main(String[] args) {
        //String s1 =  "qqlvguziljnavojtlukwzmgyrqvsqsub";
        //String s2 =  "qqlvgujiljnavoztlukwzmgyrqvsqsub";

       // String s1 = "siyolsdcjthwsiplccjbuceoxmpjgrauocx", s2 = "siyolsdcjthwsiplccpbuceoxmjjgrauocx";
        //String s1 = "aa", s2 = "ac";
        String s1 = "npv", s2 = "zpn";

        System.out.println(areAlmostEqual(s1, s2));
    }
}
