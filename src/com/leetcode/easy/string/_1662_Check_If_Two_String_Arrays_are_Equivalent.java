package com.leetcode.easy.string;

public class _1662_Check_If_Two_String_Arrays_are_Equivalent {
    //1662. Check If Two String Arrays are Equivalent
    //https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/description/

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        for (String s: word1) sb1.append(s);
        StringBuilder sb2 = new StringBuilder();
        for (String s: word2) sb2.append(s);
        return sb1.toString().equals(sb2.toString());
    }
}
