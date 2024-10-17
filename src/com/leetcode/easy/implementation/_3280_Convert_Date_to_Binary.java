package com.leetcode.easy.implementation;

public class _3280_Convert_Date_to_Binary {
    //3280. Convert Date to Binary
    //https://leetcode.com/problems/convert-date-to-binary/description/

    public String convertDateToBinary(String date) {
        String[] ar = date.split("-");
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < ar.length; i++) {
            String s = ar[i];
            Integer n = Integer.valueOf(s);
            StringBuilder temp = new StringBuilder();
            while (n > 0) {
                temp.append(n % 2);
                n /= 2;
            }
            temp.reverse();
            sb.append(temp);
            if (i != ar.length - 1) sb.append("-");
        }
        return sb.toString();
    }
}
