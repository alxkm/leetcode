package com.leetcode.easy.hard;

import java.util.LinkedList;
import java.util.Queue;

public class _1700_Number_of_Students_Unable_to_Eat_Lunch {
    //1700. Number of Students Unable to Eat Lunch
    //https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/description/

    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Boolean> st = new LinkedList<>();
        Queue<Boolean> sa = new LinkedList<>();

        for (int s: students) st.add(s == 1 ? true : false);
        for (int s: sandwiches) sa.add(s == 1 ? true : false);

        int n = st.size();

        while (n > 0 && !st.isEmpty()) {
            int size = st.size();
            int q = st.size();
            while (q > 0) {
                if ((st.peek() && sa.peek()) || (!st.peek() && !sa.peek())) {
                    st.poll();
                    sa.poll();
                } else {
                    boolean s = st.poll();
                    st.offer(s);
                }
                q--;
            }
            if (size != st.size()) {
                n = st.size();
            } else {
                n--;
            }
        }

        return st.size();
    }
}
