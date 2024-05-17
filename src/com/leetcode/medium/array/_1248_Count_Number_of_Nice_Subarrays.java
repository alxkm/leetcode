package com.leetcode.medium.array;


import com.leetcode.ArrayUtil;

public class _1248_Count_Number_of_Nice_Subarrays {
    //1248. Count Number of Nice Subarrays
    //https://leetcode.com/problems/count-number-of-nice-subarrays/
    //https://leetcode.com/problems/binary-subarrays-with-sum/

    public int numberOfSubarrays(int[] nums, int k) {
        return find(nums, k) - find(nums, k - 1);
    }

    public int find(int[] nums, int k) {
        int l = 0, r = 0, sum = 0, cnt = 0;
        while (r < nums.length) {
            sum += ((nums[r] % 2 == 0) ? 0 : 1);

            while (sum > k) {
                sum = sum - ((nums[l] % 2 == 0) ? 0 : 1);
                l++;
            }
            cnt += (r - l + 1);
            r++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        var sol = new _1248_Count_Number_of_Nice_Subarrays();
        //System.out.println(sol.numberOfSubarrays(ArrayUtil.of(2,2,2,1,2,2,1,2,2,2), 2));
        System.out.println(sol.numberOfSubarrays(ArrayUtil.of(2044,96397,50143), 1));
    }
}
