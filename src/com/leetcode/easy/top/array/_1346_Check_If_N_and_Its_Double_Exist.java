package com.leetcode.easy.top.array;

import java.util.HashMap;
import java.util.Map;

public class _1346_Check_If_N_and_Its_Double_Exist {
    //1346. Check If N and Its Double Exist
    //https://leetcode.com/problems/check-if-n-and-its-double-exist/description/

    public boolean checkIfExist(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) map.put(arr[i], i);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0 && (map.get(arr[i] / 2) != null && map.get(arr[i] / 2) != i)) return true;
        }
        return false;
    }

    public boolean checkIfExist1(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) map.put(arr[i], i);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                var e = map.get(arr[i] / 2);
                if (e != null && e != i) return true;
            }
        }
        return false;
    }
}
