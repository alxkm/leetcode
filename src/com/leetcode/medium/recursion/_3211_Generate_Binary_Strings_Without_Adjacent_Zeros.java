package com.leetcode.medium.recursion;

import java.util.ArrayList;
import java.util.List;

public class _3211_Generate_Binary_Strings_Without_Adjacent_Zeros {
    //https://leetcode.com/problems/generate-binary-strings-without-adjacent-zeros/description/
    //3211. Generate Binary Strings Without Adjacent Zeros

    public List<String> validStrings(int n) {
        List<String> list = new ArrayList<>();
        f(n, false, "", list);
        return list;
    }

    private void f(int n, boolean zero, String prev, List<String> l) {
        if (n == 0) {
            l.add(prev);
            return;
        }
        if (!zero) f(n - 1, true, prev + "0", l);
        f(n - 1, false, prev + "1", l);
    }
}
