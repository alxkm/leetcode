package com.leetcode.top;

import java.util.ArrayList;
import java.util.List;

public class _48_Rotate_Image {
    //https://leetcode.com/problems/rotate-image/
    //FOREIGN_SOLUTION
    //Matrix
    //TOP

    private int[][] m;
    private int n = 0;

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        m = matrix;
        int i = 0, j = 0, im = n, jm = n;
        while (i != im && i < im) {
            rotate(i, j, im, jm);
            i++;
            j++;
            im--;
            jm--;
        }
    }

    private void rotate(int ii, int jj, int im, int jm) {
        //copy first line
        List<Integer> l1 = new ArrayList<>();
        for (int j = jj; j < jm; j++) {
            l1.add(m[ii][j]);
        }
        //copy second line
        List<Integer> l2 = new ArrayList<>();
        for (int i = 0; i < im; i++) {
            l2.add(m[i][jm -1]);
        }
        //copy third
        List<Integer> l3 = new ArrayList<>();
        for (int j = jj; j < jm; j++) {
            l3.add(m[im - 1][j]);
        }
        //copy forth
        var l4 = new ArrayList<Integer>();
        for (int i = ii; i < im; i++) {
            l4.add(m[i][jj]);
        }
        //swaped first with second
        for (int i = ii, l = 0; i < im; i++) {
            m[i][jm - 1] = l1.get(l++);
        }
        //swap second with third
        for (int j = jj, l = l2.size() - 1; j < jm; j++) {
            m[im - 1][j] = l2.get(l--);
        }
        //swaped third with forth
        for (int i = ii, l = 0; i < im; i++) {
            m[i][jj] = l3.get(l++);
        }
        //swaped forth with first
        for (int j = jj, l = l4.size() - 1; j < jm; j++) {
            m[ii][j] = l4.get(l--);
        }
    }
}
