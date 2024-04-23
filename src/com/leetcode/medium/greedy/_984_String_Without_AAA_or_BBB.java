package com.leetcode.medium.greedy;

public class _984_String_Without_AAA_or_BBB {
    //984. String Without AAA or BBB
    //https://leetcode.com/problems/string-without-aaa-or-bbb/

    public String strWithout3a3b(int a, int b) {
        StringBuilder sb = new StringBuilder();
        char cha = 'a';
        char chb = 'b';
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
            cha = 'b';
            chb = 'a';
        }
        while (a > 0 || b > 0) {
            if (a > 0) {
                sb.append(cha);
                a--;
            }
            if (a > 0 && a >= b) {
                sb.append(cha);
                a--;
            }
            if (b > 0) {
                sb.append(chb);
                b--;
            }
            if (b > 0 && b >= a) {
                sb.append(chb);
                b--;
            }
        }
        return sb.toString();
    }
}
