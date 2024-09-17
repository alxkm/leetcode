package com.leetcode.easy.bit;

import java.util.ArrayList;
import java.util.List;

public class _2220_Minimum_Bit_Flips_to_Convert_Number {
    //2220. Minimum Bit Flips to Convert Number
    //https://leetcode.com/problems/minimum-bit-flips-to-convert-number/description/

    //WA
    public int minBitFlips0(int start, int goal) {
        List<Boolean> l1 = new ArrayList<>();
        List<Boolean> l2 = new ArrayList<>();

        while (start > 0) {
            l1.add((start % 2 == 0) ? false : true);
            start /= 2;
        }
        while (goal > 0) {
            l2.add((goal % 2 == 0) ? false : true);
            goal /= 2;
        }
        int i = 0;
        int j = 0;
        int counter = 0;
        while (i < l1.size() && j < l2.size()) {
            if (l1.get(i++) != l2.get(j++)) counter++;
        }

        if (i < l1.size()) counter += l1.size() - i;
        if (j < l2.size()) counter += l2.size() - j;

        return counter;
    }

    public int minBitFlips(int start, int goal) {
        String binaryStart = Integer.toBinaryString(start);
        String binaryGoal = Integer.toBinaryString(goal);

        int maxLength = Math.max(binaryStart.length(), binaryGoal.length());
        binaryStart = String.format("%" + maxLength + "s", binaryStart).replace(' ', '0');
        binaryGoal = String.format("%" + maxLength + "s", binaryGoal).replace(' ', '0');

        int counter = 0;
        for (int i = 0; i < maxLength; i++) {
            if (binaryStart.charAt(i) != binaryGoal.charAt(i)) {
                counter++;
            }
        }

        return counter;
    }
}
