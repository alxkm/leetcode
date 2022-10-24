package com.company.math;

public class _2278_Percentage_of_Letter_in_String {
    public int percentageLetter(String s, char letter) {
        double cnt = 0;
        for (var ch : s.toCharArray()) {
            if (ch == letter) cnt++;
        }
        return (int)((cnt / s.length()) * 100);
    }
}
