package com.leetcode.medium.matrix;

import java.util.Arrays;

public class _2120_Execution_of_All_Suffix_Instructions_Staying_in_a_Grid {
    //2120. Execution of All Suffix Instructions Staying in a Grid
    //https://leetcode.com/problems/execution-of-all-suffix-instructions-staying-in-a-grid/

    public int[] executeInstructions(int n, int[] startPos, String s) {
        int[] ar = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            ar[i] = dfs(n, startPos[0], startPos[1], 0, s.toCharArray(), i);
        }
        return ar;
    }

    private int dfs(int n, int i, int j, int counter, char[] ch, int cur) {
        if (cur == ch.length) return counter;

        char curCh = ch[cur];
        if (curCh == 'U') i--;
        else if (curCh == 'D') i++;
        else if (curCh == 'R') j++;
        else if (curCh == 'L') j--;

        if (i < 0 || i >= n || j < 0 || j >= n) return counter;

        return dfs(n, i, j, counter + 1, ch, cur + 1);
    }

    public static void main(String[] args) {
        var sol = new _2120_Execution_of_All_Suffix_Instructions_Staying_in_a_Grid();
        System.out.println(Arrays.toString(sol.executeInstructions(3, new int[]{0, 1}, "RRDDLU")));
    }
}
