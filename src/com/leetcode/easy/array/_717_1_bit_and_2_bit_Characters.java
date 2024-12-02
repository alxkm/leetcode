package com.leetcode.easy.array;

public class _717_1_bit_and_2_bit_Characters {
    //https://leetcode.com/problems/1-bit-and-2-bit-characters/description/
    //717. 1-bit and 2-bit Characters

    public boolean isOneBitCharacter(int[] bits) {
        for (int i = 0; i < bits.length; ) {
            if (bits[i] == 1) i += 2;
            else if (bits[i] == 0) {
                if (bits.length == i + 1) return true;
                i++;
            }
        }
        return false;
    }
}
