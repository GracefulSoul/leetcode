package gracefulsoul.problems;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumProfitInJobScheduling {

	// https://leetcode.com/problems/maximum-profit-in-job-scheduling/submissions/1138119137/
	public static void main(String[] args) {
		MaximumProfitInJobScheduling test = new MaximumProfitInJobScheduling();
		System.out.println(test.jobScheduling(new int[] { 1, 2, 3, 4, 6 }, new int[] { 3, 5, 10, 6, 9 }, new int[] { 20, 20, 100, 70, 60 }));
		System.out.println(test.jobScheduling(new int[] { 1, 1, 1 }, new int[] { 2, 3, 4 }, new int[] { 5, 6, 4 }));
	}

	public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
		int length = startTime.length;
		Job[] jobs = new Job[length];
		for (int i = 0; i < length; i++) {
			jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
		}
		Arrays.sort(jobs, Comparator.comparingInt(a -> a.end));
		return this.jobScheduling(jobs, new int[length]);
	}

	private int jobScheduling(Job[] jobs, int[] dp) {
		int length = jobs.length;
		dp[0] = jobs[0].profit;
		for (int i = 1; i < length; i++) {
			int profit = jobs[i].profit;
			int index = this.search(jobs, i);
			if (index != -1) {
				profit += dp[index];
			}
			dp[i] = Math.max(profit, dp[i - 1]);
		}
		return dp[length - 1];
	}

	private int search(Job[] jobs, int index) {
		int start = 0, end = index - 1;
		while (start <= end) {
			int mid = start + ((end - start) / 2);
			if (jobs[index].start >= jobs[mid + 1].end) {
				start = mid + 1;
			} else if (jobs[index].start >= jobs[mid].end) {
				return mid;
			} else {
				end = mid - 1;
			}
		}
		return -1;
	}

}

class Job {

	int start;
	int end;
	int profit;

	public Job(int start, int end, int profit) {
		this.start = start;
		this.end = end;
		this.profit = profit;
	}

}