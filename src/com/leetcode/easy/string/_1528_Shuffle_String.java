package com.company.string;

import java.util.Arrays;

public class _1528_Shuffle_String {
    static public String restoreString(String s, int[] indices) {
        StringBuilder sb = new StringBuilder();
        char[] s1 = new char[indices.length];
        for (int i = 0; i < indices.length; i++) {
           s1[indices[i]] =  s.charAt(i);
        }
        for (char i : s1) {
            sb.append(i);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s =       "codeleet";
        int[] indices = {4,5,6,7,0,2,1,3};
        System.out.println(restoreString(s, indices));
    }
}
