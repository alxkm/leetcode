package com.leetcode.medium.backtrack1;

import java.util.ArrayList;
import java.util.List;

public class _1415_The_k_th_Lexicographical_String_of_All_Happy_Strings_of_Length_n {
    //1415. The k-th Lexicographical String of All Happy Strings of Length n
    //https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/description/

    int n;
    int k;
    List<String> list = new ArrayList<>();
    List<Character> chars = List.of('a', 'b', 'c');

    public String getHappyString(int n, int k) {
        this.n = n;
        this.k = k;
        f(new StringBuilder());
        if (k > list.size()) {
            return "";
        }
        return list.get(k - 1);
    }

    void f(StringBuilder sb) {
        if (sb.length() >= n) {
            return;
        }

        for (char ch: chars) {
            if (sb.length() == 0 || (sb.length() != 0 && sb.charAt(sb.length() - 1) != ch)) {
                sb.append(ch);
                if (sb.length() == n) list.add(sb.toString());
                f(sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}
