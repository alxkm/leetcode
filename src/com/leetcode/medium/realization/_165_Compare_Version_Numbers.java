package com.leetcode.medium.realization;

import java.util.ArrayList;
import java.util.List;

public class _165_Compare_Version_Numbers {
    //https://leetcode.com/problems/compare-version-numbers/
    //165. Compare Version Numbers

    public int compareVersion(String version1, String version2) {
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");

        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();

        for (String s: s1) l1.add(Integer.parseInt(s));
        for (String s: s2) l2.add(Integer.parseInt(s));

        int m = s1.length;
        int n = s2.length;



        for (int i = 0, j = 0; i < l1.size() || j < l2.size(); ) {
            if (i < m && j < n) {
                if (l1.get(i) > l2.get(j)) {
                    return 1;
                } else if (l1.get(i) < l2.get(j)) {
                    return -1;
                }
                i++;
                j++;
            } else if (j >= n && i < m) {
                while (i < m) {
                    if (l1.get(i) > 0) {
                        return 1;
                    }
                    i++;
                }
                return 0;
            } else if (i >= m && j < n) {
                while (j < n) {
                    if (l2.get(j) > 0) {
                        return -1;
                    }
                    j++;
                }
                return 0;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        var sol = new _165_Compare_Version_Numbers();
        //System.out.println(sol.compareVersion("0.1", "1.1"));
        //System.out.println(sol.compareVersion("1.0", "1.0.0"));
        System.out.println(sol.compareVersion("1.0.1", "1"));
    }
}
