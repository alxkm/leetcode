package com.leetcode.medium.stack;

import java.util.Stack;

public class _1717_Maximum_Score_From_Removing_Substrings {
    //1717. Maximum Score From Removing Substrings
    //https://leetcode.com/problems/maximum-score-from-removing-substrings/description/
    //foreign solution

    public int maximumGain(String s, int x, int y) {
        int totalScore = 0;
        String highPriorityPair = x > y ? "ab" : "ba";
        String lowPriorityPair = highPriorityPair.equals("ab") ? "ba" : "ab";

        // First pass: remove high priority pair
        String stringAfterFirstPass = removeSubstring(s, highPriorityPair);
        int removedPairsCount =
                (s.length() - stringAfterFirstPass.length()) / 2;

        // Calculate score from first pass
        totalScore += removedPairsCount * Math.max(x, y);

        // Second pass: remove low priority pair
        String stringAfterSecondPass = removeSubstring(
                stringAfterFirstPass,
                lowPriorityPair
        );
        removedPairsCount = (stringAfterFirstPass.length() -
                stringAfterSecondPass.length()) /
                2;

        // Calculate score from second pass
        totalScore += removedPairsCount * Math.min(x, y);

        return totalScore;
    }

    private String removeSubstring(String input, String targetPair) {
        Stack<Character> charStack = new Stack<>();

        // Iterate through each character in the input string
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            // Check if current character forms the target pair with the top of the stack
            if (
                    currentChar == targetPair.charAt(1) &&
                            !charStack.isEmpty() &&
                            charStack.peek() == targetPair.charAt(0)
            ) {
                charStack.pop(); // Remove the matching character from the stack
            } else {
                charStack.push(currentChar);
            }
        }

        // Reconstruct the remaining string after removing target pairs
        StringBuilder remainingChars = new StringBuilder();
        while (!charStack.isEmpty()) {
            remainingChars.append(charStack.pop());
        }
        return remainingChars.reverse().toString();
    }
}

class Solution {
//    public int maximumGain(String s, int x, int y) {
//        Stack<Character> st = new Stack<>();
//        for (char ch: s.toCharArray()) {
//            st.push(ch);
//        }
//        int score = 0;
//        while (!st.isEmpty()) {
//            char c1 = st.pop();
//            if (!ab(c1)) continue;
//            if (st.isEmpty()) continue;
//            char c2 = st.pop();
//            if (!ab(c1)) continue;
//
//            if (ab(c1, c2) && x > y) {
//                score += x;
//            } else if (ba(c1, c2) && x < y) {
//                score += y;
//            } else {
//                if (st.isEmpty() || !ab(st.peek()))) {
//                    if (ab(c1, c2)) score += x;
//                    else if (ba(c1, c2)) score += y;
//                    continue;
//                }
//                char c3 = st.pop();
//                if (x > y) {
//                    if (ab(c3, c2)) {
//
//                    } else if (ab(c3, c1)) {
//
//                    } else {
//
//                    }
//                    st.push(c1);
//                    score += x;
//                } else if (x < y && ab)
//            }
//        }
//        return score;
//    }
//
//    public int best(char c1, char c2) {
//        if (ab(c1, c2)) score += x;
//        else if (ba(c1, c2)) score += y;
//    }
//
//    public boolean ab(char ch) {
//        return ch == 'a' || ch == 'b';
//    }
//
//    public boolean ab(char c1, char c2) {
//        return c1 == 'a' && c2 == 'b';
//    }
//
//    public boolean ba(char c1, char c2) {
//        return c1 == 'b' && c2 == 'a';
//    }
}