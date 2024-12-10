package com.leetcode.medium.design;

import java.util.ArrayList;
import java.util.List;

public class _731_My_Calendar_II {
    //https://leetcode.com/problems/my-calendar-ii/description/
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

//Approach 1: Using Overlapped Intervals

/*
class MyCalendarTwo {

    private List<int[]> bookings;
    private List<int[]> overlapBookings;

    // Return true if the booking [start1, end1) & [start2, end2) overlaps.
    private boolean doesOverlap(int start1, int end1, int start2, int end2) {
        return Math.max(start1, start2) < Math.min(end1, end2);
    }

    // Return overlapping booking between [start1, end1) & [start2, end2).
    private int[] getOverlapped(int start1, int end1, int start2, int end2) {
        return new int[] { Math.max(start1, start2), Math.min(end1, end2) };
    }

    public MyCalendarTwo() {
        bookings = new ArrayList<>();
        overlapBookings = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        // Returns false if the new booking has an overlap
        // with the existing double-booked bookings.
        for (int[] booking : overlapBookings) {
            if (doesOverlap(booking[0], booking[1], start, end)) {
                return false;
            }
        }

        // Add the double overlapping bookings if any with the new booking.
        for (int[] booking : bookings) {
            if (doesOverlap(booking[0], booking[1], start, end)) {
                overlapBookings.add(
                    getOverlapped(booking[0], booking[1], start, end)
                );
            }
        }

        // Add the new booking to the list of bookings.
        bookings.add(new int[] { start, end });
        return true;
    }
}
* */

//Approach 2: Line Sweep
/*
class MyCalendarTwo {

    private TreeMap<Integer, Integer> bookingCount;
    private int maxOverlappedBooking;

    public MyCalendarTwo() {
        bookingCount = new TreeMap<>();
        maxOverlappedBooking = 2;
    }

    public boolean book(int start, int end) {
        // Increase the booking count at 'start' and decrease at 'end'.
        bookingCount.put(start, bookingCount.getOrDefault(start, 0) + 1);
        bookingCount.put(end, bookingCount.getOrDefault(end, 0) - 1);

        int overlappedBooking = 0;

        // Calculate the prefix sum of bookings.
        for (Map.Entry<Integer, Integer> entry : bookingCount.entrySet()) {
            overlappedBooking += entry.getValue();

            // If the number of overlaps exceeds the allowed limit, rollback and
            // return false.
            if (overlappedBooking > maxOverlappedBooking) {
                // Rollback changes.
                bookingCount.put(start, bookingCount.get(start) - 1);
                bookingCount.put(end, bookingCount.get(end) + 1);

                // Clean up if the count becomes zero to maintain the map clean.
                if (bookingCount.get(start) == 0) {
                    bookingCount.remove(start);
                }

                return false;
            }
        }

        return true;
    }
}
* */
