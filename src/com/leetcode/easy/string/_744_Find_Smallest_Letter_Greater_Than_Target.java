package com.company.string;

public class _744_Find_Smallest_Letter_Greater_Than_Target {
    static public char nextGreatestLetter(char[] letters, char target) {
        for (int i = 0; i < letters.length; i++) {
            if ((int)letters[i] > (int)target) return letters[i];
        }
        return letters[0];
    }

    public static void main(String[] args) {
       char[] letters = {'c','f','j'}; char target = 'j';

        System.out.println(nextGreatestLetter(letters, target));
    }
}
