package org.martin;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

class Twitter {
	private List<Integer> tweetsHis;
	private Dictionary<Integer, List<Integer>> tweets;
	private Dictionary<Integer, List<Integer>> follows;

	/** Initialize your data structure here. */
	public Twitter() {
		tweets = new Hashtable<Integer, List<Integer>>();
		follows = new Hashtable<Integer, List<Integer>>();
		tweetsHis = new ArrayList<Integer>();
	}

	/** Compose a new tweet. */
	public void postTweet(int userId, int tweetId) {
		tweetsHis.add(0, tweetId);

		List<Integer> ts = null;
		ts = tweets.get(userId);
		if (ts == null) {
			List<Integer> list = new ArrayList<Integer>();
			list.add(tweetId);
			tweets.put(userId, list);
		} else {
			ts.add(tweetId);
		}
	}

	/**
	 * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in
	 * the news feed must be posted by users who the user followed or by the user
	 * herself. Tweets must be ordered from most recent to least recent.
	 */
	public List<Integer> getNewsFeed(int userId) {
		List<Integer> result = new ArrayList();
		List<Integer> temp = new ArrayList<Integer>();
		List<Integer> followed = follows.get(userId);
		if (followed != null) {
			for (Integer integer : followed) {
				List<Integer> followedTweets = tweets.get(integer);
				if (followedTweets != null) {
					for (Integer integer2 : followedTweets) {
						temp.add(integer2);
					}
				}
			}
		}
		List<Integer> userTweets = tweets.get(userId);
		if(userTweets != null)
			temp.addAll(userTweets);
		int count = 0;
		for (Integer integer : tweetsHis) {
			if (temp.contains(integer)) {
				result.add(integer);
				count++;
			}
			if (count == 10) {
				break;
			}
		}
		return result;
	}

	/**
	 * Follower follows a followee. If the operation is invalid, it should be a
	 * no-op.
	 */
	public void follow(int followerId, int followeeId) {
		List<Integer> followed = follows.get(followerId);
		if (followed != null) {
			if (!followed.contains(followeeId))
				followed.add(followeeId);
		} else {
			followed = new ArrayList<Integer>();
			followed.add(followeeId);
			follows.put(followerId, followed);
		}
	}

	/**
	 * Follower unfollows a followee. If the operation is invalid, it should be a
	 * no-op.
	 */
	public void unfollow(int followerId, int followeeId) {
		List<Integer> followed = follows.get(followerId);
		if (followed != null) {
			if (followed.contains(followeeId)) {
				followed.remove(new Integer(followeeId));
			}
		}
	}
}

/**
 * Your Twitter object will be instantiated and called as such: Twitter obj =
 * new Twitter(); obj.postTweet(userId,tweetId); List<Integer> param_2 =
 * obj.getNewsFeed(userId); obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
