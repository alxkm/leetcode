package com.leetcode.easy.string;

public class _1736_Latest_Time_by_Replacing_Hidden_Digits {
    //https://leetcode.com/problems/latest-time-by-replacing-hidden-digits/description/

    public String maximumTime(String time) {
        char h1 = time.charAt(0);
        char h2 = time.charAt(1);
        char m1 = time.charAt(3);
        char m2 = time.charAt(4);

        StringBuilder sb = new StringBuilder();
        if (h1 == '?' && h2 == '?') {
            sb.append("23");
        } else if (h1 == '?') {
            if (h2 < '4') {
                sb.append('2').append(h2);
            } else {
                sb.append('1').append(h2);
            }
        } else if (h2 == '?'){
            if (h1 == '2') {
                sb.append(h1).append('3');
            } else {
                sb.append(h1).append('9');
            }
        } else {
            sb.append(h1).append(h2);
        }
        sb.append(":");
        if (m1 == '?' && m2 == '?') {
            sb.append("59");
        } else if (m1 == '?') {
            sb.append('5').append(m2);
        } else if (m2 == '?') {
            sb.append(m1).append('9');
        } else {
            sb.append(m1).append(m2);
        }

        return sb.toString();
    }
}
