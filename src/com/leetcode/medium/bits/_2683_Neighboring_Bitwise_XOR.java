package com.leetcode.medium.bits;

public class _2683_Neighboring_Bitwise_XOR {
    //2683. Neighboring Bitwise XOR
    //https://leetcode.com/problems/neighboring-bitwise-xor/description/?envType=daily-question&envId=2025-01-17

    public boolean doesValidArrayExist(int[] derived) {
        // Create an original array initialized with 0.
        int[] original = new int[derived.length + 1];
        original[0] = 0;
        for (int i = 0; i < derived.length; i++) {
            original[i + 1] = derived[i] ^ original[i];
        }
        // Store the validation results in checkForZero and checkForOne respectively.
        boolean checkForZero = (original[0] == original[original.length - 1]);

        original[0] = 1;
        for (int i = 0; i < derived.length; i++) {
            original[i + 1] = derived[i] ^ original[i];
        }
        boolean checkForOne = (original[0] == original[original.length - 1]);

        return checkForZero || checkForOne;
    }
}
