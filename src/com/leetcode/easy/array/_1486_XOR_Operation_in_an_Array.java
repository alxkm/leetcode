package com.company.array;

public class _1486_XOR_Operation_in_an_Array {
    public int xorOperation(int n, int start) {
        int r = start;
        for (int i = 1; i < n; i++) {
            int num = start + 2 * i;
            r ^= num;
        }
        return r;
    }
}
