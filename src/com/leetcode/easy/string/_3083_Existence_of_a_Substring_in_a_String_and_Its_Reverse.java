package com.leetcode.easy.string;

import java.util.HashSet;
import java.util.Set;

public class _3083_Existence_of_a_Substring_in_a_String_and_Its_Reverse {
    //3083. Existence of a Substring in a String and Its Reverse
    //https://leetcode.com/problems/existence-of-a-substring-in-a-string-and-its-reverse/

    public boolean isSubstringPresent(String s) {
        if (s.length() == 1) return false;
        Set<String> set = new HashSet<>();

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                return true;
            } else {
                String str = String.valueOf(s.charAt(i - 1)) + s.charAt(i);
                set.add(str);
            }

            if (i >= 2 && s.charAt(i - 2) == s.charAt(i)) {
                return true;
            } else if (i >= 2) {
                String str = String.valueOf(s.charAt(i - 2)) + s.charAt(i - 1) + s.charAt(i);
                set.add(str);
            }
        }

        for (int i = s.length() - 1; i >= 1; i--) {
            String str = String.valueOf(s.charAt(i)) + s.charAt(i - 1);
            if (set.contains(str)) {
                return true;
            }

            if (i >= 2) {
                str = String.valueOf(s.charAt(i)) + s.charAt(i - 1) + s.charAt(i - 2);
                if (set.contains(str)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean isSubstringPresent1(String s) {
        if (s.length() == 1) return false;
        Set<String> set = new HashSet<>();

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                return true;
            }
            String str = String.valueOf(s.charAt(i - 1)) + s.charAt(i);
            set.add(str);
        }

        for (int i = s.length() - 1; i >= 1; i--) {
            if (set.contains(String.valueOf(s.charAt(i)) + s.charAt(i - 1))) {
                return true;
            }
        }

        return false;
    }

    public boolean isSubstringPresent2(String s) {
        if (s.length() == 1) return false;
        Set<String> set = new HashSet<>();

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) return true;

            if (s.contains(String.valueOf(s.charAt(i)) + s.charAt(i - 1))) return true;
        }
        return false;
    }

    public boolean isSubstringPresent3(String s) {
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) return true;

            if (s.contains(String.valueOf(s.charAt(i)) + s.charAt(i - 1))) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        var sol = new _3083_Existence_of_a_Substring_in_a_String_and_Its_Reverse();
        System.out.println(sol.isSubstringPresent("abcd"));
    }
}
