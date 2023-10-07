package com.leetcode.top.top175;

import java.util.Collections;
import java.util.PriorityQueue;

public class _378_Kth_Smallest_Element_in_a_Sorted_Matrix {
    //378. Kth Smallest Element in a Sorted Matrix
    //https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
    //FOREIGN_SOLUTION
    //TOP
    //PRIORITY QUEUE

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int n = matrix.length;
        for (int i = 0, l = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (pq.size() < k) {
                    pq.add(matrix[i][j]);
                } else if (matrix[i][j] < pq.peek()) {
                    pq.poll();
                    pq.add(matrix[i][j]);
                }

            }
        }

        return pq.peek();
    }
}
