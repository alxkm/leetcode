package com.leetcode.easy.string;

import java.util.ArrayList;
import java.util.List;

public class _2788_Split_Strings_by_Separator {
    //2788. Split Strings by Separator
    //https://leetcode.com/problems/split-strings-by-separator/

    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        List<String> strs = new ArrayList<>();
        for (String w: words) {
            String[] ws = w.split("["+separator+"]");
            for (String s: ws) {
                if(s.length() > 0) strs.add(s);
            }
        }
        return strs;
    }
}
