package com.leetcode.easy.gold.string;

import java.util.Set;

public class _434_Number_of_Segments_in_a_String {
    static public int countSegments(String s) {
        boolean start = false;
        int i = 0;
        int cnt = 0;
        Set<Character> symbols = Set.of('\'', '-');

        while (i < s.length()) {
            while (i < s.length() && (Character.isAlphabetic(s.charAt(i)) || symbols.contains(s.charAt(i)))) {
                i++;
                start = true;
            }
            if (!start && s.charAt(i) == ',') {
                cnt++;
            }
            if (start) {
                while (i < s.length() && (s.charAt(i) != ' ')) i++;
                cnt++;
                start = false;
            }
            i++;
        }
        return cnt;
    }

    static public int countSegments1(String s) {
        int i = 0;
        int cnt = 0;
        while (i < s.length()) {
            if (s.charAt(i) == ' ') {
                i++;
                continue;
            }
            while (i < s.length() && (s.charAt(i) != ' ')) {
                i++;
            }
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        String s = "The one-hour drama series Westworld is a dark odyssey about the dawn " +
                "of artificial consciousness and the evolution of sin. " +
                "Set at the intersection of the near future and the reimagined past, " +
                "it explores a world in which every human appetite, no matter how noble or depraved, can be indulged.";

        String s1 = "a, bb, cc, cc#, ";
        String s2 = " 123";
        //5
        String s3 = ",,,,,ae%333**** 7 8 7 10";
        // 17;
        String s4 = "aefawf...eawfawf . feawfwe will begin the urgent task of rebuilding our nation and renewing the American dream";
        System.out.println(countSegments1(s4));
    }
}
