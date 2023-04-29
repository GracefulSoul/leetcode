package gracefulsoul.problems;

import java.util.Arrays;

public class OnlineElection {

	// https://leetcode.com/problems/online-election/submissions/941341312/
	public static void main(String[] args) {
		TopVotedCandidate topVotedCandidate = new TopVotedCandidate(new int[] { 0, 1, 1, 0, 0, 1, 0 }, new int[] { 0, 5, 10, 15, 20, 25, 30 });
		System.out.println(topVotedCandidate.q(3));		// return 0, At time 3, the votes are [0], and 0 is leading.
		System.out.println(topVotedCandidate.q(12));	// return 1, At time 12, the votes are [0,1,1], and 1 is leading.
		System.out.println(topVotedCandidate.q(25));	// return 1, At time 25, the votes are [0,1,1,0,0,1], and 1 is leading (as ties go to the most recent vote.)
		System.out.println(topVotedCandidate.q(15));	// return 0
		System.out.println(topVotedCandidate.q(24));	// return 0
		System.out.println(topVotedCandidate.q(8));		// return 1
	}

}

class TopVotedCandidate {

	private int[] lead;
	private int[] times;

	public TopVotedCandidate(int[] persons, int[] times) {
		int length = persons.length;
		int[] votes = new int[length];
		this.lead = new int[length];
		this.times = times;
		int max = 0;
		for (int i = 0; i < length; i++) {
			int person = persons[i];
			votes[person]++;
			if (votes[person] >= max) {
				max = votes[person];
				this.lead[i] = person;
			} else {
				this.lead[i] = this.lead[i - 1];
			}
		}
	}

	public int q(int t) {
		int num = Arrays.binarySearch(this.times, t);
		if (num < 0) {
			num = -num - 2;
		}
		return this.lead[num];
	}

}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */