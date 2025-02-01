package com.leetcode.medium.string;

import java.util.ArrayList;
import java.util.List;

public class _3324_Find_the_Sequence_of_Strings_Appeared_on_the_Screen {
    //https://leetcode.com/problems/find-the-sequence-of-strings-appeared-on-the-screen/description/
    //3324. Find the Sequence of Strings Appeared on the Screen

    public List<String> stringSequence(String target) {
        List<String> l = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < target.length(); i++) {
            char ch = 'a';
            s.append(ch);
            for (int j = 0; j < 26; j++) {
                s.setCharAt(s.length() - 1, ch);
                l.add(s.toString());
                if (ch == target.charAt(i)) break;
                ch++;
            }
        }
        return l;
    }
}
