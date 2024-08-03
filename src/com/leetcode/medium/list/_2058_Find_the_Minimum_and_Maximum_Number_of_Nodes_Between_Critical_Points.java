package com.leetcode.medium.list;

import com.leetcode.ListNode;
import com.leetcode.ListUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _2058_Find_the_Minimum_and_Maximum_Number_of_Nodes_Between_Critical_Points {
    //2058. Find the Minimum and Maximum Number of Nodes Between Critical Points
    //https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/description/?envType=daily-question&envId=2024-07-05

    public int[] nodesBetweenCriticalPoints(ListNode head) {
        List<Integer> list = new ArrayList<>();
        int prevPrev = head.val;
        head = head.next;
        if (head == null || head.next == null) return new int[] {-1, -1};
        int prev = head.val;
        head = head.next;
        int i = 3;
        int min = Integer.MAX_VALUE;
        while (head != null) {
            if ((prevPrev > prev && prev < head.val) || (prevPrev < prev && prev > head.val) ) {
                if (!list.isEmpty()) {
                    min = Math.min(min, i - list.get(list.size() - 1));
                }
                list.add(i);
            }
            prevPrev = prev;
            prev = head.val;
            i++;
            head = head.next;
        }
        if (list.size() <= 1) return new int[] {-1, -1};
        return new int[]{min, list.get(list.size() - 1) - list.get(0)};
    }

    public int[] nodesBetweenCriticalPoints1(ListNode head) {
        Integer first = null;
        Integer last = null;
        int prevPrev = head.val;
        head = head.next;
        if (head == null || head.next == null) return new int[] {-1, -1};
        int prev = head.val;
        head = head.next;
        int i = 3;
        int min = Integer.MAX_VALUE;
        while (head != null) {
            if ((prevPrev > prev && prev < head.val) || (prevPrev < prev && prev > head.val) ) {
                if (last != null) {
                    min = Math.min(min, i - last);
                }
                last = i;
                if (first == null) first = i;
            }
            prevPrev = prev;
            prev = head.val;
            i++;
            head = head.next;
        }
        if (first == null || first == last) return new int[] {-1, -1};
        return new int[]{min, last - first};
    }

    public static void main(String[] args) {
        var sol = new _2058_Find_the_Minimum_and_Maximum_Number_of_Nodes_Between_Critical_Points();
        System.out.println(Arrays.toString(sol.nodesBetweenCriticalPoints(ListUtil.of(2,3,3,2))));
        System.out.println(Arrays.toString(sol.nodesBetweenCriticalPoints(ListUtil.of(5, 3, 1, 2, 5, 1, 2))));
        System.out.println(Arrays.toString(sol.nodesBetweenCriticalPoints(ListUtil.of(1,3,2,2,3,2,2,2,7))));
    }
}
