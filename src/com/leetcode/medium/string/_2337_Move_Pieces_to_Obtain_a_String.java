package com.leetcode.medium.string;

public class _2337_Move_Pieces_to_Obtain_a_String {
    //https://leetcode.com/problems/move-pieces-to-obtain-a-string/description/
    //2337. Move Pieces to Obtain a String

    public boolean canChange(String start, String target) {
        int i = 0, j = 0;
        int n = start.length();

        while (i < n || j < n) {
            while (i < n && start.charAt(i) == '_')
                i++;
            while (j < n && target.charAt(j) == '_')
                j++;

            if (i == n || j == n)
                return i == n && j == n;

            if (start.charAt(i) != target.charAt(j))
                return false;

            if (start.charAt(i) == 'L' && i < j)
                return false;
            if (start.charAt(i) == 'R' && i > j)
                return false;

            i++;
            j++;
        }

        return true;
    }
}
