package gracefulsoul.problems;

public class MinimumTimeToRepairCars {

	// https://leetcode.com/problems/minimum-time-to-repair-cars/submissions/1575304350/
	public static void main(String[] args) {
		MinimumTimeToRepairCars test = new MinimumTimeToRepairCars();
		System.out.println(test.repairCars(new int[] { 4, 2, 3, 1 }, 10));
		System.out.println(test.repairCars(new int[] { 5, 1, 8 }, 6));
	}

	public long repairCars(int[] ranks, int cars) {
		int min = ranks[0];
		int[] counts = new int[101];
		for (int rank : ranks) {
			min = Math.min(min, rank);
			counts[rank]++;
		}
		long left = 1;
		long right = 1L * min * cars * cars;
		while (left < right) {
			long mid = (left + right) / 2;
			long curr = 0;
			for (int i = 1; i < 101; i++) {
				curr += counts[i] * Math.sqrt(1.0 * mid / i);
			}
			if (curr < cars) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return left;
	}

}
