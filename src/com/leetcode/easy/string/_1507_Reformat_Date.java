package com.leetcode.easy.string;

import java.util.List;

public class _1507_Reformat_Date {
    public String reformatDate(String date) {
        String[] s = date.split(" ");
        List<String> m = List.of("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");
        StringBuilder sb = new StringBuilder();
        int month = 0;

        for (int i = 0; i < m.size(); i++) {
            if (s[1].equals(m.get(i))) {
                month = i + 1;
                break;
            }
        }

        int day = Integer.parseInt(s[0].substring(0, s[0].length() - 2));

        sb.append(s[2])
          .append("-")
          .append((month < 10) ? "0" + month : month)
          .append("-")
          .append((day < 10) ? "0" + day : day);
        return sb.toString();
    }
}
