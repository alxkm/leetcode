package com.leetcode.medium.matrix;

public class _1861_Rotating_the_Box {
    //1861. Rotating the Box
    //https://leetcode.com/problems/rotating-the-box/description/

    public char[][] rotateTheBox(char[][] box) {
        int m = box.length;
        int n = box[0].length;
        char[][] newBox = new char[n][m];
        int col = 0;
        for (int i = m - 1; i >= 0; i--) {
            char[] p = box[i];
            int counter = 0;
            for (int j = 0; j < p.length; j++) {
                if (p[j] == '#') {
                    counter++;
                    p[j] = '.';
                }

                if (j == p.length - 1 || p[j] == '*') {
                    int end = p.length - 1;
                    if (p[j] == '*') {
                        end = j - 1;
                    }
                    for (int k = end; k >= 0 && counter > 0; counter--, k--) {
                        p[k] = '#';
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                newBox[j][col] = p[j];
            }
            col++;
        }
        return newBox;
    }
}
