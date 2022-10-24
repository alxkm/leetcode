package com.leetcode.easy.sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _1710_Maximum_Units_on_a_Truck {

    static public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(a, b) -> b[1] - a[1]);
        int i = 0, size = 0;
        while (truckSize != 0) {
            int box = boxTypes[i][0];
            if (box != 0) {
                truckSize -= 1;
                size += boxTypes[i][1];
                boxTypes[i][0]--;
            } else {
                i++;
                if (i >= boxTypes.length) break;
            }
        }
        return size;
    }

    public static void main(String[] args) {
        int[][] boxTypes = {{5,10}, {2,5},{4,7},{3,9}};
        int truckSize = 10;

        int [][] a = {{1,3},{5,5},{2,5},{4,2},{4,1},{3,1},{2,2},{1,3},{2,5},{3,2}};
        System.out.println(maximumUnits(a, 35));
    }
}
