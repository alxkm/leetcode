package com.leetcode.medium.segments;

import com.leetcode.ArrayUtil;

import java.util.ArrayList;
import java.util.List;

public class _1701_Average_Waiting_Time {
    //1701. Average Waiting Time
    //https://leetcode.com/problems/average-waiting-time/description/?envType=daily-question&envId=2024-07-09

    public double averageWaitingTime(int[][] customers) {
        List<Integer> waitingTime = new ArrayList<>();
        int start = customers[0][0];
        int end = start + customers[0][1];
        waitingTime.add(customers[0][1]);

        for (int i = 1; i < customers.length; i++) {
            int[] ar = customers[i];
            int newStart = ar[0];
            int t = ar[1];
            if (newStart < end) {
                int a = end - newStart + t;
                waitingTime.add(a);
                int temp = end;
                end += t;
                start = temp;
            } else {
                waitingTime.add(t);
                start = newStart;
                end = newStart + t;
            }
        }

        double sum = 0;
        for (int n: waitingTime) sum += n;
        return (double)(sum / (double)waitingTime.size());
    }

    public double averageWaitingTime1(int[][] customers) {
        int end = customers[0][0] + customers[0][1];
        double waitingTime = customers[0][1];

        for (int i = 1; i < customers.length; i++) {
            int[] ar = customers[i];
            int t = ar[1];
            int newStart = ar[0];
            if (newStart < end) {
                waitingTime += (end - newStart + t);
                end += t;
            } else {
                waitingTime += t;
                end = newStart + t;
            }
        }

        return waitingTime / (double)customers.length;
    }

    public static void main(String[] args) {
        var sol = new _1701_Average_Waiting_Time();
        sol.averageWaitingTime(ArrayUtil.to2d("[[5,2],[5,4],[10,3],[20,1]]"));
        sol.averageWaitingTime(ArrayUtil.to2d(1,2,2,5,4,3));
    }
}
