package org.martin;

public class TestTwitter implements ITest{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Twitter twitter = new Twitter();
		twitter.postTweet(1, 1);
		twitter.getNewsFeed(1);
		twitter.follow(2, 1);
		twitter.getNewsFeed(2);
		twitter.unfollow(2, 1);
		twitter.getNewsFeed(2);
	}
}
