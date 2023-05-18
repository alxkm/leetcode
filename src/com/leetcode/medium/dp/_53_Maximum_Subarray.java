package com.leetcode.medium.dp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _53_Maximum_Subarray {
    //https://leetcode.com/problems/maximum-subarray/

    public static int maxSubArray(int[] nums) {
        int localSum = nums[0];
        int sum = nums[0];
        // max (a_i, a_i + a_i+1
        for (int i = 1; i < nums.length; i++) {
            if (localSum < nums[i] && (localSum + nums[i] < nums[i])) {
                localSum = nums[i];
            } else {
                localSum += nums[i];
            }
            sum = Math.max(localSum, sum);
        }
        return sum;
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int maxSize = 0;
        if (s.equals("")) return maxSize;

        for (int i = 0; i < s.length(); i++) {

            Integer index = map.get(s.charAt(i));
            if (index == null) {
                map.put(s.charAt(i), i);
                maxSize = Math.max(maxSize, map.size());
                continue;
            }
            map.put(s.charAt(i), i);

            Set<Character> keys = new HashSet<>();
            for (Map.Entry<Character, Integer> kv : map.entrySet()) {
                if (kv.getValue() < index) {
                    keys.add(kv.getKey());
                }
            }
            for (Character key : keys) {
                map.remove(key);
            }
        }
        return maxSize;
    }

    public static int lengthOfLongestSubstring1(String s) {
        Map<Character, Integer> map = new HashMap();
        int maxSize = 0;
        if (s.equals("")) return maxSize;

        for (int i = 0; i < s.length(); i++) {

            Integer index = map.get(s.charAt(i));
            if (index == null) {
                map.put(s.charAt(i), i);
                maxSize = Math.max(maxSize, map.size());
                continue;
            }

            if (i - index == 1) {
                map.clear();
                map.put(s.charAt(i), i);
            } else {
                map.put(s.charAt(i), i);
            }
        }
        return maxSize;
    }

    public static void main(String[] args) {
        //int[] array = {5,4,-1,7,8};
        //System.out.println(maxSubArray(array));
    }
}
