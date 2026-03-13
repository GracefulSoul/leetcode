package gracefulsoul.problems;

public class MinimumNumberOfSecondsToMakeMountainHeightZero {

	// https://leetcode.com/problems/minimum-number-of-seconds-to-make-mountain-height-zero/submissions/1946884601/
	public static void main(String[] args) {
		MinimumNumberOfSecondsToMakeMountainHeightZero test = new MinimumNumberOfSecondsToMakeMountainHeightZero();
		System.out.println(test.minNumberOfSeconds(4, new int[] { 2, 1, 1 }));
		System.out.println(test.minNumberOfSeconds(10, new int[] { 3, 2, 2, 4 }));
		System.out.println(test.minNumberOfSeconds(5, new int[] { 1 }));
	}

	public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
		long low = 1;
		long high = (long) 1e18;
		while (low < high) {
			long mid = (low + high) >> 1;
			long total = 0;
			for (int i = 0; i < workerTimes.length && total < mountainHeight; i++) {
				total += (long) (Math.sqrt((((double) mid / workerTimes[i]) * 2) + 0.25) - 0.5);
			}
			if (mountainHeight <= total) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		return low;
	}

}
