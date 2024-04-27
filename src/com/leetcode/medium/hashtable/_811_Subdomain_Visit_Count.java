package com.leetcode.medium.hashtable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _811_Subdomain_Visit_Count {
    //811. Subdomain Visit Count
    //https://leetcode.com/problems/subdomain-visit-count/description/

    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for (String str: cpdomains) {
            String[] strs = str.split(" ");
            Integer num = Integer.valueOf(strs[0]);
            String[] ar = strs[1].split("\\.");
            StringBuilder sb = new StringBuilder();

            for (int i = ar.length - 1; i >= 0; i--) {
                if (i != ar.length - 1) sb.insert(0, ".");
                sb.insert(0, ar[i]);
                map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + num);
            }
        }
        List<String> list = new ArrayList<>();
        for (var entry: map.entrySet()) {
            list.add(entry.getValue() + " " + entry.getKey());
        }
        return list;
    }
}
