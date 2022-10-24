package com.leetcode.easy.string.additional;

import java.util.Random;

public class _1576_Replace_All__s_to_Avoid_Consecutive_Repeating_Characters {
    static public String modifyString(String s) {
        Random r = new Random();
        if (s.equals("?")) return String.valueOf((char)(97 + r.nextInt(26)));
        if (s.length() == 1) return s;
        if (s.equals("??")) return "ab";
        if (s.length() == 2 && s.charAt(0) == '?') {
            var prev = s.charAt(1);
            var a = 97;
            while (prev == (char)a) {
                a = 97 + r.nextInt(26);
            }
            StringBuilder sb = new StringBuilder();
            return sb.append((char)a).append(prev).toString();
        }
        if (s.length() == 2 && s.charAt(1) == '?') {
            var prev = s.charAt(0);
            var a = 97;
            while (prev == (char)a) {
                a = 97 + r.nextInt(26);
            }
            StringBuilder sb = new StringBuilder();
            return sb.append(prev).append((char)a).toString();
        }

        StringBuilder sb = new StringBuilder();

        var prev = s.charAt(0);
        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i) == '?') {
                var next = s.charAt(i + 1);
                int a = 97;
                while (prev == (char)a || next == (char)a) {
                    a = 97 + r.nextInt(26);
                }
                prev = (char) a;
                sb.append((char)a);
            } else {
                prev = s.charAt(i);
                sb.append(s.charAt(i));
            }
        }
        if (s.charAt(0) == '?') {
            var next = sb.charAt(0);
            int a = 97;
            while (next == (char) a) {
                a = 97 + r.nextInt(26);
            }
            String s1 = sb.toString();
            sb = new StringBuilder();
            sb.append((char) a).append(s1);
        } else {
            String s1 = sb.toString();
            sb = new StringBuilder();
            sb.append(s.charAt(0)).append(s1);
        }
        if (s.charAt(s.length() - 1) == '?') {
            var prev1 = sb.charAt(sb.length() - 1);
            int a = 97;
            while (prev1 == (char) a) {
                a = 97 + r.nextInt(26);
            }
            sb.append((char) a);
        } else {
            sb.append(s.charAt(s.length() - 1));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        var s = "?zs";
        var s1 = "ubv?w";
        var s2 = "a?b";
        var s3 = "j?qg??b";
        var s4 = "a?";
        System.out.println(modifyString(s4));

    }
}
