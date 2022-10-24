package com.leetcode.easy.string.additional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class _500_Keyboard_Row {
    private Set<Character> l1 = Set.of('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p');
    private Set<Character> l2 = Set.of('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l');
    private Set<Character> l3 = Set.of('z', 'x', 'c', 'v', 'b', 'n', 'm');

    public String[] findWords(String[] words) {
        List<String> list = new ArrayList<>();
        for (String s : words) {
            int line = getLine(s.charAt(0));
            boolean is = true;
            for (char ch : s.toCharArray()) {
                if (getLine(ch) != line) {
                    is = false;
                    break;
                }
            }
            if (is) {
                list.add(s);
            };
        }
        String[] arr = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    private int getLine(char ch) {
        char chr = Character.toLowerCase(ch);
        if (l1.contains(chr)) return 1;
        else if (l2.contains(chr)) return 2;
        return 3;
    }
}
