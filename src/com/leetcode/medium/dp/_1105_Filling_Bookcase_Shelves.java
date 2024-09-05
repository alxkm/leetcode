package com.leetcode.medium.dp;

public class  _1105_Filling_Bookcase_Shelves {
    //1105. Filling Bookcase Shelves
    //https://leetcode.com/problems/filling-bookcase-shelves/description/

    public int minHeightShelves(int[][] books, int shelfWidth) {
        // Cache to store previous computations
        int[][] memo = new int[books.length][shelfWidth + 1];
        return dpHelper(books, shelfWidth, memo, 0, shelfWidth, 0);
    }

    private int dpHelper(
            int[][] books,
            int shelfWidth,
            int[][] memo,
            int i,
            int remainingShelfWidth,
            int maxHeight
    ) {
        int[] currentBook = books[i];
        int maxHeightUpdated = Math.max(maxHeight, currentBook[1]);
        if (i == books.length - 1) {
            // For the last book, store it in the current shelf if possible,
            // or start a new shelf with it
            if (remainingShelfWidth >= currentBook[0]) return maxHeightUpdated;
            return maxHeight + currentBook[1];
        }
        // Return answer if already computed
        if (memo[i][remainingShelfWidth] != 0) {
            return memo[i][remainingShelfWidth];
        } else {
            // Calculate the height of the bookcase if we put the current book on the new shelf
            int option1Height =
                    maxHeight +
                            dpHelper(
                                    books,
                                    shelfWidth,
                                    memo,
                                    i + 1,
                                    shelfWidth - currentBook[0],
                                    currentBook[1]
                            );
            if (remainingShelfWidth >= currentBook[0]) {
                // Calculate height of the bookcase if we put the current book on the current shelf
                int option2Height = dpHelper(
                        books,
                        shelfWidth,
                        memo,
                        i + 1,
                        remainingShelfWidth - currentBook[0],
                        maxHeightUpdated
                );
                // Store result in cache
                memo[i][remainingShelfWidth] = Math.min(
                        option1Height,
                        option2Height
                );
                return memo[i][remainingShelfWidth];
            }
            // Store result in cache
            memo[i][remainingShelfWidth] = option1Height;
            return memo[i][remainingShelfWidth];
        }
    }
}
