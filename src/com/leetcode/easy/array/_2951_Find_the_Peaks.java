package com.leetcode.easy.array;

import java.util.ArrayList;
import java.util.List;

public class _2951_Find_the_Peaks {
    //2951. Find the Peaks
    //https://leetcode.com/problems/find-the-peaks/description/

    public List<Integer> findPeaks(int[] mountain) {
        List<Integer> peaks = new ArrayList<>();

        for (int i = 1; i < mountain.length - 1; i++) {
            if (mountain[i] > mountain[i - 1] && mountain[i] > mountain[i + 1]) {
                peaks.add(i);
            }
        }

        return peaks;
    }
}
