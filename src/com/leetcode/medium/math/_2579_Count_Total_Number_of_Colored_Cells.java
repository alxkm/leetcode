package com.leetcode.medium.math;

public class _2579_Count_Total_Number_of_Colored_Cells {
    //2579. Count Total Number of Colored Cells
    //https://leetcode.com/problems/count-total-number-of-colored-cells/description/?envType=daily-question&envId=2025-03-05

    public long coloredCells(int n) {
        if (n == 1) return 1;
        if (n == 2) return 5;
        long oneSide = 1;
        long counter = 5;

        for (int i = 2; i < n; i++) {
            counter += oneSide * 4;
            counter += 4;
            oneSide++;
        }

        return counter;
    }

//    public long coloredCells(int n) {
//        long sum=1;
//        for(int i=0;i<n;i++)
//        {
//            sum+=4*i;
//
//        }
//        return sum;
//    }

//    public long coloredCells(int n) {
//        return 1+(long)2*n*(n-1);
//    }
}
