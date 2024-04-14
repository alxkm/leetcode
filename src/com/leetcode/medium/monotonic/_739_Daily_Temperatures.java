package com.leetcode.medium.monotonic;


import com.leetcode.Pair;

import java.util.Arrays;
import java.util.Stack;

public class _739_Daily_Temperatures {
    //739. Daily Temperatures
    //https://leetcode.com/problems/daily-temperatures/

    public int[] dailyTemperatures(int[] temperatures) {
        int[] ar = new int[temperatures.length];
        Stack<Pair<Integer, Integer>> st = new Stack<>();
        st.push(new Pair<>(0, temperatures[0]));
        for (int i = 1; i < temperatures.length; i++) {
            int t = temperatures[i];
            if (!st.isEmpty() && t > st.peek().getValue()) {
                int j = 1;
                while (!st.isEmpty() && st.peek().getValue() < t) {
                    int index = st.pop().getKey();
                    ar[index] = i - index;
                    j++;
                }
            }
            st.push(new Pair<>(i, t));
        }
        return ar;
    }

    public static void main(String[] args) {
        int[] ar = {73, 74, 75, 71, 69, 72, 76, 73};
                 //[1,   1,  2,  2,  1,  1,  0,  0]
        var sol = new _739_Daily_Temperatures();
        System.out.println(Arrays.toString(sol.dailyTemperatures(ar)));
    }
}
