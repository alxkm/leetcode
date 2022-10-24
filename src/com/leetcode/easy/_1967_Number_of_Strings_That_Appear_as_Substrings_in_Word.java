package com.company;

public class _1967_Number_of_Strings_That_Appear_as_Substrings_in_Word {
    public int numOfStrings(String[] patterns, String word) {
        int counter = 0;


        for (int j = 0; j < patterns.length; j++) {
            if (word.indexOf(patterns[j]) != -1) {
                counter++;

            }
        }

        return counter;
    }
}
