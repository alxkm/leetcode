package com.company;

import java.util.ArrayList;
import java.util.List;

public class _1556_Thousand_Separator {

    static public String thousandSeparator(int n) {
        if (n > 1000) {
            String s = String.valueOf(n);
            StringBuilder number = new StringBuilder();
            StringBuilder accumulator = new StringBuilder();
            for (int i = s.length() - 1, j = 0; i >= 0; i--) {
                if (j == 3) {
                    j = 1;
                    number.append(accumulator).append(".");
                    accumulator = new StringBuilder();
                    accumulator.append(s.charAt(i));
                } else {
                    accumulator.append(s.charAt(i));
                    j++;
                }
            }
            number.append(accumulator);
            number.reverse();
            return number.toString();
        }
        return String.valueOf(n);
    }

    public static void main(String[] args) {
        System.out.println(thousandSeparator(3991));
    }
}
