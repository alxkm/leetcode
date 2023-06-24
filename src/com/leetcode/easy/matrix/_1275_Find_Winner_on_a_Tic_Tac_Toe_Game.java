package com.leetcode.easy.matrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _1275_Find_Winner_on_a_Tic_Tac_Toe_Game {
    //https://leetcode.com/problems/find-winner-on-a-tic-tac-toe-game/

    private Map<Integer, List<Integer>> a = new HashMap<>();
    private Map<Integer, List<Integer>> a1 = new HashMap<>();
    private Map<Integer, List<Integer>> b = new HashMap<>();
    private Map<Integer, List<Integer>> b1 = new HashMap<>();
    int d1 = 0;
    int d2 = 0;
    int s1 = 0;
    int s2 = 0;

    public String tictactoe(int[][] moves) {
        int i = 1;
        for (int[] arr: moves) {
            if (i == 1 || i % 2 != 0) {
                var l = a.getOrDefault(arr[0], new ArrayList<>());
                var l1 = a1.getOrDefault(arr[1], new ArrayList<>());
                l.add(arr[1]);
                a.put(arr[0], l);
                l1.add(arr[0]);
                a1.put(arr[1], l1);

                if (checkDiagonal(arr)) d1++;
                if (checkSubDiagonal(arr)) s1++;

                if (l.size() == 3 || l1.size() == 3 || d1 == 3 || s1 == 3) {
                    return "A";
                }
                i++;
            } else {
                var l = b.getOrDefault(arr[0], new ArrayList<>());
                var l1 = b1.getOrDefault(arr[1], new ArrayList<>());
                l.add(arr[1]);
                b.put(arr[0], l);
                l1.add(arr[0]);
                b1.put(arr[1], l1);

                if (checkDiagonal(arr)) d2++;
                if (checkSubDiagonal(arr)) s2++;

                if (l.size() == 3 || l1.size() == 3 || d1 == 3 || s2 == 3) {
                    return "B";
                }
                i++;
            }
        }
        return (moves.length == 9) ? "Draw" : "Pending";
    }

    private boolean checkDiagonal(int[] x) {
        if (x[0] == 0 && x[1] == 0) return true;
        if (x[0] == 1 && x[1] == 1) return true;
        if (x[0] == 2 && x[1] == 2) return true;
        return false;
    }

    private boolean checkSubDiagonal(int[] x) {
        if (x[0] == 0 && x[1] == 2) return true;
        if (x[0] == 1 && x[1] == 1) return true;
        if (x[0] == 2 && x[1] == 0) return true;
        return false;
    }
}
