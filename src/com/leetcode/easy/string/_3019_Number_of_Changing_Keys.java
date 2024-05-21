package com.leetcode.easy.string;

public class _3019_Number_of_Changing_Keys {
    //3019. Number of Changing Keys
    //https://leetcode.com/problems/number-of-changing-keys/description/

    public int countKeyChanges(String s) {
        char[] s1 = s.toCharArray();
        for (int i = 0; i < s1.length; i++) {
            s1[i] = Character.toLowerCase(s1[i]);
        }
        int counter = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s1[i] != s1[i - 1]) counter++;
        }
        return counter;
    }
}
