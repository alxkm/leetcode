package com.leetcode.medium.string;

public class _3223_Minimum_Length_of_String_After_Operations {
    //3223. Minimum Length of String After Operations
    //https://leetcode.com/problems/minimum-length-of-string-after-operations/description//

    public int minimumLength(String s) {
        Map<Character, List<Integer>> map = new HashMap<>();
        int counter = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.get(c) == null) {
                map.put(c, new ArrayList<>());
                map.get(c).add(i);
                continue;
            }
            if (map.get(c).size() == 2) {
                List<Integer> l = map.get(c);
                map.get(c).remove(0);
                counter += 2;
                continue;
            }
            map.get(c).add(i);
        }
        return s.length() - counter;
    }
}
