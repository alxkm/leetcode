package com.company;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class _1796_Second_Largest_Digit_in_a_String {
    static public int secondHighest(String s) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            if ((int) s.charAt(i) >= 48 && (int) s.charAt(i) <= 57) {
                set.add((int) s.charAt(i) - 48);
            }
        }
        if (set.size() <= 1) return -1;
        int m1 = -1;
        for (Integer i : set) {
            m1 = Math.max(m1, i);
        }
        set.remove(m1);
        int m2 = -1;
        for (Integer i : set) {
            m2 = Math.max(m2, i);
        }

        return m2;
    }


    static public int secondHighest1(String s) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int n = Character.getNumericValue(s.charAt(i));
                set.add(n);
            }
        }
        if (set.size() <= 1)
            return -1;
        set.pollLast();
        return set.pollLast();
    }

    static public int secondHighest2(String s) {
        int max = -1, secondMax = -1;
        for (int i = 0; i < s.length(); i++) {
            if ((int) s.charAt(i) >= 48 && (int) s.charAt(i) <= 57) {
                int a = s.charAt(i) - 48;
                if (a > max) {
                    secondMax = max;
                    max = a;
                } else if (a > secondMax && max != a) {
                    secondMax = a;
                }
            }
        }
        return secondMax;
    }

    public static void main(String[] args) {
        System.out.println(secondHighest2("unqclirrea85188733589"));
    }
}
