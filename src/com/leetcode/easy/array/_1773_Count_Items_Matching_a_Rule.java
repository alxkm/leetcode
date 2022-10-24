package com.leetcode.easy.array;

import java.util.List;

public class _1773_Count_Items_Matching_a_Rule {
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int counter = 0;
        for (List<String> item : items) {
            if (ruleKey.equals("type") && item.get(0).equals(ruleValue)) {
                counter++;
            } else if (ruleKey.equals("color") && item.get(1).equals(ruleValue)) {
                counter++;
            } else if (ruleKey.equals("name") && item.get(2).equals(ruleValue)) {
                counter++;
            }
        }
        return counter;
    }
}
