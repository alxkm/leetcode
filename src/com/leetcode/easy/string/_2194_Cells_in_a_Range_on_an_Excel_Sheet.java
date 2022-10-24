package com.leetcode.easy.string;

import java.util.ArrayList;
import java.util.List;

public class _2194_Cells_in_a_Range_on_an_Excel_Sheet {
    public List<String> cellsInRange(String s) {
        char firstAlphabetic = s.charAt(0);
        int firstDigit = (int)s.charAt(1);

        char secondAlphabetic = s.charAt(3);
        int secondDigit = (int)s.charAt(4);

        List<String> list = new ArrayList<>();

        for (int i = (int)firstAlphabetic; i <= (int)secondAlphabetic; i++) {
            for (int j = firstDigit; j <= secondDigit; j++) {
                var sb = new StringBuilder().append((char)i).append((char)j).toString();
                list.add(sb);
            }
        }

        return list;
    }
}
