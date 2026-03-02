package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class MinimumSwapsToArrangeABinaryGrid {

	// https://leetcode.com/problems/minimum-swaps-to-arrange-a-binary-grid/submissions/1935400545/
	public static void main(String[] args) {
		MinimumSwapsToArrangeABinaryGrid test = new MinimumSwapsToArrangeABinaryGrid();
		System.out.println(test.minSwaps(new int[][] {
			{ 0, 0, 1 },
			{ 1, 1, 0 },
			{ 1, 0, 0 }
		}));
		System.out.println(test.minSwaps(new int[][] {
			{ 0, 1, 1, 0 },
			{ 0, 1, 1, 0 },
			{ 0, 1, 1, 0 },
			{ 0, 1, 1, 0 }
		}));
		System.out.println(test.minSwaps(new int[][] {
			{ 1, 0, 0 },
			{ 1, 1, 0 },
			{ 1, 1, 1 }
		}));
	}

	public int minSwaps(int[][] grid) {
		int length = grid.length;
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < length; i++) {
			int count = 0;
			for (int j = length - 1; j > -1 && grid[i][j] == 0; j--) {
				count++;
			}
			list.add(count);
		}
		int result = 0;
		for (int i = 0, j = length - 1; i < length; i++, j--) {
			int curr = i;
			while (curr < length && list.get(curr) < j) {
				curr++;
			}
			if (curr == length) {
				return -1;
			}
			int remove = list.remove(curr);
			list.add(i, remove);
			result += curr - i;
		}
		return result;
	}

}
