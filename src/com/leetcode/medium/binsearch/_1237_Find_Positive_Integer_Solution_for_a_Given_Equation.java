package com.leetcode.medium.binsearch;

import java.util.ArrayList;
import java.util.List;

/*
 * // This is the custom function interface.
 * // You should not implement it, or speculate about its implementation
 * class CustomFunction {
 *     // Returns f(x, y) for any given positive integers x and y.
 *     // Note that f(x, y) is increasing with respect to both x and y.
 *     // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
 *     public int f(int x, int y);
 * };
 */
interface CustomFunction {
    int f(int x, int y);
}

public class _1237_Find_Positive_Integer_Solution_for_a_Given_Equation {
    //https://leetcode.com/problems/find-positive-integer-solution-for-a-given-equation/

    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> ll = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            int x = i;
            int l = 1;
            int r = 1000;
            while (l <= r) {
                int y = (l + r) / 2;
                int v = customfunction.f(x, y);
                if (v == z) {
                    ll.add(List.of(x, y));
                    //ll.add(List.of(r, l));
                    break;
                } else if (v > z) {
                    r = y - 1;
                } else {
                    l = y + 1;
                }
            }
        }
        return ll;
    }
}
