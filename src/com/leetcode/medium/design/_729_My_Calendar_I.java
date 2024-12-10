package com.leetcode.medium.design;

public class _729_My_Calendar_I {
    //https://leetcode.com/problems/my-calendar-i/description/
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

//Approach #2: Sorted List + Binary Search
//class MyCalendar {
//    TreeMap<Integer, Integer> calendar;
//
//    MyCalendar() {
//        calendar = new TreeMap();
//    }
//
//    public boolean book(int start, int end) {
//        Integer prev = calendar.floorKey(start),
//                next = calendar.ceilingKey(start);
//        if ((prev == null || calendar.get(prev) <= start) &&
//                (next == null || end <= next)) {
//            calendar.put(start, end);
//            return true;
//        }
//        return false;
//    }
//}