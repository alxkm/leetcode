package com.leetcode.easy.hash;

public class _1790_Check_if_One_String_Swap_Can_Make_Strings_Equal {
    //1790. Check if One String Swap Can Make Strings Equal
    //https://leetcode.com/problems/check-if-one-string-swap-can-make-strings-equal/description/?envType=daily-question&envId=2025-02-05

    public boolean areAlmostEqual(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        int[] a1 = new int[26];
        int[] a2 = new int[26];


        for (int i = 0; i < s1.length(); i++) {
            a1[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            a2[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < a1.length; i++) {
            if (a1[i] != a2[i]) {
                return false;
            }
        }

        return true;
    }
}
