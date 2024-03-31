package com.leetcode.medium.design;

import java.util.PriorityQueue;
import java.util.Queue;

public class _1845_Seat_Reservation_Manager {
    //https://leetcode.com/problems/seat-reservation-manager/
    //1845. Seat Reservation Manager

    class SeatManager {
        private final Queue<Integer> q = new PriorityQueue<>((x, y) -> x - y);
        private int size;

        public SeatManager(int n) {
            size = n;
            for (int i = 1; i <= n; i++) q.offer(i);
        }

        public int reserve() {
            if (q.size() == 0) return -1;
            return q.poll();
        }

        public void unreserve(int seatNumber) {
            q.offer(seatNumber);
        }
    }

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */
}
