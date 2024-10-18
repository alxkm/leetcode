package com.leetcode.medium.sort;

import java.util.Arrays;

public class _2491_Divide_Players_Into_Teams_of_Equal_Skill {
    //2491. Divide Players Into Teams of Equal Skill
    //https://leetcode.com/problems/divide-players-into-teams-of-equal-skill/description/

    public long dividePlayers(int[] skill) {
        int totalSum = 0;
        if (skill.length == 2) return skill[0] * skill[1];
        for (int n: skill) totalSum += n;
        Arrays.sort(skill);
        long product = 0l;
        int section = skill[0] + skill[skill.length - 1];
        for (int i = 0, j = skill.length - 1; i < j; i++, j--) {
            if (section != skill[i] + skill[j]) {
                return -1;
            }
            product += skill[i] * skill[j];
        }
        return product;
    }
}
