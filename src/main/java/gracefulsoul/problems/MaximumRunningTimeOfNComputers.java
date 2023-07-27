package gracefulsoul.problems;

public class MaximumRunningTimeOfNComputers {

	// https://leetcode.com/problems/maximum-running-time-of-n-computers/submissions/1005222842/
	public static void main(String[] args) {
		MaximumRunningTimeOfNComputers test = new MaximumRunningTimeOfNComputers();
		System.out.println(test.maxRunTime(2, new int[] { 3, 3, 3 }));
		System.out.println(test.maxRunTime(2, new int[] { 1, 1, 1, 1 }));
	}

	public long maxRunTime(int n, int[] batteries) {
		long sum = 0;
		for (int battery : batteries) {
			sum += battery;
		}
		long min = 1;
		long max = (sum / n) + 1;
		while (min < max) {
			long mid = min + ((max - min) / 2);
			sum = 0;
			for (int battery : batteries) {
				sum += Math.min(battery, mid);
			}
			if (sum >= mid * n) {
				min = mid + 1;
			} else {
				max = mid;
			}
		}
		return min - 1;
	}

}
