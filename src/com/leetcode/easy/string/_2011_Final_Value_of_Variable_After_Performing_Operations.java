package com.company.string;

public class _2011_Final_Value_of_Variable_After_Performing_Operations {
    public int finalValueAfterOperations(String[] operations) {
        int r = 0;
        for (String o : operations) {
            if (o.equals("++X") || o.equals("X++")) {
                r++;
            } else if (o.equals("--X") || o.equals("X--")) {
                r--;
            }
        }
        return r;
    }
}
