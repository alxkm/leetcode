package com.leetcode.easy.array;

import java.util.ArrayList;
import java.util.List;

public class _118_Pascal_s_Triangle {
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
}
