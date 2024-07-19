package com.leetcode.easy.matrix;

public class _3127_Make_a_Square_with_the_Same_Color {
    //3127. Make a Square with the Same Color
    //https://leetcode.com/problems/make-a-square-with-the-same-color

    public boolean canMakeSquare(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                char c = grid[i][j];
                if (c == 'W') {
                    grid[i][j] = 'B';
                    if (check(grid, 'B')) return true;
                } else {
                    grid[i][j] = 'W';
                    if (check(grid, 'W')) return true;
                }
                grid[i][j] = c;
                if (check(grid, 'W') || check(grid, 'B')) return true;
            }
        }
        return false;
    }

    private boolean check(char[][] g, char c) {
        if (g[0][0] == c && g[0][1] == c && g[1][0] == c && g[1][1] == c) return true;
        if (g[0][1] == c && g[0][2] == c && g[1][1] == c && g[1][2] == c) return true;
        if (g[1][0] == c && g[1][1] == c && g[2][0] == c && g[2][1] == c) return true;
        if (g[1][1] == c && g[1][2] == c && g[2][1] == c && g[2][2] == c) return true;
        return false;
    }

    public static void main(String[] args) {
        var sol = new _3127_Make_a_Square_with_the_Same_Color();
        sol.canMakeSquare(new char[][] {{'B','W','B'},{'W','B','W'},{'B','W','B'}});
    }
}
