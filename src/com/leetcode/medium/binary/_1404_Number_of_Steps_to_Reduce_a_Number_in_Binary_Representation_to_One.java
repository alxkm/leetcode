package com.leetcode.medium.binary;

public class _1404_Number_of_Steps_to_Reduce_a_Number_in_Binary_Representation_to_One {
    //https://leetcode.com/problems/number-of-steps-to-reduce-a-number-in-binary-representation-to-one/description/
    //1404. Number of Steps to Reduce a Number in Binary Representation to One

    public int numSteps(String s) {
        if (s.length() == 1) return 0;

        int counter = 0;
        boolean complement = false;
        char[] ch = s.toCharArray();
        int i = s.toCharArray().length - 1;
        while (i >= 0) {
            if (i == 0) break;

            if (ch[i] == '1') {
                if (complement) {
                    counter++;
                } else {
                    counter += 2;
                }
                complement = true;
            } else {
                if (complement) {
                    ch[i] = '1';
                    complement = false;
                    continue;
                } else {
                    counter++;
                }
            }
            i--;
        }
        if (ch[i] == '1' && complement) {
            counter += 2;
        } else if (complement) {
            counter++;
        }

        if (s.length() >= 3) return counter - 1;

        return counter;
    }

    public static void main(String[] args) {
        var sol = new _1404_Number_of_Steps_to_Reduce_a_Number_in_Binary_Representation_to_One();
        System.out.println(sol.numSteps("1101"));
    }
}
