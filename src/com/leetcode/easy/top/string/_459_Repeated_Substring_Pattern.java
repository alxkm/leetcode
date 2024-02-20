package com.leetcode.easy.top.string;

import java.util.HashSet;
import java.util.Set;

public class _459_Repeated_Substring_Pattern {
    static public boolean repeatedSubstringPattern(String s) {
        Set<String> set = new HashSet<>();

        for (int i = 1; i <= s.length() / 2; i++) {
            set.add(s.substring(0, i));
        }

        for (String str : set) {
            int cnt = 0;
            int i = 0;
            while (true) {
                i = s.indexOf(str, i);
                if (i != -1) {
                    i++;
                    cnt++;
                    continue;
                }
                break;
            }
            if ((cnt * str.length()) == s.length() && str.repeat(cnt).equals(s)) {
                return true;
            }
        }
        return false;
    }

    public boolean repeatedSubstringPattern1(String s) {
        if (s.length() == 1) return false;
        Set<String> set = new HashSet<>();
        int m = s.length() / 2;
        for (int i = 1; i <= m; i++) {
            if (s.length() % i == 0) {
                set.add(s.substring(0, i));
            }
        }

        for (String str : set) {
            int cnt = 0;
            int i = 0;

            while (true) {
                i = s.indexOf(str, i);
                if (i != -1) {
                    i++;
                    cnt++;
                    continue;
                }
                break;
            }

            if ((cnt * str.length()) == s.length() && str.repeat(cnt).equals(s)) {
                return true;
            }
        }
        return false;
    }

    public boolean repeatedSubstringPattern2(String s) {
        if (s.length() == 1) return false;

        int m = s.length() / 2;
        for (int i = 1; i <= m; i++) {
            if (s.length() % i == 0) {
                int cnt = s.length() / i;
                String str = s.substring(0, i);
                if (str.repeat(cnt).equals(s)) return true;
            }
        }
        return false;
    }


    static public boolean repeatedSubstringPattern3(String s) {
        if (s.length() == 1) return false;

        int m = s.length() / 2;
        for (int i = 1; i <= m; i++) {
            if (s.length() % i == 0) {
                String str = s.substring(0, i);
                if (s.indexOf(str, m) != -1) {
                    boolean is = true;
                    for (int j = 0; j < s.length(); ) {
                        if (!is) break;
                        for (int l = 0; l < str.length(); l++) {
                            if (s.charAt(j) != str.charAt(l)) {
                                is = false;
                                break;
                            }
                            j++;
                        }
                    }
                    if (is) return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "ab";
        //String s = "aba";
        //String s = "abab";
        System.out.println(repeatedSubstringPattern3(s));
    }
}
