package com.company.matrix;

public class _1572_Matrix_Diagonal_Sum {
   static public int diagonalSum(int[][] mat) {
        int main = 0;
        int sub = 0;
        int l = mat[0].length - 1;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (i == j) {
                    main += mat[i][j];
                }
                if ((j == l - i) && !(i == j)) {
                    sub += mat[i][j];
                }
            }
        }
        return main + sub;
    }

    public static void main(String[] args) {
        int[][] a = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int ints = diagonalSum(a);

        System.out.println(ints);
    }
}
