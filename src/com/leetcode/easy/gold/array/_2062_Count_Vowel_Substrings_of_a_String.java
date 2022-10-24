package com.company.gold.array;

import java.util.Set;

public class _2062_Count_Vowel_Substrings_of_a_String {
    static public int countVowelSubstrings(String word) {
        Set<Character> v = Set.of('a', 'e', 'i', 'o', 'u');
        int counter = 0;
        for (int i = 5; i <= word.length(); i++) {
            for (int j = 0; (word.length() - j) >= i; j++) {
                String s = word.substring(j, j + i);
                int vowel = 0;
                for (Character ch : s.toCharArray()) {
                    if (v.contains(ch)) {
                        vowel++;
                    } else {
                        vowel = 0;
                        break;
                    }
                }
                if (vowel >= 5) {
                    for (Character ch : v) {
                        if (s.indexOf(ch) == -1) {
                            vowel = 0;
                            break;
                        }
                    }
                    if (vowel >= 5) counter++;
                }
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        System.out.println(countVowelSubstrings("cuaieuouac"));
        //uaieuo
        //uaieuou
        //uaieuoua
        //aieuo
        //aieuou
        //aieuoua
        //ieuoua

/*
uaieu
aieuo
ieuou
euoua
uaieuo
aieuou
ieuoua
uaieuou
aieuoua
uaieuoua*/
    }
}
