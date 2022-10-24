package com.company.string;

public class _2278_Percentage_of_Letter_in_String {
    static public int percentageLetter(String s, char letter) {
        int cnt = 0;
        for (var ch : s.toCharArray()) {
            if (ch == letter) cnt++;
        }
        return cnt / s.length();
    }

    public static void main(String[] args) {
        String s = "foobar"; char letter = 'o';
        System.out.println(percentageLetter(s, letter));
    }
}
