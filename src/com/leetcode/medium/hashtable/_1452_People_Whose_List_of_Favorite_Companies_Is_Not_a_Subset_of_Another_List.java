package com.leetcode.medium.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _1452_People_Whose_List_of_Favorite_Companies_Is_Not_a_Subset_of_Another_List {
    //1452. People Whose List of Favorite Companies Is Not a Subset of Another List
    //https://leetcode.com/problems/people-whose-list-of-favorite-companies-is-not-a-subset-of-another-list/

    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            for (int j = 0; j < favoriteCompanies.get(i).size(); j++) {
                map.computeIfAbsent(favoriteCompanies.get(i).get(j), k -> new ArrayList<>()).add(i);
            }
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            boolean needAdditionalCheck = true;
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < favoriteCompanies.get(i).size(); j++) {
                if (map.get(favoriteCompanies.get(i).get(j)).size() == 1) {
                    list.add(i);
                    needAdditionalCheck = false;
                    break;
                } else {
                    for (Integer integer : map.get(favoriteCompanies.get(i).get(j))) {
                        if (integer != i) set.add(integer);
                    }
                }
            }

            if (needAdditionalCheck) {
                boolean includesAll = false;
                for (Integer n : set) {
                    if (favoriteCompanies.get(n).containsAll(favoriteCompanies.get(i))) {
                        includesAll = true;
                        break;
                    }
                }
                if (!includesAll) list.add(i);
            }
        }
        return list;
    }
}
