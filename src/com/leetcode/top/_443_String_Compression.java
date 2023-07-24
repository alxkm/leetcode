package com.leetcode.top;

public class _443_String_Compression {
    //443. String Compression
    //https://leetcode.com/problems/string-compression/

    public int compress(char[] chars) {
        if (chars.length == 1) return 1;
        char prev = chars[0];
        StringBuilder sb = new StringBuilder();
        int counter = 1;
        for (int i = 1; i < chars.length; i++) {
            if (prev != chars[i]) {
                sb.append(prev);
                if (counter > 1)
                    sb.append(counter);
                prev = chars[i];
                counter = 1;
            } else {
                counter++;
            }
            if (i == chars.length - 1) {
                sb.append(prev);
                if (counter > 1)
                    sb.append(counter);
                //.append(counter);
            }
            chars[i] = '0';
        }
        int i = 0;
        for (char ch: sb.toString().toCharArray()) {
            chars[i] = ch;
            i++;
        }

        //System.out.println(sb.toString());
        return sb.toString().length();
    }
}
