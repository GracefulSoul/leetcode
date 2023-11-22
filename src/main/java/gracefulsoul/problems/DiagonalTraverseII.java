package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import gracefulsoul.util.PrintUtil;

public class DiagonalTraverseII {

	// https://leetcode.com/problems/diagonal-traverse-ii/submissions/1104084398/
	public static void main(String[] args) {
		DiagonalTraverseII test = new DiagonalTraverseII();
		PrintUtil.print(test.findDiagonalOrder(Arrays.asList(
			Arrays.asList(1, 2, 3),
			Arrays.asList(4, 5, 6),
			Arrays.asList(7, 8, 9)
		)));
		PrintUtil.print(test.findDiagonalOrder(Arrays.asList(
			Arrays.asList(1, 2, 3, 4, 5),
			Arrays.asList(6, 7),
			Arrays.asList(8),
			Arrays.asList(9, 10, 11),
			Arrays.asList(12, 13, 14, 15, 16)
		)));
	}

	@SuppressWarnings("unchecked")
	public int[] findDiagonalOrder(List<List<Integer>> nums) {
		int max = 0;
		int length = 0;
		int index = 0;
		List<Integer>[] map = new ArrayList[100001];
		for (int i = 0; i < nums.size(); i++) {
			List<Integer> list = nums.get(i);
			int size = list.size();
			length += size;
			for (int j = 0; j < size; j++) {
				int sum = i + j;
				if (map[sum] == null) {
					map[sum] = new ArrayList<>();
				}
				map[sum].add(list.get(j));
				max = Math.max(max, sum);
			}
		}
		int[] result = new int[length];
		for (int i = 0; i <= max; i++) {
			List<Integer> curr = map[i];
			for (int j = curr.size() - 1; j >= 0; j--) {
				result[index++] = curr.get(j);
			}
		}
		return result;
	}

}
