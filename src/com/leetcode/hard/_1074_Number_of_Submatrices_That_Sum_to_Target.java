package com.leetcode.hard;

public class _1074_Number_of_Submatrices_That_Sum_to_Target {
    //foreign
    //1074. Number of Submatrices That Sum to Target
    //https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/description/

    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int[][] pr = new int[rows][columns];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                int top = (r > 0) ? pr[r - 1][c] : 0;
                int left = (c > 0) ? pr[r][c - 1] : 0;
                int topLeft = (Math.min(c, r) > 0) ? pr[r - 1][c - 1] : 0;
                pr[r][c] = matrix[r][c] + top + left - topLeft;
            }
        }

        int cnt = 0;
        for (int r1 = 0; r1 < rows; r1++) {
            for (int r2 = r1; r2 < rows; r2++) {
                for (int c1 = 0; c1 < columns; c1++) {
                    for (int c2 = c1; c2 < columns; c2++) {
                        int top = (r1 > 0) ? pr[r1 - 1][c2] : 0;
                        int left = (c1 > 0) ? pr[r2][c1 - 1] : 0;
                        int topLeft = (Math.min(c1, r1) > 0) ? pr[r1 - 1][c1 - 1] : 0;
                        int curSum = pr[r2][c2] - top - left + topLeft;

                        if (curSum == target) cnt++;
                    }
                }
            }
        }

        return cnt;
    }
}


class Solution1 {
    public int numSubmatrixSumTarget(int[][] nums, int t) {
        int row=nums.length;
        int col=nums[0].length;
        int count=0;
        for(int i=0;i<row;i++)//1
        {
            int arr[]=new int[col];
            for(int j=i;j<row;j++)//2
            {
                for(int k=0;k<col;k++)//3
                {
                    arr[k]+=nums[j][k];
                }
                for(int l=0;l<col;l++)//4
                {
                    int sum=0;
                    for(int r=l;r<col;r++)//5
                    {
                        sum+=arr[r];
                        if(sum==t)
                        {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}