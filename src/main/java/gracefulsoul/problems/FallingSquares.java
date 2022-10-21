package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FallingSquares {

	// https://leetcode.com/submissions/detail/827625068/
	public static void main(String[] args) {
		FallingSquares test = new FallingSquares();
		System.out.println(test.fallingSquares(new int[][] {
			{ 1, 2 },
			{ 2, 3 },
			{ 6, 1 }
		}));
		System.out.println(test.fallingSquares(new int[][] {
			{ 100, 100 },
			{ 200, 100 }
		}));
	}

	public List<Integer> fallingSquares(int[][] positions) {
		int length = positions.length;
		int[] rights = new int[length * 2];
		for (int idx = 0; idx < length; idx++) {
			rights[idx * 2] = positions[idx][0];
			rights[(idx * 2) + 1] = positions[idx][0] + positions[idx][1];
		}
		Arrays.sort(rights);
		int[] ceilings = new int[rights.length - 1];
		int max = 0;
		ArrayList<Integer> result = new ArrayList<>();
		for (int[] position : positions) {
			int curr = position[0];
			int x = Arrays.binarySearch(rights, curr);
			if (x >= 0) {
				int maxCeiling = 0;
				int y = curr + position[1];
				for (int idx = x; rights[idx] < y; idx++) {
					maxCeiling = Math.max(maxCeiling, ceilings[idx]);
				}
				maxCeiling += y - curr;
				for (int idx = x; rights[idx] < y; idx++) {
					ceilings[idx] = maxCeiling;
				}
				max = Math.max(max, maxCeiling);
				result.add(max);
			}
		}
		return result;
	}

}
