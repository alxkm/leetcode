package com.leetcode.easy.string.additional;

public class _942_DI_String_Match {
    public int[] diStringMatch(String s) {
        int max = s.length();
        int[] arr = new int[max + 1];
        int min = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'I') arr[i] = min++;
            else arr[i] = max--;
        }
        if (s.length() - 1 == 'I') arr[s.length()] = min++;
        else  arr[s.length()] = max--;
        return arr;
    }
}
