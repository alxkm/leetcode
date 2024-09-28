package com.leetcode.medium.implementation;

import java.util.ArrayList;
import java.util.List;

public class _731_My_Calendar_II {
    //https://leetcode.com/problems/my-calendar-ii/description/?envType=daily-question&envId=2024-09-27
    //731. My Calendar II

    class MyCalendarTwo {
        List<int[]> singleMatch = new ArrayList<>();
        List<int[]> doubleMatch = new ArrayList<>();

        public MyCalendarTwo() {}

        public boolean book(int start, int end) {
            for (int[] interval : doubleMatch) {
                if (start < interval[1] && end > interval[0]) {
                    return false;
                }
            }

            for (int[] interval : singleMatch) {
                if (start < interval[1] && end > interval[0]) {
                    doubleMatch.add(new int[] {Math.max(start, interval[0]), Math.min(end, interval[1])});
                }
            }

            singleMatch.add(new int[] {start, end});
            return true;
        }
    }

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */
}
