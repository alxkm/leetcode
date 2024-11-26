package com.leetcode.medium.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _1233_Remove_Sub_Folders_from_the_Filesystem {
    //1233. Remove Sub-Folders from the Filesystem
    //https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/description/
    //Trie

    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder, (x, y) -> x.length() - y.length());
        List<String> list = new ArrayList<>();
        for (String s: folder) {
            if (add(s.toCharArray())) {
                list.add(s);
            }
        }
        return list;
    }

    Trie tr = new Trie();

    class Trie {
        Trie[] ar = new Trie[27];
        boolean end;
    }

    public boolean add(char[] s) {
        Trie t = tr;
        for (int j = 0; j < s.length; j++) {
            char ch = s[j];
            int i = (ch != '/') ? ch - 'a' : 26;
            if (t.ar[i] != null && t.ar[i].end && (j + 1 != s.length && s[j + 1] == '/')) {
                return false;
            } else if (t.ar[i] != null) {
                t = t.ar[i];
            } else {
                t.ar[i] = new Trie();
                t = t.ar[i];
            }
        }
        t.end = true;
        return true;
    }
}
