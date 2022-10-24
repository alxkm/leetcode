package com.company.gold.array;

import java.util.HashMap;
import java.util.Map;

public class _1346_Check_If_N_and_Its_Double_Exist {
    public boolean checkIfExist(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) map.put(arr[i], i);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0 && (map.get(arr[i] / 2) != null && map.get(arr[i] / 2) != i)) return true;
        }
        return false;
    }
}
