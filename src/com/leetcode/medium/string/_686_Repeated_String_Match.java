package com.leetcode.medium.string;

public class _686_Repeated_String_Match {
    //686. Repeated String Match
    //https://leetcode.com/problems/repeated-string-match/description/

    public int repeatedStringMatch(String a, String b) {
        if (a.contains(b)) return 1;
        int[] alp = new int[26];
        int[] alp1 = new int[26];

        for (char ch: a.toCharArray()) alp[ch - 'a']++;
        for (char ch: b.toCharArray()) alp1[ch - 'a']++;

        for (int i = 0; i < 26; i++) {
            if (alp[i] == 0 && alp1[i] != 0) return -1;
        }
        StringBuilder sb = new StringBuilder(a);
        sb.append(a);
        int counter = 1;
        while (true) {
            if (sb.indexOf(b) != -1) return counter;
            if (sb.length() > b.length()) {
                return -1;
            }
            sb.append(a);
            counter++;
        }
    }

    public static void main(String[] args) {
        var sol = new _686_Repeated_String_Match();
        System.out.println(sol.repeatedStringMatch("abc", "cabcabca"));
    }
}
