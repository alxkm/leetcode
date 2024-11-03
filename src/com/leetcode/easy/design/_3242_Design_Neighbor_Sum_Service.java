package com.leetcode.easy.design;

import com.leetcode.Pair;

import java.util.HashMap;
import java.util.Map;

public class _3242_Design_Neighbor_Sum_Service {
    //https://leetcode.com/problems/design-neighbor-sum-service/description/
    //3242. Design Neighbor Sum Service

    class NeighborSum {
        Map<Integer, Pair<Integer, Integer>> valueToPair = new HashMap<>();
        Map<Pair<Integer, Integer>, Integer> pairToValue = new HashMap<>();

        public NeighborSum(int[][] grid) {
            for (int i = 0; i < grid.length; i++){
                for (int j = 0; j < grid[0].length; j++) {
                    Pair<Integer, Integer> p = new Pair<>(i, j);
                    valueToPair.put(grid[i][j], p);
                    pairToValue.put(p, grid[i][j]);
                }
            }
        }

        public int adjacentSum(int value) {
            var p = valueToPair.get(value);

            int sum = 0;
            sum += pairToValue.getOrDefault(new Pair<>(p.getKey() + 1, p.getValue()), 0);
            sum += pairToValue.getOrDefault(new Pair<>(p.getKey(), p.getValue() + 1), 0);
            sum += pairToValue.getOrDefault(new Pair<>(p.getKey() - 1, p.getValue()), 0);
            sum += pairToValue.getOrDefault(new Pair<>(p.getKey(), p.getValue() - 1), 0);

            return sum;
        }

        public int diagonalSum(int value) {
            var p = valueToPair.get(value);

            int sum = 0;
            sum += pairToValue.getOrDefault(new Pair<>(p.getKey() + 1, p.getValue() + 1), 0);
            sum += pairToValue.getOrDefault(new Pair<>(p.getKey() - 1, p.getValue() + 1), 0);
            sum += pairToValue.getOrDefault(new Pair<>(p.getKey() - 1, p.getValue() - 1), 0);
            sum += pairToValue.getOrDefault(new Pair<>(p.getKey() + 1, p.getValue() - 1), 0);

            return sum;
        }
    }
}
