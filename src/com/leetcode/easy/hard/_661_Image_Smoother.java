package com.leetcode.easy.hard;

public class _661_Image_Smoother {
    //661. Image Smoother
    //https://leetcode.com/problems/image-smoother/description/

    public int[][] imageSmoother(int[][] img) {
        int m = img.length, n = img[0].length;
        int[][] ar = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                int sum = 0;
                int count = 0;
                for (int k = i - 1; k <= i + 1; k++) {
                    for (int l = j - 1; l <= j + 1; l++) {
                        if (k >= 0 && k < m && l >= 0 && l < n) {
                            sum += img[k][l];
                            count++;
                        }
                    }
                }
                ar[i][j] = sum / count;
            }
        }

        return ar;
    }

    public static void main(String[] args) {
        int[][] img = {{100, 200, 100}, {200, 50, 200}, {100, 200, 100}};
        var sol = new _661_Image_Smoother();
        sol.imageSmoother(img);
    }
}
