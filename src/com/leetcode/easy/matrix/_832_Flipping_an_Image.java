package com.company.matrix;

public class _832_Flipping_an_Image {
    static  public int[][] flipAndInvertImage(int[][] image) {
        for (int i = 0; i < image.length; i++) {
            int l = image[i].length;
            for (int j = 0; j < image[i].length / 2; j++) {
                int temp = image[i][j];
                image[i][j] = image[i][l - 1 - j];
                image[i][l - 1 - j] = temp;
            }
        }

        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                if (image[i][j] == 0) image[i][j] = 1;
                else image[i][j] = 0;
            }
        }

        return image;
    }

    public static void main(String[] args) {
        int[][] a = {
                {1,1,0},
                {1,0,1},
                {0,0,0}
        };

        int[][] ints = flipAndInvertImage(a);

        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < ints[i].length; j++) {
                System.out.printf(ints[i][j] + " ");
            }
            System.out.println();
        }
    }
}
