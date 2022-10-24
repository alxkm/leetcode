package com.leetcode.easy.string.additional;

public class _944_Delete_Columns_to_Make_Sorted {
    static public int minDeletionSize(String[] strs) {
        int cnt = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            char prev = ' ';
            for (int j = 0; j < strs.length; j++) {
                if (prev == ' ') {
                    prev = strs[j].charAt(i);
                    continue;
                }
                char cur = strs[j].charAt(i);
                if (prev > cur) {
                    cnt++;
                    break;
                }
                prev = cur;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        //String[] s = {"a","b"};
        String[] s = {"zyx","wvu","tsr"};
        //String[] s = {"rrjk","furt","guzm"};
        System.out.println(minDeletionSize(s));
    }
}
