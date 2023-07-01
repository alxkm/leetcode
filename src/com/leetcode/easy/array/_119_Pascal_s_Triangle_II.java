package com.leetcode.easy.array;

import java.util.ArrayList;
import java.util.List;

public class _119_Pascal_s_Triangle_II {
    //https://leetcode.com/problems/pascals-triangle-ii/

    static public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>(rowIndex  + 1);
        if (rowIndex == 0) return List.of(1);
        if (rowIndex == 1) return List.of(1, 1);
        list.add(1);
        list.add(1);
        for (int i = 2; i <= rowIndex; i++) {
            int prev = list.get(0);
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    if (j == 0)
                        list.set(j, 1);
                    else
                        list.add(1);
                } else {
                    int cur = prev + list.get(j);
                    prev = list.get(j);
                    list.set(j, cur);
                }
            }
        }
        return list;
    }

    public List<Integer> getRow1(int rowIndex) {
        if (rowIndex == 0) return List.of(1);
        List<Integer> l = new ArrayList<>(rowIndex + 1);
        l.add(1);
        l.add(1);
        for (int i = 1; i < rowIndex; i++) {
            int prev = l.get(0);
            for (int j = 1; j <= i; j++) {
                int cur = l.get(j) + prev;
                prev = l.get(j);
                l.set(j, cur);
            }
            l.add(1);
        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println(getRow(5));
    }
}
