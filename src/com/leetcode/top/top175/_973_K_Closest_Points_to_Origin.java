package com.leetcode.top.top175;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class _973_K_Closest_Points_to_Origin {
    //https://leetcode.com/problems/k-closest-points-to-origin/
    //973. K Closest Points to Origin
    //queue
    //todo todo todo

    public int[][] kClosest(int[][] points, int k) {
        TreeMap <Integer, int[]> map = new TreeMap<>();
        Queue<int[]> q = new PriorityQueue<>(
                (x, y) -> (int)Math.sqrt(x[0]*x[0] + x[1]*x[1]) - (int)Math.sqrt(y[0]*y[0] + y[1]*y[1]));

        for (var p: points) {
            q.offer(p);
//            int x = p[0] - 0;
//            int y = p[1] - 0;
//            int d = (int)Math.sqrt(x*x + y*y);
//            map.put(d, p);
        }

        int[][] a = new int[k][2];
//        int i = 0;
//        for (var e: map.descendingMap().entrySet()) {
//            i++;
//            //if (i >= k) break;
//            if (i < k) {
//                a[i] = e.getValue();
//            }
//            System.out.println(Arrays.toString(e.getValue()));
//        }
        for (int i = 0; i < k; i++) {
            a[i] = q.poll();
        }
        return a;
    }

    public static void main(String[] args) {
        var solution = new _973_K_Closest_Points_to_Origin();
        int[][] a = {{3,3}, {5,-1}, {-2,4}};
        int k = 2;
        System.out.println(Arrays.deepToString(solution.kClosest(a, k)));
    }
}
