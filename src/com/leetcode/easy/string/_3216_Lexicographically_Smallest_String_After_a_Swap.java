package com.leetcode.easy.string;

public class _3216_Lexicographically_Smallest_String_After_a_Swap {
    //3216. Lexicographically Smallest String After a Swap
    //https://leetcode.com/problems/lexicographically-smallest-string-after-a-swap/description/

    public String getSmallestString(String s) {
        char[] ch = s.toCharArray();

        for (int i = 0; i < s.length() - 1; i++) {
            if (ch[i] > ch[i + 1]) {
                int a1 = (int)(ch[i] - '0');
                int a2 = (int)(ch[i + 1] - '0');
                if (a1 % 2 == 0 && a2 % 2 != 0) continue;
                if (a2 % 2 == 0 && a1 % 2 != 0) continue;
                char c = ch[i];
                ch[i] = ch[i + 1];
                ch[i + 1] = c;

                if (s.compareTo(String.valueOf(ch)) >= 1) {
                    s = String.valueOf(ch);
                    break;
                } else {
                    ch = s.toCharArray();
                }
            }
        }

        return s;
    }
}
