package com.leetcode.medium.pq;

import java.util.PriorityQueue;

public class _1405_Longest_Happy_String {
    //1405. Longest Happy String
    //https://leetcode.com/problems/longest-happy-string/description/?envType=daily-question&envId=2024-10-16
    //todo todo todo

    static class Pair {
        public char ch;
        public int size;

        public Pair(char ch, int size) {
            this.ch = ch;
            this.size = size;
        }
    }

    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> y.size - x.size);
        StringBuilder sb = new StringBuilder();
        if (a > 0)  pq.offer(new Pair('a', a));
        if (b > 0)  pq.offer(new Pair('b', b));
        if (c > 0)  pq.offer(new Pair('c', c));

        while (!pq.isEmpty()) {

            if (pq.size() == 1) {
                Pair pair = pq.poll();
                if (sb.length() == 0 || !(sb.charAt(sb.length() - 1) == pair.ch)) {
                    for (int i = 0; i < pair.size && i < 2; i++) {
                        sb.append(pair.ch);
                    }
                }
                break;
            }

            Pair pair = pq.poll();
            if (sb.length() == 0 || sb.charAt(sb.length() - 1) != pair.ch) {
                for (int i = 0; pair.size > 0 && i < 2; i++) {
                    sb.append(pair.ch);
                    pair.size--;
                }
                if (pair.size > 0) {
                    pq.offer(pair);
                }
                continue;
            }

            Pair nextPair = pq.poll();
            int nextPrintSize = 1;
            if (nextPair.size >= pair.size) nextPrintSize = 2;

            for (int i = 0; nextPair.size > 0 && i < nextPrintSize; i++) {
                sb.append(nextPair.ch);
                nextPair.size--;
            }

            for (int i = 0; pair.size > 0 && i < 2; i++) {
                sb.append(pair.ch);
                pair.size--;
            }

            if (pair.size > 0) pq.offer(pair);
            if (nextPair.size > 0) pq.offer(nextPair);
        }

        return sb.toString();
    }
}
