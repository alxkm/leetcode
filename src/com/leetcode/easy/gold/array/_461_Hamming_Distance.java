package com.company.gold.array;

import java.util.ArrayList;
import java.util.List;

public class _461_Hamming_Distance {
    static public int hammingDistance(int x, int y) {
        var l1 = translate(x);
        var l2 = translate(y);

        return 1;

    }

    static private List<Integer> translate(int n) {
        List<Integer> list = new ArrayList<>();

        while (n != 0) {
            list.add(n % 2);
            n /= 2;
        }

        return list;
    }

    public static void main(String[] args) {
        System.out.println(hammingDistance(1, 4));
    }
}
