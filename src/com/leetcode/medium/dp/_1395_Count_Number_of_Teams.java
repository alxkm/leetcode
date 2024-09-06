package com.leetcode.medium.dp;

public class _1395_Count_Number_of_Teams {
    //1395. Count Number of Teams
    //https://leetcode.com/problems/count-number-of-teams/description/?envType=daily-question&envId=2024-07-29
    //todo

    class Solution1 {
        public int numTeams(int[] rating) {
            int counter = 0;
            for (int i = 0; i < rating.length; i++) {
                for (int j = i + 1; j < rating.length; j++) {
                    if (!(rating[i] < rating[j]) && !(rating[i] > rating[j])) continue;
                    for (int k = j + 1; k < rating.length; k++) {
                        if ((rating[i] < rating[j] && rating[j] < rating[k]) || (rating[i] > rating[j] && rating[j] > rating[k])) counter++;
                    }
                }
            }
            return counter;
        }
    }


    class Solution {

        public int numTeams(int[] rating) {
            int n = rating.length;
            int teams = 0;

            // Tables for increasing and decreasing sequences
            int[][] increasingTeams = new int[n][4];
            int[][] decreasingTeams = new int[n][4];

            // Fill the base cases. (Each soldier is a sequence of length 1)
            for (int i = 0; i < n; i++) {
                increasingTeams[i][1] = 1;
                decreasingTeams[i][1] = 1;
            }

            // Fill the tables
            for (int count = 2; count <= 3; count++) {
                for (int i = 0; i < n; i++) {
                    for (int j = i + 1; j < n; j++) {
                        if (rating[j] > rating[i]) {
                            increasingTeams[j][count] +=
                                    increasingTeams[i][count - 1];
                        }
                        if (rating[j] < rating[i]) {
                            decreasingTeams[j][count] +=
                                    decreasingTeams[i][count - 1];
                        }
                    }
                }
            }

            // Sum up the results (All sequences of length 3)
            for (int i = 0; i < n; i++) {
                teams += increasingTeams[i][3] + decreasingTeams[i][3];
            }

            return teams;
        }
    }
}
