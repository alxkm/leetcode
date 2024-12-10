package com.leetcode;

class MyCalendar {
    //https://leetcode.com/problems/my-calendar-i/description/?envType=daily-question&envId=2024-09-26
    //729. My Calendar I

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
            if (x <= start && start < y && end > y) return false;
            if (start <= x && end > x && end <= y) return false;
            if (x < start && end > x && y >= end) return false;
            if (x <= start && end <= y) return false;
            if (x < start && start < y) return false;
            if (x < end && end < y) return false;
        }

        ar[size] = new int[] {start, end};
        size++;
        return true;
    }
}
public class _729_My_Calendar_I {
    //729. My Calendar I

    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        System.out.println(myCalendar.book(37,50));
        System.out.println(myCalendar.book(33,50));
        /*
        System.out.println(myCalendar.book(47,50));
        System.out.println(myCalendar.book(33,41));
        System.out.println(myCalendar.book(39,45));
        System.out.println(myCalendar.book(33,42));
         */
    }
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