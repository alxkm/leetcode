package com.leetcode.medium.design;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

public class _355_Design_Twitter {
    //https://leetcode.com/problems/design-twitter/
    //TOP

    static class Twitter {
        private final Map<Integer, List<int[]>> tweets = new HashMap<>();
        private final Map<Integer, Set<Integer>> followers = new HashMap<>();
        private int counter = 0;

        public Twitter() {
        }

        public void postTweet(int userId, int tweetId) {
            var userTweets = tweets.getOrDefault(userId, new LinkedList<>());
            userTweets.add(new int[]{tweetId, counter++});
            tweets.put(userId, userTweets);
        }

        public List<Integer> getNewsFeed(int userId) {
            PriorityQueue<int[]> q = new PriorityQueue<>((x, y) -> y[1] - x[1]);

            Set<Integer> followeeIds = followers.get(userId);
            if (followeeIds != null) {
                for (Integer followeeId : followeeIds) {
                    List<int[]> followeeTweets = tweets.get(followeeId);
                    if (followeeTweets != null) {
                        q.addAll(followeeTweets);
                    }
                }
            }

            List<int[]> ownTweets = tweets.get(userId);
            if (ownTweets != null) {
                q.addAll(ownTweets);
            }

            List<Integer> resultTweets = new ArrayList<>();
            for (int i = 0; i < 10 && q.size() >= 1; i++) {
                resultTweets.add(q.poll()[0]);
            }
            return resultTweets;
        }

        public void follow(int followerId, int followeeId) {
            var userFollowers = followers.getOrDefault(followerId, new HashSet<>());
            userFollowers.add(followeeId);
            followers.put(followerId, userFollowers);
        }

        public void unfollow(int followerId, int followeeId) {
            var userFollowers = followers.getOrDefault(followerId, new HashSet<>());
            userFollowers.remove(followeeId);
            followers.put(followerId, userFollowers);
        }
    }

    static class Twitter2 {
        private Map<Integer, Set<Integer>> userToTweetMap = new HashMap<>();
        private Map<Integer, Set<Integer>> followerToUserMap = new HashMap<>();
        private int counter = 0;
        private Map<Integer, Integer> tweetTimeMap = new HashMap<>();

        public Twitter2() {

        }

        public void postTweet(int userId, int tweetId) {
            var set = userToTweetMap.getOrDefault(userId, new HashSet<>());
            set.add(tweetId);
            userToTweetMap.put(userId, set);
            tweetTimeMap.put(tweetId, counter++);
        }

        public List<Integer> getNewsFeed(int userId) {
            Set<Integer> set = new HashSet<>();
            var userFollowes = followerToUserMap.getOrDefault(userId, new HashSet<>());
            for (var id: userFollowes) {
                if (userToTweetMap.get(id) != null) {
                    set.addAll(userToTweetMap.get(id));
                }
            }
            if (userToTweetMap.get(userId) != null) {
                set.addAll(userToTweetMap.get(userId));
            }
            int[][] list = new int[set.size()][2];
            int i = 0;
            for (int tw: set) {
                list[i] = new int[] {tw, tweetTimeMap.get(tw)};
                i++;
            }
            Arrays.sort(list, (x, y) -> y[1] - x[1]);

            List<Integer> l = new ArrayList<>();
            for (int[] a: list) {
                l.add(a[0]);
                if (l.size() == 10) {
                    break;
                }
            }
            return l;
        }

        public void follow(int followerId, int followeeId) {
            var set = followerToUserMap.getOrDefault(followerId, new HashSet<>());
            set.add(followeeId);
            followerToUserMap.put(followerId, set);
        }

        public void unfollow(int followerId, int followeeId) {
            var set = followerToUserMap.getOrDefault(followerId, new HashSet<>());
            set.remove(followeeId);
            followerToUserMap.put(followerId, set);
        }
    }

    static class Twitter3 {
        private Map<Integer, List<int[]>> tweets = new HashMap<>();
        private Map<Integer, Set<Integer>> followers = new HashMap<>();
        private int counter = 0;

        public Twitter3() {

        }

        public void postTweet(int userId, int tweetId) {
            var userTweets = tweets.getOrDefault(userId, new ArrayList<>());
            userTweets.add(new int[]{tweetId, counter++});
            tweets.put(userId, userTweets);
        }

        public List<Integer> getNewsFeed(int userId) {
            List<int[]> allTweets = new ArrayList<>();
            var userFollowes = followers.getOrDefault(userId, new HashSet<>());
            for (var id: userFollowes) {
                List<int[]> userTweets = tweets.get(id);
                if (userTweets != null) {
                    allTweets.addAll(userTweets);
                }
            }
            List<int[]> ownTweets = tweets.get(userId);
            if (ownTweets != null) {
                allTweets.addAll(ownTweets);
            }
            allTweets.sort((x, y) -> y[1] - x[1]);
            return allTweets.stream().map(s -> s[0]).limit(10).collect(Collectors.toList());
        }

        public void follow(int followerId, int followeeId) {
            var userFollowes = followers.getOrDefault(followerId, new HashSet<>());
            userFollowes.add(followeeId);
            followers.put(followerId, userFollowes);
        }

        public void unfollow(int followerId, int followeeId) {
            var userFollowes = followers.getOrDefault(followerId, new HashSet<>());
            userFollowes.remove(followeeId);
            followers.put(followerId, userFollowes);
        }
    }
    public static void main(String[] args) {
        var t = new Twitter();
        /**
            ["Twitter","postTweet","getNewsFeed","follow","postTweet","getNewsFeed","unfollow","getNewsFeed"]
            [[],[1,5],[1],[1,2],[2,6],[1],[1,2],[1]]
        * */

        t.postTweet(1, 5);
        t.getNewsFeed(1);
        t.follow(1, 2);
        t.postTweet(2, 6);
        t.getNewsFeed(1);
        t.unfollow(1, 2);
        t.getNewsFeed(1);

        /**
            ["Twitter","postTweet","getNewsFeed","follow","getNewsFeed","unfollow","getNewsFeed"]
            [[],[1,1],[1],[2,1],[2],[2,1],[2]]
        * */
       // t.postTweet(1,1);
  //      t.follow(1,5);
  //      t.getNewsFeed(1);
//        t.postTweet(2,4);
//
//        t.postTweet(1,2);
//        t.postTweet(2,5);
//
//        t.postTweet(1,3);
//
//        t.postTweet(2,6);
//
//        t.follow(2, 1);
//
//        t.getNewsFeed(2);
//        t.follow(1, 2);
//        t.getNewsFeed(1);
//        t.getNewsFeed(1);


    }
}
