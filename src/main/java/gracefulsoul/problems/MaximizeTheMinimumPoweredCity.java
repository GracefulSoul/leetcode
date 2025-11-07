package gracefulsoul.problems;

public class MaximizeTheMinimumPoweredCity {

	// https://leetcode.com/problems/maximize-the-minimum-powered-city/submissions/1823150070/
	public static void main(String[] args) {
		MaximizeTheMinimumPoweredCity test = new MaximizeTheMinimumPoweredCity();
		System.out.println(test.maxPower(new int[] { 1, 2, 4, 5, 0 }, 1, 2));
		System.out.println(test.maxPower(new int[] { 4, 4, 4, 4 }, 0, 3));
	}

	public long maxPower(int[] stations, int r, int k) {
		int length = stations.length;
		long left = 0;
		long right = k;
		for (int station : stations) {
			right += station;
		}
		long[] values = new long[length];
		while (left <= right) {
			long x = (left + right) / 2;
			for (int i = 0; i < length; i++) {
				values[i] = stations[i];
			}
			long sum = 0;
			long temp = 0;
			for (int i = 0; i < r; i++) {
				sum += values[i];
			}
			for (int i = 0; i < length; i++) {
				if (i + r < length) {
					sum += values[i + r];
				}
				if (i - r > 0) {
					sum -= values[i - r - 1];
				}
				long diff = Math.max(0, x - sum);
				values[Math.min(length - 1, i + r)] += diff;
				sum += diff;
				temp += diff;
			}
			if (temp <= k) {
				left = x + 1;
			} else {
				right = x - 1;
			}
		}
		return right;
	}

}
