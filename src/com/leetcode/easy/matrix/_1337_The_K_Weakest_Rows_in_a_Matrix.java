package com.company.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _1337_The_K_Weakest_Rows_in_a_Matrix {
    static public int[] kWeakestRows(int[][] mat, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < mat.length; i++) {
            int counter = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    counter++;
                }
            }
            map.put(i, counter);
        }
        List<Integer> a = new ArrayList<>();
        for (int i = 0; i < mat.length; i++) {
            int key = 0;
            int v = 100000;
            for (Map.Entry<Integer, Integer> e : map.entrySet()) {
                if (e.getValue() < v) {
                    key = e.getKey();
                    v = e.getValue();
                } else if (e.getValue() == v && e.getKey() < key) {
                    key = e.getKey();
                    v = e.getValue();
                }
            }
            a.add(key);
            if (mat.length - map.size() == k) break;
            map.remove(key);
        }
        int[] b = new int[k];
        for (int i = 0; i < k; i++) {
            b[i] = a.get(i);
        }
        return b;
    }

    public static void main(String[] args) {
        int[][] a = {
                {1,1,0,0,0},
                {1,1,1,1,0},
                {1,0,0,0,0},
                {1,1,0,0,0},
                {1,1,1,1,1}
        };
        System.out.println(Arrays.toString(kWeakestRows(a, 3)));
    }
}
