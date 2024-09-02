package com.leetcode.easy.matrix;

import java.util.List;

public class _3248_Snake_in_Matrix {
    //3248. Snake in Matrix
    //https://leetcode.com/problems/snake-in-matrix/description/

    public int finalPositionOfSnake(int n, List<String> commands) {
        int i = 0;
        int j = 0;
        for (String s: commands) {
            if (s.equals("UP")) {
                i--;
            } else if (s.equals("DOWN")) {
                i++;
            } else if (s.equals("RIGHT")) {
                j++;
            } else if (s.equals("LEFT")) {
                j--;
            }
        }
        return (i * n) + j;
    }
}
