package com.leetcode.easy.sort;

import java.util.Arrays;

public class _2037_Minimum_Number_of_Moves_to_Seat_Everyone {
    static public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);

        int sum = 0;

        for (int i = 0; i < seats.length; i++) {
            sum += Math.abs(seats[i] - students[i]);
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] seats = {2,2,6,6};
        int[] students = {1,3,2,6};
        System.out.println(minMovesToSeat(seats, students));
    }
}
