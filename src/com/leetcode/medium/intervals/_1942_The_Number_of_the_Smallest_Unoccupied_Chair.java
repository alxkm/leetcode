package com.leetcode.medium.intervals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class _1942_The_Number_of_the_Smallest_Unoccupied_Chair {
    //1942. The Number of the Smallest Unoccupied Chair
    //https://leetcode.com/problems/the-number-of-the-smallest-unoccupied-chair/description/

    record FriendRecord(int index, int start, int end){}
    record ChairTime(int chairId, int end){}

    public static int smallestChair(int[][] times, int targetFriend) {
        PriorityQueue<ChairTime> pqTime = new PriorityQueue<>((x, y) -> x.end - y.end);
        PriorityQueue<Integer> pqChairs = new PriorityQueue<>();
        int chairSeqId = 0;
        FriendRecord[] in = new FriendRecord[times.length];
        for (int i = 0; i < times.length; i++) {
            in[i] = new FriendRecord(i, times[i][0], times[i][1]);
        }
        Arrays.sort(in, (x, y) -> x.start - y.start);
        Map<Integer, Integer> orderMap = new HashMap<>();
        for (int i = 0; i < in.length ; i++) {
            while (pqTime.size() > 0 && pqTime.peek().end <= in[i].start) {
                pqChairs.offer(pqTime.poll().chairId);
            }

            int curChair = -1;
            if (pqChairs.size() > 0) {
                curChair = pqChairs.poll();
            } else {
                curChair = chairSeqId;
                chairSeqId++;
            }

            orderMap.put(in[i].index, curChair);
            pqTime.offer(new ChairTime(curChair, in[i].end));
        }
        return orderMap.get(targetFriend);
    }
}
