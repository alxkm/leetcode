package com.company.string;

public class _2129_Capitalize_the_Title {
    public String capitalizeTitle(String title) {
        String[] strings = title.toLowerCase().split(" ");
        StringBuilder sb = null;
        for (String s : strings) {
            String str = s;
            if (s.length() > 2 )
                str = s.substring(0, 1).toUpperCase() + s.substring(1);
            if (sb == null) {
                sb = new StringBuilder();
                sb.append(str);
            } else {
                sb.append(" ");
                sb.append(str);
            }
        }


        return sb.toString();
    }
}
