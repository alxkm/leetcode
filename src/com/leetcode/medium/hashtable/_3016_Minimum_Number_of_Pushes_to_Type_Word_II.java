package com.leetcode.medium.hashtable;

import java.util.Arrays;

public class _3016_Minimum_Number_of_Pushes_to_Type_Word_II {
    //3016. Minimum Number of Pushes to Type Word II
    //https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-ii/?envType=daily-question&envId=2024-08-06

    public int minimumPushes(String word) {
        int[] ch = new int[26];
        for (char c: word.toCharArray()) {
            ch[c - 'a']++;
        }
        int counter = 0;
        for (int i = 0; i < 26; i++) {
            if (ch[i] > 0) counter++;
        }
        if (counter <= 8) return word.length();

        Arrays.sort(ch);
        int _1 = 8;
        int _2 = 8;
        int _3 = 8;
        int _4 = 2;
        counter = 0;
        for (int i = 25; i >= 0; i--) {
            if (ch[i] == 0) break;

            if (_1 > 0) {
                counter += ch[i];
                _1--;
            } else if (_2 > 0) {
                counter += ch[i] * 2;
                _2--;
            } else if (_3 > 0) {
                counter += ch[i] * 3;
                _3--;
            } else if (_4 > 0) {
                counter += ch[i] * 4;
                _4--;
            }

        }
        return counter;
    }

    public int minimumPushes1(String word) {
        int[] ch = new int[26];
        for (char c: word.toCharArray()) {
            ch[c - 'a']++;
        }
        Arrays.sort(ch);
        int pressWeight = 1;
        int totalPressed = 0;
        int pressed = 0;
        for (int i = 25; i >= 0; i--) {
            if (ch[i] == 0) break;

            totalPressed += ch[i] * pressWeight;
            pressed++;

            if (pressed == 8) {
                pressed = 0;
                pressWeight++;
            }
        }
        return totalPressed;
    }

    public static void main(String[] args) {
        var sol = new _3016_Minimum_Number_of_Pushes_to_Type_Word_II();
        System.out.println(sol.minimumPushes("aabbccddeeffgghhiiiiii"));
    }
}
