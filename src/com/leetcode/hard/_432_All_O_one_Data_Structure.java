package com.leetcode.hard;

import java.util.HashMap;
import java.util.Map;

public class _432_All_O_one_Data_Structure {
    //432. All O`one Data Structure
    //https://leetcode.com/problems/all-oone-data-structure/description/

    class AllOne {
        Map<String, Integer> map = new HashMap<>();
        int revision = 0;
        int prevRevision = 0;
        String prevMax = null;
        String prevMin = null;

        public AllOne() {

        }

        public void inc(String key) {
            revision++;
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        public void dec(String key) {
            revision++;
            int size = map.getOrDefault(key, 0);
            if (size == 1) map.remove(key);
            else map.put(key, size - 1);
        }

        public String getMaxKey() {
            if (map.size() == 0) return "";
            if (revision != prevRevision) updateToLastRevision();
            return prevMax;
        }

        private void updateToLastRevision() {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            String curMaxKey = null;
            String curMinKey = null;
            for (var entry: map.entrySet()) {
                if (max < entry.getValue()) {
                    max = entry.getValue();
                    curMaxKey = entry.getKey();
                }
                if (min > entry.getValue()) {
                    min = entry.getValue();
                    curMinKey = entry.getKey();
                }
            }
            revision = prevRevision;
            prevMin = curMinKey;
            prevMax = curMaxKey;
        }

        public String getMinKey() {
            if (map.size() == 0) return "";
            if (prevRevision != revision) updateToLastRevision();
            return prevMin;
        }
    }

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
}
