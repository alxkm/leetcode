package com.company.string;

import java.util.Arrays;

public class _2138_Divide_a_String_Into_Groups_of_Size_k {
    static public String[] divideString(String s, int k, char fill) {
        int extra = 0;
        int size = s.length();
        while ((size + extra) % k != 0) extra++;
        String[] a = new String[(size + extra) / k];
        for (int i = 0; i < a.length; i++) {
            if ((i == a.length - 1) && extra != 0) {
                StringBuilder sb = new StringBuilder(s);
                while (extra != 0) {
                    sb.append(fill);
                    extra--;
                }
                a[i] = sb.toString();
            } else {
                a[i] = s.substring(0, k);
                s = s.substring(k);
            }
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(divideString("abcdefghij", 3, 'x')));
    }
}
