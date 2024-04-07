package com.leetcode.medium.matrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _1329_Sort_the_Matrix_Diagonally {
    //https://leetcode.com/problems/sort-the-matrix-diagonally/
    //1329. Sort the Matrix Diagonally
    //any diagonal has property i - j, any sub diagonal has property i - j

    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        for (int j = n - 1; j >= 0; j--) {
            int l = 0;
            int k = j;
            List<Integer> list = new ArrayList<>();
            while (k < n && l < m) {
                System.out.println(k);
                list.add(mat[l][k]);
                l++;
                k++;
            }
            Collections.sort(list);
            l = 0;
            k = j;
            int i = 0;
            while (k < n && l < m) {
                mat[l][k] = list.get(i);
                i++;
                k++;
                l++;
            }
        }
        for (int i = 0; i < m; i++) {
            int l = i;
            int k = 0;
            List<Integer> list = new ArrayList<>();
            while (l < m && k < n) {
                list.add(mat[l][k]);
                l++;
                k++;
            }
            Collections.sort(list);
            l = i;
            k = 0;
            int j = 0;
            while (l < m && k < n) {
                mat[l][k] = list.get(j);
                l++;
                k++;
                j++;
            }
        }
        return mat;
    }
}
