package com.leetcode.easy.design;

import java.util.Deque;
import java.util.LinkedList;

public class _933_Number_of_Recent_Calls {
    //https://leetcode.com/problems/number-of-recent-calls/description/
    //933. Number of Recent Calls

    class RecentCounter {
        private Deque<Integer> deq = new LinkedList<>();
        public RecentCounter() {
        }

        public int ping(int t) {
            deq.addLast(t);
            while (!deq.isEmpty() && deq.peekFirst() < t - 3000) {
                deq.pollFirst();
            }
            return deq.size();
        }
    }
}
