package com.leetcode.easy.string;

public class _1957_Delete_Characters_to_Make_Fancy_String {
    //1957. Delete Characters to Make Fancy String
    //https://leetcode.com/problems/delete-characters-to-make-fancy-string/

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
}
