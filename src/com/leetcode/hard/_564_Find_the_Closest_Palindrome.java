package com.leetcode.hard;

import java.util.HashSet;
import java.util.Set;

public class _564_Find_the_Closest_Palindrome {
    //564. Find the Closest Palindrome
    //https://leetcode.com/problems/find-the-closest-palindrome/description/
    //FOREIGN_SOLUTION
    //TODO

    // Function to find the nearest palindromic number in string form
    public String nearestPalindromic(String n) {
        // Convert the input string to a long integer for comparison
        long number = Long.parseLong(n);

        // Variable to store the closest palindrome number
        long closestPalindrome = -1;

        // Get all potential palindrome candidates
        for (long candidate : getPalindromeCandidates(n)) {
            // If this is the first candidate or it's closer to the input number than the current closest
            // or equally close but smaller, then update the closest palindrome
            if (closestPalindrome == -1 ||
                    Math.abs(candidate - number) < Math.abs(closestPalindrome - number) ||
                    (Math.abs(candidate - number) == Math.abs(closestPalindrome - number) && candidate < closestPalindrome)) {

                closestPalindrome = candidate;
            }
        }
        // Convert the closest palindrome back to a string and return it
        return Long.toString(closestPalindrome);
    }

    // Helper function to generate palindrome candidates based on the input string
    private Set<Long> getPalindromeCandidates(String n) {
        int length = n.length(); // Length of the input number
        Set<Long> candidates = new HashSet<>(); // Set to store palindrome candidates

        // Add 9's (One less digit than n and all 9's) e.g. 999 for n=1000
        candidates.add((long)Math.pow(10, length - 1) - 1);
        // Add 1 followed by all zeros and then a 1 (One more digit than n) e.g. 10001 for n=999
        candidates.add((long)Math.pow(10, length) + 1);

        // Get the first half of n (if odd, include the middle digit)
        long firstHalf = Long.parseLong(n.substring(0, (length + 1) / 2));
        // Generate candidates by varying the first half from -1 to 1 and mirroring to get palindromes
        for (long i = firstHalf - 1; i <= firstHalf + 1; ++i) {
            StringBuilder candidateBuilder = new StringBuilder();
            candidateBuilder.append(i); // Append the first half
            // Mirror and append the reverse of the first half (excluding the middle digit if odd length)
            candidateBuilder.append(new StringBuilder(Long.toString(i)).reverse().substring(length % 2));
            // Add the generated number to candidates
            candidates.add(Long.parseLong(candidateBuilder.toString()));
        }

        // Remove the number itself if it's a palindrome, as we want the nearest different palindrome
        candidates.remove(Long.parseLong(n));

        return candidates; // Return the set of candidates
    }
}
