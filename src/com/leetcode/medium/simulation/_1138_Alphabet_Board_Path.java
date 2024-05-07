package com.leetcode.medium.simulation;

public class _1138_Alphabet_Board_Path {
    //1138. Alphabet Board Path
    //https://leetcode.com/problems/alphabet-board-path/description/

    private int[] xloc = new int[26];

    public String alphabetBoardPath0(String target) {
        for (int i = 0, j = 0; i < 26; i++) {
            xloc[i] = j++;
            if (j > 4) j = 0;
        }
        int x = 0, y = 0;
        StringBuilder sb = new StringBuilder();
        for (char ch: target.toCharArray()) {
            int x1 = getx(ch);
            int y1 = gety(ch);
            while (y > y1) {
                y--;
                sb.append('U');
            }
            while (x1 > x) {
                x++;
                sb.append('R');
            }
            while (x > x1) {
                x--;
                sb.append('L');
            }
            while (y1 > y) {
                y++;
                sb.append('D');
            }
            sb.append('!');
        }
        return sb.toString();
    }

    private int gety(char ch) {
        if (ch >= 'a' && ch <= 'e') return 0;
        if (ch >= 'f' && ch <= 'j') return 1;
        if (ch >= 'k' && ch <= 'o') return 2;
        if (ch >= 'p' && ch <= 't') return 3;
        if (ch >= 'u' && ch <= 'y') return 4;
        return 5;
    }

    private int getx(char ch) {
        return xloc[ch - 'a'];
    }

    public String alphabetBoardPath(String target) {
        int x = 0, y = 0;
        StringBuilder sb = new StringBuilder();
        for (char ch: target.toCharArray()) {
            int x1 = (ch - 'a') % 5;
            int y1 = (ch - 'a') / 5;
            while (y > y1) { y--; sb.append('U'); }
            while (x1 > x) { x++;  sb.append('R'); }
            while (x > x1) { x--;  sb.append('L'); }
            while (y1 > y) { y++; sb.append('D');  }
            sb.append('!');
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        var sol = new _1138_Alphabet_Board_Path();
        sol.alphabetBoardPath("leet");
    }
}
