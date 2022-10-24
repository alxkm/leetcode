package com.company.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _884_Uncommon_Words_from_Two_Sentences {
    static public String[] uncommonFromSentences(String s1, String s2) {
        String[] sArr = s1.split(" ");
        String[] sArr2 = s2.split(" ");

        Set<String> set = new HashSet<>(Arrays.asList(sArr));
        List<String> l1 = new ArrayList<>(Arrays.asList(sArr));
        List<String> l2 = new ArrayList<>(Arrays.asList(sArr2));
        set.retainAll(Arrays.asList(sArr2));
        l1.removeAll(set);
        l2.removeAll(set);
        List<String> l = new ArrayList<>();
        l.addAll(l1);
        l.addAll(l2);

        return l.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String s1 = "this apple is sweet", s2 = "this apple is sour";
        System.out.println(Arrays.toString(uncommonFromSentences(s1, s2)));
    }
}
