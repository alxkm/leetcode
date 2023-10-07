package com.leetcode.top.stack;

import java.util.Stack;

public class _735_Asteroid_Collision {
    //https://leetcode.com/problems/asteroid-collision/
    //FOREIGN_SOLUTION
    //TOP

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for (int cur: asteroids) {
            boolean add = true;

            while (!st.isEmpty() && (st.peek() > 0 && cur < 0)) {
                if (Math.abs(st.peek()) < Math.abs(cur)) {
                    st.pop();
                    continue;
                } else if (Math.abs(st.peek()) == Math.abs(cur)) {
                    st.pop();
                }
                add = false;
                break;
            }
            if (add) {
                st.push(cur);
            }
        }

        int[] remainAsteroids = new int[st.size()];
        for (int i = st.size() - 1; i >= 0; i--) {
            remainAsteroids[i] = st.pop();
        }
        return remainAsteroids;
    }
}
