package com.company.greedly;

public class _1323_Maximum_69_Number {
    public int maximum69Number (int num) {
        String s = String.valueOf(num);
        boolean find = false;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '6' && !find) {
                sb.append('9');
                find = true;
            } else {
                sb.append(s.charAt(i));
            }
        }
        return Integer.parseInt(sb.toString());
    }
}
