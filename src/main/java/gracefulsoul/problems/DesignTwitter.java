package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/submissions/detail/627977322/
public class DesignTwitter {

	public static void main(String[] args) {
		Twitter twitter = new Twitter();
		twitter.postTweet(1, 5); 					 // User 1 posts a new tweet (id = 5).
		System.out.println(twitter.getNewsFeed(1));  // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]
		twitter.follow(1, 2);    					 // User 1 follows user 2.
		twitter.postTweet(2, 6); 					 // User 2 posts a new tweet (id = 6).
		System.out.println(twitter.getNewsFeed(1));  // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
		twitter.unfollow(1, 2);  					 // User 1 unfollows user 2.
		System.out.println(twitter.getNewsFeed(1));  // User 1's news feed should return a list with 1 tweet id -> [5], since user 1 is no longer following user 2.
	}

}

class Twitter {

	private List<Integer[]> posts;
	private Map<Integer, Set<Integer>> relation;

	public Twitter() {
		this.posts = new ArrayList<>();
		this.relation = new HashMap<>();
	}

	public void postTweet(int userId, int tweetId) {
		this.posts.add(new Integer[] {userId, tweetId});
	}

	public List<Integer> getNewsFeed(int userId) {
		List<Integer> newsFeed = new ArrayList<>();
		for (int idx = this.posts.size() - 1; idx >= 0 && newsFeed.size() < 10; idx--) {
			Integer[] post = this.posts.get(idx);
			Set<Integer> followees = this.relation.get(userId);
			if (post[0] == userId || (followees != null && followees.contains(post[0]))) {
				newsFeed.add(post[1]);
			}
		}
		return newsFeed;
	}

	public void follow(int followerId, int followeeId) {
		Set<Integer> followees = this.relation.get(followerId);
		if (followees == null) {
			followees = new HashSet<>();
		}
		this.relation.put(followerId, followees);
		followees.add(followeeId);
	}

	public void unfollow(int followerId, int followeeId) {
		Set<Integer> followees = this.relation.get(followerId);
		if (followees != null) {
			followees.remove(followeeId);
		}
	}

}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */