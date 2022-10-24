package com.company.array;

import java.util.HashSet;
import java.util.Set;

public class _2103_Rings_and_Rods {
    public int countPoints(String rings) {
        Set<Integer> r = new HashSet<>();
        Set<Integer> g = new HashSet<>();
        Set<Integer> b = new HashSet<>();

        for (int i = 0; i < rings.length(); i++) {
            char ch = rings.charAt(i);
            int rod = (int)rings.charAt(++i) - 48;
            if (ch == 'R') {
                r.add(rod);
            } else if (ch == 'G') {
                g.add(rod);
            } else if (ch == 'B') {
                b.add(rod);
            }
        }

        r.retainAll(g);
        r.retainAll(b);

        return r.size();
    }
}
