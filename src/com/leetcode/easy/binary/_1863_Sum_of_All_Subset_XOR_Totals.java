package com.leetcode.easy.binary;

import com.leetcode.ArrayUtil;

import java.util.Stack;

public class _1863_Sum_of_All_Subset_XOR_Totals {
    //1863. Sum of All Subset XOR Totals
    //https://leetcode.com/problems/sum-of-all-subset-xor-totals/description/

    int[] nums;
    int sum = 0;

    public int subsetXORSum(int[] nums) {
        this.nums = nums;
        f(0, new Stack<>());
        return sum;
    }

    private void f(int i, Stack<Integer> st) {
        if (i == nums.length) {
            if (st.size() == 0) return;
            int prev = st.get(0);
            for (int i1 = 1; i1 < st.size(); i1++) {
                prev = prev ^ st.get(i1);
            }
            sum += prev;
            return;
        }
        st.add(nums[i]);
        f(i + 1, st);
        st.pop();
        f(i + 1, st);
    }

    /*

    public int subsetXORSum(int[] nums) {
        return helper(nums , 0 , 0);
    }

    public int helper(int[] nums, int index, int currValue){
        if(index == nums.length) return currValue;

        return helper(nums, index+1, currValue^nums[index]) + helper(nums, index+1, currValue);
    }

    */

    public static void main(String[] args) {
        //1,3
        var sol = new _1863_Sum_of_All_Subset_XOR_Totals();
        System.out.println(sol.subsetXORSum(ArrayUtil.of(1, 3)));
    }

}
