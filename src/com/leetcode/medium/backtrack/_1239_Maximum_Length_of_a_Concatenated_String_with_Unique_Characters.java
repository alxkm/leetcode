package com.leetcode.medium.backtrack;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _1239_Maximum_Length_of_a_Concatenated_String_with_Unique_Characters {
    //1239. Maximum Length of a Concatenated String with Unique Characters
    //https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/description/

    int max = 0;

    public int maxLength(List<String> arr) {
        f(-1, "", new HashSet<>(), arr);
        return max;
    }

    private void f(int i, String s, Set<Character> set, List<String> arr) {
        if (i >= arr.size()) return;

        max = Math.max(max, s.length());

        for (int j = i + 1; j < arr.size(); j++) {
            boolean uniq = true;
            char[] sx = arr.get(j).toCharArray();
            char[] map = new char[26];
            for (char ch : sx) {
                if (set.contains(ch) || map[ch - 'a'] != 0) {
                    uniq = false;
                    break;
                }
                map[ch - 'a']++;
            }
            if (uniq) {
                for (char ch : sx) set.add(ch);
                f(j, s + arr.get(j), set, arr);
                for (char ch : sx) set.remove(ch);
            }
        }
    }

    //foreign solution using bits to check that char is uniq
    class Solution1 {
        public int solve(String strs[], int no, int a[], int index, int c) {
            if (index == c)
                return 0;
            int x = no & a[index];
            if (x == 0)
                return Math.max(strs[index].length() + solve(strs, no ^ a[index], a, index + 1, c), solve(strs, no, a, index + 1, c));
            else
                return solve(strs, no, a, index + 1, c);
        }

        public int maxLength(List<String> arr) {
            int a[] = new int[arr.size()];
            int c = 0;
            String strs[] = new String[a.length];
            for (String s : arr) {
                int x = 0, fl = 0;
                for (char ch : s.toCharArray()) {
                    int z = x | (1 << (ch - 96));
                    if (x == z) {
                        fl = 1;
                        break;
                    }
                    x = z;
                }
                if (fl == 0) {
                    a[c] = x;
                    strs[c++] = s;
                }
            }
            return solve(strs, 0, a, 0, c);
        }
    }

    public static void main(String[] args) {
        var sol = new _1239_Maximum_Length_of_a_Concatenated_String_with_Unique_Characters();
        System.out.println(sol.maxLength(List.of("un", "iq", "ue")));
    }
}
