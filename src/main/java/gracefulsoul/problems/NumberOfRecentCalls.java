package gracefulsoul.problems;

import java.util.Deque;
import java.util.LinkedList;

public class NumberOfRecentCalls {

	// https://leetcode.com/problems/number-of-recent-calls/submissions/972543139/
	public static void main(String[] args) {
		RecentCounter recentCounter = new RecentCounter();
		System.out.println(recentCounter.ping(1));		// requests = [1], range is [-2999,1], return 1
		System.out.println(recentCounter.ping(100));	// requests = [1, 100], range is [-2900,100], return 2
		System.out.println(recentCounter.ping(3001));	// requests = [1, 100, 3001], range is [1,3001], return 3
		System.out.println(recentCounter.ping(3002));	// requests = [1, 100, 3001, 3002], range is [2,3002], return 3
	}

}

class RecentCounter {

	private Deque<Integer> time;

	public RecentCounter() {
		this.time = new LinkedList<>();
	}

	public int ping(int t) {
		this.time.addLast(t);
		while (this.time.getFirst() < t - 3000) {
			this.time.removeFirst();
		}
		return this.time.size();
	}

}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter(); int param_1 = obj.ping(t);
 */