package com.leetcode.medium.implementation;

public class _641_Design_Circular_Deque {
    //https://leetcode.com/problems/design-circular-deque/description/?envType=daily-question&envId=2024-09-28
    //641. Design Circular Deque

    class MyCircularDeque {

        public static class Node {
            int val;
            Node next;

            public Node(int v) {
                val = v;
            }
        }

        Node front;
        Node back;
        int size;
        int maxSize;

        public MyCircularDeque(int k) {
            maxSize = k;
        }

        public boolean insertFront(int value) {
            if (size < maxSize) {
                var frontNext = new Node(value);
                if (front == null) {
                    back = frontNext;
                } else {
                    front.next = frontNext;
                }

                front = frontNext;
                size++;
                return true;
            }
            return false;
        }

        public boolean insertLast(int value) {
            if (size < maxSize) {
                var newBack = new Node(value);

                if (back == null) {
                    front = newBack;
                } else {
                    newBack.next = back;
                }

                back = newBack;
                size++;
                return true;
            }
            return false;
        }

        public boolean deleteFront() {
            if (size == 0) return false;
            if (size == 1) {
                front = null;
                back = null;
            } else {
                var h = back;
                while (h.next != front) {
                    h = h.next;
                }
                front = h;
                h.next = null;
            }
            size--;
            return true;
        }

        public boolean deleteLast() {
            if (size == 0) return false;
            if (size == 1) {
                front = null;
                back = null;
            } else {
                back = back.next;
            }
            size--;
            return true;
        }

        public int getFront() {
            if (size == 0) return -1;
            return front.val;
        }

        public int getRear() {
            if (size == 0) return -1;
            return back.val;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == maxSize;
        }
    }

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */
}
