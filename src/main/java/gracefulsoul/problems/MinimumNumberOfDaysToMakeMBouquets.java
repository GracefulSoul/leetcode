package gracefulsoul.problems;

public class MinimumNumberOfDaysToMakeMBouquets {

	// https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/submissions/1293321614/
	public static void main(String[] args) {
		MinimumNumberOfDaysToMakeMBouquets test = new MinimumNumberOfDaysToMakeMBouquets();
		System.out.println(test.minDays(new int[] { 1, 10, 3, 10, 2 }, 3, 1));
		System.out.println(test.minDays(new int[] { 1, 10, 3, 10, 2 }, 3, 2));
		System.out.println(test.minDays(new int[] { 7, 7, 7, 7, 12, 7, 7 }, 2, 3));
	}

	public int minDays(int[] bloomDay, int m, int k) {
		if ((long) m * k > bloomDay.length) {
			return -1;
		}
		int left = 1;
		int right = (int) 1e9;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (this.isPossibleMakeBouquets(bloomDay, m, k, mid)) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}

	private boolean isPossibleMakeBouquets(int[] bloomDay, int m, int k, int day) {
		int total = 0;
		int length = bloomDay.length;
		for (int i = 0; i < length; i++) {
			int count = 0;
			while (i < length && count < k && bloomDay[i] <= day) {
				count++;
				i++;
			}
			if (count == k) {
				total++;
				i--;
			}
			if (total >= m) {
				return true;
			}
		}
		return false;
	}

}
