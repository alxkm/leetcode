package com.leetcode.easy.array;

import java.util.ArrayList;
import java.util.List;

public class _682_Baseball_Game {
    public int calPoints(String[] operations) {
        List<Integer> l = new ArrayList<>();
        for (String str : operations) {
            if (str.equals("+")) {
                l.add(l.get(l.size() - 1) + l.get(l.size() - 2));
            } else if (str.equals("D")) {
                l.add(l.get(l.size() - 1) * 2);
            } else if (str.equals("C")) {
                l.remove(l.get(l.size() - 1));
            } else {
                l.add(Integer.parseInt(str));
            }
        }
        return l.stream().mapToInt(Integer::intValue).sum();
    }
}
