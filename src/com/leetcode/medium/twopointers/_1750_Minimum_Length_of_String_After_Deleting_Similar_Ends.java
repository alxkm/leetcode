package com.leetcode.medium.twopointers;

public class _1750_Minimum_Length_of_String_After_Deleting_Similar_Ends {
    //1750. Minimum Length of String After Deleting Similar Ends
    //https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends/

    public int minimumLength_(String s) {
        if (s.length() == 1) return 1;

        int i = 0, j = s.length() - 1;
        char[] ch = s.toCharArray();

        if (ch[i] != ch[j]) return s.length();

        i++;
        j--;

        while (i < j) {
            if (ch[i] == ch[j]) {
                i++;
                j--;
            } else if (ch[i - 1] == ch[j]) {
                j--;
            } else if (ch[i] == ch[j + 1]) {
                i++;
            } else {
                break;
            }
        }

        if (i >= j) return 0;

        return s.substring(i, j + 1).length();
    }

    public int minimumLength(String s) {
        int i = 0, j = s.length() - 1;
        char[] ch = s.toCharArray();

        while (i < j && ch[i] == ch[j]) {
            char c = ch[i];
            while (i <= j && ch[i] == c) i++;
            while (i < j && ch[j] == c) j--;
        }

        return j - i + 1;
    }
    public static void main(String[] args) {
        var sol = new _1750_Minimum_Length_of_String_After_Deleting_Similar_Ends();
        System.out.println(sol.minimumLength("bbbbbbbbbbbbbbbbbbbbbbbbbbbabbbbbbbbbbbbbbbccbcbcbccbbabbb"));
    }
}
