package com.leetcode.easy.sort;

import java.util.Arrays;

public class _2037_Minimum_Number_of_Moves_to_Seat_Everyone {
    //2037. Minimum Number of Moves to Seat Everyone
    //https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone/description/

    static public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);

        int sum = 0;

        for (int i = 0; i < seats.length; i++) {
            sum += Math.abs(seats[i] - students[i]);
        }

        return sum;
    }

    public int minMovesToSeat1(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int counter = 0;
        int n = seats.length;
        for (int i = 0; i < n; i++) {
            counter += Math.abs(seats[i] - students[i]);
        }
        return counter;
    }

    public static void main(String[] args) {
        int[] seats = {2,2,6,6};
        int[] students = {1,3,2,6};
        System.out.println(minMovesToSeat(seats, students));
    }
}
