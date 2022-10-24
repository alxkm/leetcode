package com.company.string;

public class _1221_Split_a_String_in_Balanced_Strings {
    public int balancedStringSplit(String s) {
        int counter = 0;
        int l = 0;
        int r = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                l++;
            } else {
                r++;
            }
            if (r != 0 && r == l) {
                counter++;
                r = 0;
                l = 0;
            }
        }
        return counter;
    }
}
