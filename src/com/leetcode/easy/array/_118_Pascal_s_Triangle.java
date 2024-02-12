package com.leetcode.easy.array;

import java.util.ArrayList;
import java.util.List;

public class _118_Pascal_s_Triangle {
    //https://leetcode.com/problems/pascals-triangle/
    //118. Pascal's Triangle

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(List.of(1));
        if (numRows == 1) return list;
        list.add(List.of(1, 1));
        if (numRows == 2) return list;

        for (int i = 2; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            List<Integer> prev = list.get(i - 1);
            for (int j = 0; j < prev.size() + 1; j++) {
                if (j == 0 || j == prev.size()) {
                    temp.add(1);
                } else {
                    temp.add(prev.get(j) + prev.get(j - 1));
                }
            }
            list.add(temp);
        }
        return list;
    }


    public List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> ll = new ArrayList<>();
        ll.add(List.of(1));
        if (numRows == 1) return ll;
        ll.add(List.of(1, 1));
        for (int i = 2; i < numRows; i++) {
            List<Integer> l = new ArrayList<Integer>(i + 1);
            l.add(1);
            for (int j = 1; j < i; j++) {
                List<Integer> prev = ll.get(i - 1);
                l.add(prev.get(j - 1) + prev.get(j));
            }
            l.add(1);
            ll.add(l);
        }
        return ll;
    }
}
