package com.leetcode.top.list;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class _721_Accounts_Merge {
    //https://leetcode.com/problems/accounts-merge/
    //721. Accounts Merge
    //FOREIGN_SOLUTION

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<List<String>>> map = new HashMap<>();

        for (List<String> l: accounts) {
            if (map.get(l.get(0)) == null) {
                map.put(l.get(0), new ArrayList<>());
            }
        }

        List<List<String>> ll = new ArrayList<>();

        for (Map.Entry<String, List<List<String>>> entry: map.entrySet()) {

            while (true) {
                List<List<String>> value = entry.getValue();
                if (value.size() == 0) break;

                List<Integer> merge = new ArrayList<>();
                Set<String> tmp = new TreeSet<>(Comparator.comparing(String::toString));

                for (int i = 0; i < value.size(); i++) {
                    for (int j = i + 1; j < value.size(); j++) {

                    }
                }

                for (var index: merge) {
                    List<String> list = entry.getValue().get(index);
                    tmp.addAll(list);
                }
                tmp.remove(entry.getKey());
                List<String> list = new ArrayList<>();
                list.add(entry.getKey());
                list.addAll(tmp);
                ll.add(list);
            }
        }
        return ll;
    }
}
