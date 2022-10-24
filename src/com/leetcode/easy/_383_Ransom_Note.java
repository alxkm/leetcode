package com.company;

import java.util.ArrayList;
import java.util.List;

public class _383_Ransom_Note {
    static public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;

        List<Character> l1 = new ArrayList<>();
        for(int i = 0; i < magazine.length(); i++) {
            l1.add(magazine.charAt(i));
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            boolean removed = false;
            int index = -1;
            for (int j = 0; j < l1.size(); j++) {
                if (l1.get(j) == ransomNote.charAt(i)) {
                    index = j;
                    removed = true;
                    break;
                }
            }
            if (!removed) return false;
            l1.remove(index);
        }
        return true;
    }
}
