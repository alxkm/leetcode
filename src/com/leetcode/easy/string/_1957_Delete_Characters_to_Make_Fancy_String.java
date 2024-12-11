package com.leetcode.easy.string;

public class _1957_Delete_Characters_to_Make_Fancy_String {
    //1957. Delete Characters to Make Fancy String
    //https://leetcode.com/problems/delete-characters-to-make-fancy-string/description/

    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        char prev = s.charAt(0);
        char[] ch = s.toCharArray();
        int l = 1;
        for (int i = 1; i < s.length(); i++) {
            if (ch[i] == prev) {
                if (l == 2) {
                    continue;
                } else {
                    l++;
                    sb.append(ch[i]);
                }
            } else {
                l = 1;
                prev = ch[i];
                sb.append(ch[i]);
            }
        }
        return sb.toString();
    }

    public String makeFancyString1(String s) {
        if (s.length() < 3) return s;
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        sb.append(s.charAt(1));
        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1) && s.charAt(i) == s.charAt(i - 2)) {
                continue;
            }
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
