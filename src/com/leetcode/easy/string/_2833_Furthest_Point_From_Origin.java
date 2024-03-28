package com.leetcode.easy.string;

public class _2833_Furthest_Point_From_Origin {
    //2833. Furthest Point From Origin
    //https://leetcode.com/problems/furthest-point-from-origin/

    public int furthestDistanceFromOrigin(String moves) {
        int l = 0;
        int r = 0;
        int empty = 0;

        for (char ch: moves.toCharArray()) {
            if (ch == 'L') l++;
            else if (ch == 'R') r++;
            else empty++;
        }

        if (empty == 0 && l == r) return 0;
        if (empty == 0) return Math.abs(l - r);

        if (l > r) {
            moves = moves.replaceAll("_", "L");
        } else {
            moves = moves.replaceAll("_", "R");
        }
        l = 0;
        r = 0;
        for (char ch: moves.toCharArray()) {
            if (ch == 'L') l++;
            else if (ch == 'R') r++;
            else empty++;
        }
        return Math.abs(l - r);
    }

    private int countMaxSymbol(char symbol, String moves) {
        int count = 0;
        int max = 0;
        for (char ch: moves.toCharArray()) {
            if (ch == symbol) {
                count++;
                max = Math.max(count, max);
            } else {
                max = Math.max(count, max);
                count = 0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        var sol = new _2833_Furthest_Point_From_Origin();
        System.out.println(sol.furthestDistanceFromOrigin("LRL"));
    }
}
