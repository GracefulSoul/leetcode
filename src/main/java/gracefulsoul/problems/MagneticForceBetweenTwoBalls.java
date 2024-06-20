package gracefulsoul.problems;

import java.util.Arrays;

public class MagneticForceBetweenTwoBalls {

	// https://leetcode.com/problems/magnetic-force-between-two-balls/submissions/1294584201/
	public static void main(String[] args) {
		MagneticForceBetweenTwoBalls test = new MagneticForceBetweenTwoBalls();
		System.out.println(test.maxDistance(new int[] { 1, 2, 3, 4, 7 }, 3));
		System.out.println(test.maxDistance(new int[] { 5, 4, 3, 2, 1, 1000000000 }, 2));
	}

	public int maxDistance(int[] position, int m) {
		Arrays.sort(position);
		int left = 0;
		int right = position[position.length - 1];
		int result = 0;
		while (left < right) {
			int mid = left + (right - left) / 2;
			if (this.isPossible(position, m, mid)) {
				result = mid;
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return result;
	}

	private boolean isPossible(int[] positions, int m, int max) {
		int count = 1;
		int prev = positions[0];
		for (int i = 1; i < positions.length; i++) {
			if (positions[i] - prev >= max) {
				prev = positions[i];
				count++;
			}
		}
		return count >= m;
	}

}
