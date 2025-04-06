package com.leetcode.hard;

import com.leetcode.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _2940_Find_Building_Where_Alice_and_Bob_Can_Meet {
    //2940. Find Building Where Alice and Bob Can Meet
    //https://leetcode.com/problems/find-building-where-alice-and-bob-can-meet/description/

    class Solution {

        public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
            List<Pair<Integer, Integer>> monoStack = new ArrayList<>();
            int[] result = new int[queries.length];
            Arrays.fill(result, -1);
            List<List<Pair<Integer, Integer>>> newQueries = new ArrayList<>(
                    heights.length
            );

            for (int i = 0; i < heights.length; i++) {
                newQueries.add(new ArrayList<>());
            }

            for (int i = 0; i < queries.length; i++) {
                int a = queries[i][0];
                int b = queries[i][1];
                if (a > b) {
                    int temp = a;
                    a = b;
                    b = temp;
                }
                if (heights[b] > heights[a] || a == b) {
                    result[i] = b;
                } else {
                    newQueries.get(b).add(new Pair<>(heights[a], i));
                }
            }

            for (int i = heights.length - 1; i >= 0; i--) {
                int monoStackSize = monoStack.size();
                for (Pair<Integer, Integer> pair : newQueries.get(i)) {
                    int position = search(pair.getKey(), monoStack);
                    if (position < monoStackSize && position >= 0) {
                        result[pair.getValue()] = monoStack
                                .get(position)
                                .getValue();
                    }
                }

                while (
                        !monoStack.isEmpty() &&
                                monoStack.get(monoStack.size() - 1).getKey() <= heights[i]
                ) {
                    monoStack.remove(monoStack.size() - 1);
                }

                monoStack.add(new Pair<>(heights[i], i));
            }

            return result;
        }

        private int search(int height, List<Pair<Integer, Integer>> monoStack) {
            int left = 0;
            int right = monoStack.size() - 1;
            int ans = -1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (monoStack.get(mid).getKey() > height) {
                    ans = Math.max(ans, mid);
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return ans;
        }
    }
}
