package com.leetcode.easy.string.additional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _2273_Find_Resultant_Array_After_Removing_Anagrams {
    static public List<String> removeAnagrams1(String[] words) {
        List<String> list = new ArrayList<>();
        list.add(words[0]);
        for (int i = 1, j = 0; i < words.length; i++) {
            if (words[i].length() != list.get(j).length()) {
                list.add(words[i]);
                j++;
            } else {
                char[] a = words[i].toCharArray();
                char[] b = list.get(j).toCharArray();
                Arrays.sort(a);
                Arrays.sort(b);
                if (!String.valueOf(a).equals(String.valueOf(b))) {
                    list.add(words[i]);
                    j++;
                }
            }
        }
        return list;
    }

    static public List<String> removeAnagrams2(String[] words) {
        List<String> list = new ArrayList<>();
        list.add(words[0]);
        for (int i = 1, j = 0; i < words.length; i++) {
            int sum1 = 0;
            for (char ch : words[i].toCharArray()) {
                sum1 += ch;
            }
            int sum2 = 0;
            for (char ch : list.get(j).toCharArray()) {
                sum2 += ch;
            }
            if (sum1 != sum2) {
                list.add(words[i]);
                j++;
            } else {
                char[] a = words[i].toCharArray();
                char[] b = list.get(j).toCharArray();
                Arrays.sort(a);
                Arrays.sort(b);
                if (!String.valueOf(a).equals(String.valueOf(b))) {
                    list.add(words[i]);
                    j++;
                }
            }
        }
        return list;
    }

    static public List<String> removeAnagrams(String[] words) {
        List<String> list = new ArrayList<>();
        list.add(words[0]);
        for (int i = 1, j = 0; i < words.length; i++) {
            char[] a = words[i].toCharArray();
            char[] b = list.get(j).toCharArray();
            Arrays.sort(a);
            Arrays.sort(b);
            if (!String.valueOf(a).equals(String.valueOf(b))) {
                list.add(words[i]);
                j++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        //String[] a = {"abba","baba","bbaa","cd","cd"};
        //String[] a = {"z","z","z","gsw","wsg","gsw","krptu"};
        //String[] a = {"a","b","a"};
        String[] a = {"truqjvrb", "trbuvjqr", "ubqtrrjv", "tqbujrvr", "qrjubrtv", "bjvtrrqu", "rjutqrvb", "rrjqtbvu", "vbujtqrr", "rtrjvqbu", "bqrjuvrt", "tqjvburr", "vrtjbqru", "vqrrujtb", "vuqbtrrj", "vjrtqbru", "rutbqvrj", "bvrtjuqr", "rrtqbjvu", "rjrvbuqt", "tqvrburj", "rjtrvqub", "jutrbqrv", "jrvrtubq", "bjqrurvt", "jvrruqbt", "jvburrqt", "jvurqbtr", "vujbtrrq", "qrtubjvr", "vbrrtqju", "rvurqtbj", "rvbjqtru", "tjuqbrvr", "jtrrubqv", "qbrtvruj", "urjtbqvr", "rurqbjtv", "tbjrvuqr", "turbjqvr", "vqbjrrut", "tjvurqbr", "turjqrvb", "jvubrrqt", "bqjtrrvu", "tjvrruqb", "jbuvrqrt", "btqrvjur", "juqbrvrt", "qrjvbtru", "qbjtuvrr", "rjtubvqr", "rjrbuvqt", "qvbjtrru", "rvutjbqr", "urqtjrvb", "qurrjtvb", "vrjuqtrb", "tuqrjbrv", "ubjrqrtv", "qutrrbvj", "rqjrubvt", "vsuokmjq", "sujmoqkv", "juoksqvm", "vqkojmus", "qkmsvjou", "qmvjosku", "ujmkovqs", "qvjumkso", "kb", "kb", "vmuu", "muvu", "mvuu", "mvuu", "umuv", "muvu", "uuvm", "umuv", "vumu", "uumv", "ldpyqa", "aylqpd", "ypaqdl", "plydqa", "xhm", "yrsqlm", "mqsyrl", "yrqlsm", "wwqmyph", "qymhwwp", "wpwhqym", "wmqyphw", "wyqmpwh", "ypwhmwq", "wyqwphm", "afypmtiwhj"};

        System.out.println(_2273_Find_Resultant_Array_After_Removing_Anagrams.removeAnagrams(a));
    }
}
