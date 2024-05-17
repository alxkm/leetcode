package com.leetcode.medium.graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class _752_Open_the_Lock {
    //752. Open the Lock
    //https://leetcode.com/problems/open-the-lock/

    public int openLock(String[] deadends, String target) {
        Map<Character, Character> nextMap = Map.of(
                '0', '1',
                '1', '2',
                '2', '3',
                '3', '4',
                '4', '5',
                '5', '6',
                '6', '7',
                '7', '8',
                '8', '9',
                '9', '0'
        );
        Map<Character, Character> prevMap = Map.of(
                '0', '9',
                '1', '0',
                '2', '1',
                '3', '2',
                '4', '3',
                '5', '4',
                '6', '5',
                '7', '6',
                '8', '7',
                '9', '8'
        );
        Set<String> visit = new HashSet<>(Arrays.asList(deadends));
        if (visit.contains("0000")) return -1;
        Queue<String> q = new LinkedList<>();
        q.add("0000");
        visit.add("0000");
        int counter = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                if (cur.equals(target)) return counter;

                for (int j = 0; j < 4; j++) {
                    char[] next = cur.toCharArray();
                    next[j] = nextMap.get(cur.charAt(j));
                    String nextS = String.valueOf(next);
                    if (!visit.contains(nextS)) {
                        visit.add(nextS);
                        q.add(nextS);
                    }

                    char[] prev = cur.toCharArray();
                    prev[j] = prevMap.get(cur.charAt(j));
                    String prevS = String.valueOf(prev);
                    if (!visit.contains(prevS)) {
                        visit.add(prevS);
                        q.add(prevS);
                    }
                }
            }
            counter++;
        }
        return -1;
    }

    public static void main(String[] args) {
        var sol = new _752_Open_the_Lock();
        System.out.println(sol.openLock(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"));
    }

    class Solution {
        public int openLock(String[] deadends, String target) {
            // Map the next slot digit for each current slot digit.
            Map<Character, Character> nextSlot = Map.of(
                    '0', '1',
                    '1', '2',
                    '2', '3',
                    '3', '4',
                    '4', '5',
                    '5', '6',
                    '6', '7',
                    '7', '8',
                    '8', '9',
                    '9', '0'
            );
            // Map the previous slot digit for each current slot digit.
            Map<Character, Character> prevSlot = Map.of(
                    '0', '9',
                    '1', '0',
                    '2', '1',
                    '3', '2',
                    '4', '3',
                    '5', '4',
                    '6', '5',
                    '7', '6',
                    '8', '7',
                    '9', '8'
            );

            // Set to store visited and dead-end combinations.
            Set<String> visitedCombinations = new HashSet<>(Arrays.asList(deadends));
            // Queue to store combinations generated after each turn.
            Queue<String> pendingCombinations = new LinkedList<String>();

            // Count the number of wheel turns made.
            int turns = 0;

            // If the starting combination is also a dead-end,
            // then we can't move from the starting combination.
            if (visitedCombinations.contains("0000")) {
                return -1;
            }

            // Start with the initial combination '0000'.
            pendingCombinations.add("0000");
            visitedCombinations.add("0000");

            while (!pendingCombinations.isEmpty()) {
                // Explore all the combinations of the current level.
                int currLevelNodesCount = pendingCombinations.size();
                for (int i = 0; i < currLevelNodesCount; i++) {
                    // Get the current combination from the front of the queue.
                    String currentCombination = pendingCombinations.poll();

                    // If the current combination matches the target,
                    // return the number of turns/level.
                    if (currentCombination.equals(target)) {
                        return turns;
                    }

                    // Explore all possible new combinations by turning each wheel in both directions.
                    for (int wheel = 0; wheel < 4; wheel += 1) {
                        // Generate the new combination by turning the wheel to the next digit.
                        StringBuilder newCombination = new StringBuilder(currentCombination);
                        newCombination.setCharAt(wheel, nextSlot.get(newCombination.charAt(wheel)));
                        // If the new combination is not a dead-end and was never visited,
                        // add it to the queue and mark it as visited.
                        if (!visitedCombinations.contains(newCombination.toString())) {
                            pendingCombinations.add(newCombination.toString());
                            visitedCombinations.add(newCombination.toString());
                        }

                        // Generate the new combination by turning the wheel to the previous digit.
                        newCombination = new StringBuilder(currentCombination);
                        newCombination.setCharAt(wheel, prevSlot.get(newCombination.charAt(wheel)));
                        // If the new combination is not a dead-end and is never visited,
                        // add it to the queue and mark it as visited.
                        if (!visitedCombinations.contains(newCombination.toString())) {
                            pendingCombinations.add(newCombination.toString());
                            visitedCombinations.add(newCombination.toString());
                        }
                    }
                }
                // We will visit next-level combinations.
                turns += 1;
            }
            // We never reached the target combination.
            return -1;
        }
    }
}
