package com.leetcode.medium.matrix;

import com.leetcode.ListNode;
import com.leetcode.ListUtil;

import java.util.Arrays;

public class _2326_Spiral_Matrix_IV {
    //2326. Spiral Matrix IV
    //https://leetcode.com/problems/spiral-matrix-iv/description/

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] ar = new int[m][n];
        for (int[] a: ar) {
            Arrays.fill(a, -1);
        }

        int ax = 0, ay = 0;
        int bx = 0, by = n;
        int cx = m, cy = n;
        int dx = m, dy = 0;

        int i = 0, j = 0;
        var h = head;
        while (h != null) {
            // --->
            i = ax;
            j = ay;
            while (h != null && j < by) {
                ar[i][j] = h.val;
                h = h.next;
                j++;
            }
            bx++;
            by--;

            // down
            i = bx;
            j = by;
            while (h != null && i < cx) {
                ar[i][j] = h.val;
                i++;
                h = h.next;
            }
            cx--;
            cy--;

            // <---
            i = cx;
            j = cy - 1;
            while (h != null && j >= dy) {
                ar[i][j] = h.val;
                j--;
                h = h.next;
            }
            dx--;
            dy++;

            // up
            i = dx - 1;
            j = ay;
            while (h != null && i > ax) {
                ar[i][j] = h.val;
                i--;
                h = h.next;
            }
            ax++;
            ay++;
        }

        return ar;
    }

    public static void main(String[] args) {
        var sol = new _2326_Spiral_Matrix_IV();

        sol.spiralMatrix(3, 5, ListUtil.of(3,0,2,6,8,1,7,9,4,2,5,5,0));
    }
}
