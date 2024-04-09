package com.leetcode.medium.design;

import java.util.LinkedList;
import java.util.List;

public class _622_Design_Circular_Queue {
    //622. Design Circular Queue
    //https://leetcode.com/problems/design-circular-queue/

    class MyCircularQueue {
        List<Integer> q = new LinkedList<>();
        final int k;

        public MyCircularQueue(int k) {
            this.k = k;
        }

        public boolean enQueue(int value) {
            if (isFull()) return false;
            q.add(value);
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) return false;
            q.remove(0);
            return true;
        }

        public int Front() {
            if (isEmpty()) return -1;
            return q.get(0);
        }

        public int Rear() {
            if (q.size() == 0) return -1;
            return q.get(q.size() - 1);
        }

        public boolean isEmpty() {
            return q.isEmpty();
        }

        public boolean isFull() {
            return q.size() == k;
        }
    }

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
}
