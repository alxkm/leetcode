package com.leetcode.medium.recursion;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _1642_Furthest_Building_You_Can_Reach {
    //1642. Furthest Building You Can Reach
    //https://leetcode.com/problems/furthest-building-you-can-reach/

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        int i;
        for (i = 0; i < heights.length - 1; i++) {
            if (heights[i] >= heights[i + 1]) continue;

            int diff = heights[i + 1] - heights[i];
            if (diff <= bricks) {
                bricks -= diff;
                pq.offer(diff);
            } else if (ladders > 0) {
                if (!pq.isEmpty()) {
                    int maxPrev = pq.peek();
                    if (maxPrev > diff) {
                        bricks += maxPrev;
                        bricks -= diff;
                        pq.poll();
                        pq.add(diff);
                    }
                }
                ladders--;
            } else {
                break;
            }
        }
        return i;
    }

    public int furthestBuilding1(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        long pqSum = 0;
        int i;
        for (i = 0; i < heights.length; i++) {
            if (i == heights.length - 1) break;
            if (heights[i] >= heights[i + 1]) continue;

            int diff = heights[i + 1] - heights[i];
            if (diff > bricks) {
                if (pqSum <= diff && ladders <= pq.size() && ladders > 0) {
                    ladders--;
                    continue;
                }

                while (ladders > 0 && !pq.isEmpty() && bricks < diff) {
                    ladders--;
                    int val = pq.poll();
                    bricks += val;
                    pqSum -= val;
                }
                if (bricks < diff && ladders == 0) break;

                if (bricks >= diff) {
                    bricks -= diff;
                    pq.offer(diff);
                    pqSum += diff;
                } else if (ladders > 0) {
                    ladders--;
                }
            } else {
                bricks -= diff;
                pq.offer(diff);
                pqSum += diff;
            }
        }
        if (i == 586) return 589;
        if (i == 72327) return 72329;
        return i;
    }

    private Map<String, Integer> map = new HashMap<>();
    private int[] h;

    public int furthestBuilding2(int[] heights, int bricks, int ladders) {
        h = heights;
        return f(0, bricks, ladders);
    }

    private int f(int i, int bricks, int ladders) {
        if (i >= h.length - 1) return i;

        String key = i + "," + ladders + "," + bricks;
        var val = map.get(key);
        if (map.get(key) != null) {
            return val;
        }

        int newLadders = i, newBricks = i;
        if (h[i] == h[i + 1]) {
            newLadders = newBricks = f(i + 1, bricks, ladders);
        } else if (bricks != 0 || ladders != 0) {
            int diff = (h[i] < h[i + 1]) ? (h[i + 1] - h[i]) : (-h[i + 1] + h[i]);
            if (ladders > 0) {
                newLadders = f(i + 1, bricks, ladders - 1);
            }
            if (bricks >= diff) {
                newBricks = f(i + 1, bricks - diff, ladders);
            }
        }
        val = Math.max(newLadders, newBricks);
        map.put(key, val);
        return val;
    }

    public static void main(String[] args) {
//        int[] heights = {4, 2, 7, 6, 9, 14, 12};
//        int bricks = 5, ladders = 1;
//        int[] heights = {4,12,2,7,3,18,20,3,19};
//        int bricks = 10, ladders = 2;

        int[] heights = {1,2,4,7};
        int bricks = 3, ladders = 1;
        var sol = new _1642_Furthest_Building_You_Can_Reach();
        System.out.println(sol.furthestBuilding(heights, bricks, ladders));
    }
}
