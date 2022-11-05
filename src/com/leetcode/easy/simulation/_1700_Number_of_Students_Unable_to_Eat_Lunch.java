package com.leetcode.easy.simulation;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class _1700_Number_of_Students_Unable_to_Eat_Lunch {
    public int countStudents(int[] students, int[] sandwiches) {
        Stack<Integer> s = new Stack<>();
        Queue<Integer> q = new LinkedList<>();

        for (int i : students) {
            q.add(i);
        }

        for (int i = sandwiches.length - 1; i >= 0; i--) {
            s.push(sandwiches[i]);
        }

        while (true) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Integer a = q.peek();
                if (a != null)
                    q.remove();
                if (!s.isEmpty()) {
                    Integer b = s.pop();
                    if (a != b) {
                        q.add(a);
                        s.push(b);
                    }
                }
            }
            if (size == q.size()) break;
        }
        return q.size();
    }
}
