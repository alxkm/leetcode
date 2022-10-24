package com.company.string;

public class _2315_Count_Asterisks {
    static public int countAsterisks(String s) {
        int counter = 0;
        int pair = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '|') pair++;
            if (pair == 2) pair = 0;
            if (pair == 1) continue;
            if (s.charAt(i) == '*') counter++;
        }

        return counter;
    }

    public static void main(String[] args) {
        System.out.println(countAsterisks("*||*|||||*|*|***||*||***|"));
    }
}
