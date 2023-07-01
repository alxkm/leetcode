package com.leetcode.medium.string;

import java.util.ArrayList;
import java.util.List;

public class _6_Zigzag_Conversion {
    //https://leetcode.com/problems/zigzag-conversion/

    public String convert(String s, int numRows) {
        List<StringBuilder> l = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            l.add(new StringBuilder());
        }
        if (numRows == 1) return s;


        for (int i = 0, j = 0; i < s.length(); ) {
            l.get(j).append(s.charAt(i));
            j++;
            if (j == numRows) {
                i++;
                int k = numRows - 2;
                while (k >= 0 && i < s.length()) {
                    l.get(k).append(s.charAt(i));
                    k--;
                    i++;
                }
                j = 1;
            } else {
                i++;
            }
        }
        StringBuilder answer = new StringBuilder();
        for (var temp: l) {
            answer.append(temp.toString());
        }
        return answer.toString();
    }
}
