package com.company.string;

import java.util.HashMap;
import java.util.Map;

public class _2423_Remove_Letter_To_Equalize_Frequency {
    static public boolean equalFrequency(String word) {
//        Map<Character, Integer> map = new HashMap();
//
//        for (Character ch : word.toCharArray()) {
//            map.put(ch, map.getOrDefault(ch, 0) + 1);
//        }
//
//        int sum = 0;
//        int one = 0;
//        int max = 0;
//        int min = 100;
//        for (var entry : map.entrySet()) {
//            sum += entry.getValue();
//            if (entry.getValue() == 1) one++;
//            max = Math.max(max, entry.getValue());
//            if (entry.getValue() != 1) min = Math.min(min, entry.getValue());
//        }
//        if (one == map.size()) return true;
//        if (one == 1 && (max == min) && ((sum - 1) % (map.size() - 1) == 0)) return true;
//        return (max == min + 1) && ((sum - 1) % (map.size() - 1) == 0);



        Map<Character, Integer> map = new HashMap();

        for (Character ch : word.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int sum = 0;
        int max = 0;
        int min = 100;

        boolean allSingle = true;
        boolean singleExist = false;
        for (var entry : map.entrySet()) {
            sum += entry.getValue();
            if (entry.getValue() > 1) allSingle = false;
            if (entry.getValue() == 1) singleExist = true;
            max = Math.max(max, entry.getValue());
            if (entry.getValue() != 1) min = Math.min(min, entry.getValue());
        }

        if (allSingle) return true;
        if (singleExist && ((sum - 1) % (map.size() - 1) == 0) && (max - min < 2)) return true;

        return ((sum - 1) % (map.size())) == 0 && (max - min < 2);
    }

    public static void main(String[] args) {
        //System.out.println(equalFrequency("pzvmfpvsxnkxwwcoabllelzjkczlgmkqdxyvpxlwzmhpkdstvkwlfhqumvxawueqabmqcz"));
        System.out.println(equalFrequency("aaaaabb"));
    }
}
