package com.company.array;

import java.util.Arrays;

public class _1720_Decode_XORed_Array {
    static public int[] decode(int[] encoded, int first) {
        int[] n = new int[encoded.length + 1];
        n[0] = first;
        for (int i = 0, j = 1; i < encoded.length; i++, j++) {
            n[j] = n[j - 1] ^ encoded[i];
        }
        return n;
    }

    public static void main(String[] args) {
        int[] a = {6,2,7,3};
        System.out.println(Arrays.toString(decode(a, 4)));
    }
}
