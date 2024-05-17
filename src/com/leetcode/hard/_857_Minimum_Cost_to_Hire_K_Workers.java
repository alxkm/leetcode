package com.leetcode.hard;

import com.leetcode.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class _857_Minimum_Cost_to_Hire_K_Workers {
    //857. Minimum Cost to Hire K Workers
    //https://leetcode.com/problems/minimum-cost-to-hire-k-workers/description/

    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        List<Pair<Double, Integer>> wageToQualityRatio = new ArrayList<>();
        for (int i = 0; i < quality.length; i++) {
            wageToQualityRatio.add(new Pair<>((double)wage[i] / quality[i], quality[i]));
        }
        Collections.sort(wageToQualityRatio, Comparator.comparingDouble(Pair::getKey));

        double totalCost = Double.MAX_VALUE;
        double currentTotalQuality = 0;

        PriorityQueue<Integer> highestQualityWorkers = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < quality.length; i++) {
            highestQualityWorkers.add(wageToQualityRatio.get(i).getValue());
            currentTotalQuality += wageToQualityRatio.get(i).getValue();

            if (highestQualityWorkers.size() > k) {
                currentTotalQuality -= highestQualityWorkers.poll();
            }

            if (highestQualityWorkers.size() == k) {
                totalCost = Math.min(totalCost, currentTotalQuality * wageToQualityRatio.get(i).getKey());
            }
        }
        return totalCost;
    }
}
