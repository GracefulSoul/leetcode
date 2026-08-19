package gracefulsoul.problems;

import java.util.HashMap;
import java.util.Map;

public class CinemaSeatAllocation {

	// https://leetcode.com/problems/cinema-seat-allocation/submissions/2112533096/
	public static void main(String[] args) {
		CinemaSeatAllocation test = new CinemaSeatAllocation();
		System.out.println(test.maxNumberOfFamilies(2, new int[][] {
			{ 2, 1 },
			{ 1, 8 },
			{ 2, 6 }
		}));
		System.out.println(test.maxNumberOfFamilies(4, new int[][] {
			{ 4, 3 },
			{ 1, 4 },
			{ 4, 6 },
			{ 1, 7 }
		}));
	}

	public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
		Map<Integer, Integer> reserved = new HashMap<>();
		for (int[] reservedSeat : reservedSeats) {
			int row = reservedSeat[0];
			int col = reservedSeat[1];
			if (col >= 2 && col <= 9) {
				reserved.put(row, reserved.getOrDefault(row, 0) | (1 << col));
			}
		}
		int result = 2 * (n - reserved.size());
		for (int value : reserved.values()) {
			boolean left = true;
			boolean mid = true;
			boolean right = true;
			for (int i = 2; i <= 5 && left; i++) {
				if ((value & (1 << i)) != 0) {
					left = false;
				}
			}
			for (int i = 4; i <= 7 && mid; i++) {
				if ((value & (1 << i)) != 0) {
					mid = false;
				}
			}
			for (int i = 6; i <= 9 && right; i++) {
				if ((value & (1 << i)) != 0) {
					right = false;
				}
			}
			if (left && right) {
				result += 2;
			} else if (left || mid || right) {
				result++;
			}
		}
		return result;
	}

}
