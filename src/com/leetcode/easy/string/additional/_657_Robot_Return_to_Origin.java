package com.leetcode.easy.string.additional;

public class _657_Robot_Return_to_Origin {
    public boolean judgeCircle(String moves) {
        int u = 0, d = 0, l = 0, r = 0;
        for (char ch : moves.toCharArray()) {
            if (ch == 'U') u++;
            else if (ch == 'D') d++;
            else if (ch == 'R') r++;
            else if (ch == 'L') l++;
        }
        return u == d && l == r;
    }
}
