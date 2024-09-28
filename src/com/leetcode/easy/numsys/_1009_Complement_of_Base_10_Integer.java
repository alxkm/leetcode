package com.leetcode.easy.numsys;

public class _1009_Complement_of_Base_10_Integer {
    //1009. Complement of Base 10 Integer
    //https://leetcode.com/problems/complement-of-base-10-integer/description/

    public int bitwiseComplement(int n) {
        if (n == 0) return 1;

        int complement = 0;
        int two = 1;

        while (n > 0) {
            int r = (n % 2 == 0) ? 1 : 0;
            complement += r * two;
            two *= 2;
            n /= 2;
        }

        return complement;
    }
}
