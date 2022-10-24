package com.company.gold.array;

import java.util.HashMap;
import java.util.Map;

public class _1446_Consecutive_Characters {

    static public int maxPower(String s) {
        int[] power = new int[s.length()];
        power[0] = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) power[i] = power[i - 1] + 1;
            else power[i] = 1;
        }
        int max = 1;

        for (int i = 0; i < power.length; i++) {
            max = Math.max(power[i], max);
        }

        return max;
    }


    static public int maxPower1(String s) {
        int max = 1;
        for (int i = 2; i < s.length(); i++) {
            for (int j = 0; j <= s.length() - i; j ++) {
                String s1 = s.substring(j, j + i);
                if (isUnique(s1)) {
                    max = i;
                    break;
                }
            }
        }
        return max;
    }

    static private boolean isUnique(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            for (var a : map.entrySet()) {
                if (a.getValue() == 1) return true;
            }
        }
        return false;
    }

    static boolean isUnique1(String s) {
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(maxPower("abbcccddddeeeeedcba"));
    }
}
