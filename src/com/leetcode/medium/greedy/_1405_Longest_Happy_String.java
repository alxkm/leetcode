package com.leetcode.medium.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

public class _1405_Longest_Happy_String {
    //1405. Longest Happy String
    //https://leetcode.com/problems/longest-happy-string/description/
    //todo

    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) ->
                (y.count - x.count)
        );
        // Add the counts of a, b and c in priority queue.
        if (a > 0) {
            pq.add(new Pair(a, 'a'));
        }

        if (b > 0) {
            pq.add(new Pair(b, 'b'));
        }

        if (c > 0) {
            pq.add(new Pair(c, 'c'));
        }

        StringBuilder ans = new StringBuilder();
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int count = p.count;
            char character = p.character;
            // If three consecutive characters exists, pick the second most
            // frequent character.
            if (
                    ans.length() >= 2 &&
                            ans.charAt(ans.length() - 1) == p.character &&
                            ans.charAt(ans.length() - 2) == p.character
            ) {
                if (pq.isEmpty()) break;

                Pair temp = pq.poll();
                ans.append(temp.character);
                if (temp.count - 1 > 0) {
                    pq.add(new Pair(temp.count - 1, temp.character));
                }
            } else {
                count--;
                ans.append(character);
            }

            // If count is greater than zero, add it to priority queue.
            if (count > 0) {
                pq.add(new Pair(count, character));
            }
        }
        return ans.toString();
    }

    class Pair {

        int count;
        char character;

        Pair(int count, char character) {
            this.count = count;
            this.character = character;
        }
    }

    public static int maximumSwap(int num) {
        char[] ch = Integer.valueOf(num).toString().toCharArray();
        int[][] ar = new int[ch.length][2];
        for (int i = 0; i < ar.length; i++) {
            ar[i] = new int[] {ch[i], i};
        }
        Arrays.sort(ar, (x, y) -> y[0] - x[0]);
        System.out.println(Arrays.deepToString(ar));
        for (int i = 0; i < ar.length; i++) {
            if (ch[i] != ar[i][0]) {
                int j = i;
                while (j + 1 < ar.length && ar[j][0] == ar[j + 1][0]) j++;
                char c = ch[i];
                ch[i] = (char)ar[j][0];
                ch[ar[j][1]] = c;
                break;
            }
        }
        return Integer.parseInt(new String(ch));
    }

    public String convertDateToBinary(String date) {
        String[] ar = date.split("-");
        StringBuilder sb = new StringBuilder();
        Stack<String> st = new Stack<>();
        for (String s: ar) {
            Integer n = Integer.valueOf(s);
            while (n > 0) {
                sb.append(n % 2);
                n /= 2;
            }
            sb.append("-");
        }
        sb.substring(0, sb.length() - 1);
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(maximumSwap(1993));
    }
}
