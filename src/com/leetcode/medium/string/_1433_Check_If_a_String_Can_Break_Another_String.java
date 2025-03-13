package com.leetcode.medium.string;

import java.util.Arrays;

public class _1433_Check_If_a_String_Can_Break_Another_String {
    //1433. Check If a String Can Break Another String
    //https://leetcode.com/problems/check-if-a-string-can-break-another-string/description/

    public boolean checkIfCanBreak(String s1, String s2) {
        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();

        Arrays.sort(ch1);
        Arrays.sort(ch2);

        boolean b1 = true, b2 = true;
        for (int i = 0; i < s1.length(); i++) {
            if (ch1[i] < ch2[i]) {
                b1 = false;
            }

            if (ch2[i] < ch1[i]) {
                b2 = false;
            }
        }

        return b1 || b2;
    }
}
