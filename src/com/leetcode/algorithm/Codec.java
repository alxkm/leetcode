package com.leetcode.algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Codec {
    private final String map = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private final int size = 7;
    private final Random rand = new Random();

    private final Map<String, String> urlToCode = new HashMap<>();
    private final Map<String, String> codeToUrl = new HashMap<>();

    private String code() {
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < size; i++) {
            code.append(map.charAt(rand.nextInt(Integer.MAX_VALUE) %  62));
        }
        return code.toString();
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (urlToCode.get(longUrl) != null) return urlToCode.get(longUrl);

        while (true) {
            String code = code();
            if (codeToUrl.get(code) == null) {
                codeToUrl.put(code, longUrl);
                return code;
            }
        }
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return codeToUrl.get(shortUrl);
    }

    public static void main(String[] args) {
        var sol = new Codec();
        String encode = sol.encode("https://leetcode.com/problems/design-tinyurl");
        System.out.println(encode);
        String decode = sol.decode(encode);
        System.out.println(decode);
    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        int answer = 0, n = nums.length;
        int[] cnt = new int[n + 1];
        for (int i = 0, m = 0, j = 0; j < n; ++j) {
            if (++cnt[nums[j]] == 1) {
                if (--k < 0) {
                    cnt[nums[m++]] = 0;
                    i = m;
                }
            }
            if (k <= 0) {
                while (cnt[nums[m]] > 1) {
                    --cnt[nums[m++]];
                }
                answer += m - i + 1;
            }
        }
        return answer;
    }
}

// Your com.leetcode.algorithm.Codec object will be instantiated and called as such:
// com.leetcode.algorithm.Codec codec = new com.leetcode.algorithm.Codec();
// codec.decode(codec.encode(url));