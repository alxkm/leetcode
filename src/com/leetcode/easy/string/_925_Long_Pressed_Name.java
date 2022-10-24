package com.leetcode.easy.string;

public class _925_Long_Pressed_Name {

    static     public boolean isLongPressedName(String name, String typed) {
        if (typed.charAt(0) != name.charAt(0)) return false;
        if (typed.charAt(typed.length() - 1) != name.charAt(name.length() - 1)) return false;
        char prev = name.charAt(0);

        for (int i = 1, j = 1; i < name.length() && j < typed.length(); i++, j++) {

            while (j != typed.length() && typed.charAt(j) != name.charAt(i)) {
                if (typed.charAt(j) == prev  || typed.charAt(j) == name.charAt(i)) {
                    j++;
                    continue;
                }
                return false;
            }

            if ((j == typed.length() - 1) && (i != name.length() - 1)) {
                return false;
            }

            if ((i == name.length() - 1) && (j != typed.length() - 1)
                    && name.charAt(i) != typed.charAt(++j)) {
                return false;
            }

            if (j != typed.length() && typed.charAt(j) == name.charAt(i)) {
                prev = name.charAt(i);
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //String name = "alex", typed =  "aaleex";
        //String name = "saeed", typed = "ssaaedd";
        //String name = "rick", typed = "kric";
        //String name = "alex", typed = "aaleexeex";
        //String name = "alex", typed = "aaleelx";

        String name = "bdad", typed = "bbbd";

        System.out.println(isLongPressedName(name, typed));
    }
}
