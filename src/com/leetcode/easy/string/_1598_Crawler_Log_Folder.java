package com.leetcode.easy.string;

public class _1598_Crawler_Log_Folder {
    //1598. Crawler Log Folder
    //https://leetcode.com/problems/crawler-log-folder/description/?envType=daily-question&envId=2024-07-10

    public int minOperations(String[] logs) {
        int i = 0;
        for (String s : logs) {
            if (s.equals("../")) {
                if (i == 0) continue;
                i--;
            } else if (s.equals("./")) {
                continue;
            } else {
                i++;
            }
        }
        return i;
    }

    public int minOperations1(String[] logs) {
        int counter = 0;
        for (String s: logs) {
            if (s.equals("../")) {
                if (counter > 0) counter--;
            } else if (!s.equals("./")) {
                counter++;
            }
        }
        return counter;
    }
}
