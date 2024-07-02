package com.leetcode.medium.digit;

public class _8_String_to_Integer_atoi {
    //8. String to Integer (atoi)
    //https://leetcode.com/problems/string-to-integer-atoi/description/

    public int myAtoi(String s) {
        s = s.trim();
        boolean sign = s.startsWith("-") || s.startsWith("+");
        StringBuilder sb = new StringBuilder();

        int i = sign ? 1 : 0;

        while (i < s.length() && Character.isDigit(s.charAt(i)) && s.charAt(i) == '0') {
            i++;
        }

        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            sb.append(s.charAt(i));
            i++;
        }

        i = 0;
        if (sb.length() > 0) {
            char[] min = Integer.valueOf(Integer.MIN_VALUE).toString().toCharArray();
            char[] max = Integer.valueOf(Integer.MAX_VALUE).toString().toCharArray();
            if (sign && s.charAt(0) == '-') sb.insert(0, '-');
            char[] ch = sb.toString().toCharArray();
            if (s.charAt(0) == '-') {
                if (min.length < sb.length()) return Integer.MIN_VALUE;
                if (min.length == sb.length()) {
                    for (; i < min.length; i++) {
                        if (min[i] < ch[i]) return Integer.MIN_VALUE;
                        if (min[i] == ch[i]) continue;
                        break;
                    }
                }
            } else {
                if (max.length < sb.length()) return Integer.MAX_VALUE;
                if (max.length == sb.length()) {
                    for (; i < max.length; i++) {
                        if (max[i] < ch[i]) return Integer.MAX_VALUE;
                        if (max[i] == ch[i]) continue;
                        break;
                    }
                }
            }
            return Integer.parseInt(sb.toString());
        }
        return 0;
    }

    public static void main(String[] args) {
        var sol = new _8_String_to_Integer_atoi();

        System.out.println(sol.myAtoi("-91283472332"));
        System.out.println(sol.myAtoi("2147483648"));
        System.out.println(sol.myAtoi("1095502006p8"));
        System.out.println(sol.myAtoi("-2147483649"));
        System.out.println(sol.myAtoi("+1168848995 o5"));
    }
}
