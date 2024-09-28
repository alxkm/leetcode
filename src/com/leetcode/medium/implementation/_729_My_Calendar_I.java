package com.leetcode.medium.implementation;

public class _729_My_Calendar_I {
    //https://leetcode.com/problems/my-calendar-i/description/?envType=daily-question&envId=2024-09-26
    //729. My Calendar I

    class MyCalendar {
        int[][] ar = new int[1001][2];
        int size = 0;

        public MyCalendar() {

        }

        public boolean book(int start, int end) {
            if (size == 0) {
                ar[0] = new int[] {start, end};
                size++;
                return true;
            }

            for (int i = 0; i < size; i++) {
                int[] a = ar[i];
                int x = a[0];
                int y = a[1];
                if ((x <= start && end <= y) ||
                        (x < start && start < y) ||
                        (x < end && end < y) ||
                        (start <= x && y <= end)) {
                    return false;
                }
            }

            ar[size] = new int[] {start, end};
            size++;
            return true;
        }
    }

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
}
