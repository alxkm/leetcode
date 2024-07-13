package com.leetcode.hard;

import com.leetcode.ArrayUtil;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class _2751_Robot_Collisions {
    //https://leetcode.com/problems/robot-collisions/description/?envType=daily-question&envId=2024-07-13
    //2751. Robot Collisions

    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String d) {
        Stack<Integer> st = new Stack<>();
        int n = positions.length;
        int[][] robot = new int[n][2];

        for (int i = 0; i < n; i++) {
            robot[i][0] = i;
            robot[i][1] = positions[i];
        }

        Arrays.sort(robot, (x, y) -> x[1] - y[1]);

        char[] directions = d.toCharArray();
        for (int j = 0; j < n; ) {
            int i = robot[j][0];
            if (st.isEmpty() || directions[st.peek()] == directions[i]) {
                st.push(i);
                j++;
                continue;
            }

            int prevRobot = st.pop();
            if (directions[prevRobot] == 'L' && directions[i] == 'R') {
                st.push(prevRobot);
                st.push(i);
                j++;
                continue;
            }

            if (healths[prevRobot] == healths[i]) {
                healths[prevRobot] = 0;
                healths[i] = 0;
            } else if (healths[prevRobot] > healths[i]) {
                healths[prevRobot]--;
                healths[i] = 0;
                st.push(prevRobot);
            } else if (healths[prevRobot] < healths[i]) {
                healths[i]--;
                healths[prevRobot] = 0;

                if (st.isEmpty()) {
                    st.push(i);
                    j++;
                    continue;
                }

                while (!st.isEmpty() && healths[i] > 0) {
                    if (directions[st.peek()] == directions[i]) {
                        st.push(i);
                        break;
                    }
                    if (directions[st.peek()] == 'R' && directions[i] == 'L') {
                        int prev = st.pop();
                        if (healths[prev] == healths[i]) {
                            healths[i] = 0;
                            healths[prev] = 0;
                            break;
                        }
                        if (healths[prev] > healths[i]) {
                            healths[prev]--;
                            st.push(prev);
                            healths[i] = 0;
                            break;
                        }
                        if (healths[prev] < healths[i]) {
                            healths[i]--;
                            healths[prev] = 0;
                        }
                    } else {
                        st.push(i);
                        break;
                    }
                }
            }
            j++;
        }
        return Arrays.stream(healths).filter(s -> s > 0).boxed().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        var sol = new _2751_Robot_Collisions();
        System.out.println(sol.survivedRobotsHealths(ArrayUtil.of(11,44,16), ArrayUtil.of(1,20,17), "RLR"));
        System.out.println(sol.survivedRobotsHealths(ArrayUtil.of(3, 5, 2, 6), ArrayUtil.of(10, 10, 15, 12), "RLRL"));
    }
}
