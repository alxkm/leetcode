package com.company.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _1046_Last_Stone_Weight {
    static public int lastStoneWeight(int[] stones) {
        List<Integer> s = new ArrayList<>();
        for (int stone : stones) {
            s.add(stone);
        }

        while (s.size() > 1) {
            s = s.stream().sorted().collect(Collectors.toList());
            var a = s.get(s.size() - 2);
            var b = s.get(s.size() - 1);

            s.remove(Integer.valueOf(a));
            s.remove(Integer.valueOf(b));
            a = Math.abs(a - b);
            if (a != 0) s.add(a);
            if (s.size() == 0) return 0;
        }
        return s.get(0);
    }

    public static void main(String[] args) {
        int[] a = {2,2};

        System.out.println(lastStoneWeight(a));
    }
}
