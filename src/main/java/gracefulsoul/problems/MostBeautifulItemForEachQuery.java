package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;
import java.util.Arrays;

public class MostBeautifulItemForEachQuery {

	// https://leetcode.com/problems/most-beautiful-item-for-each-query/submissions/1451040922/
	public static void main(String[] args) {
		MostBeautifulItemForEachQuery test = new MostBeautifulItemForEachQuery();
		PrintUtil.print(test.maximumBeauty(new int[][] {
			{ 1, 2 },
			{ 3, 2 },
			{ 2, 4 },
			{ 5, 6 },
			{ 3, 5 }
		}, new int[] { 1, 2, 3, 4, 5, 6 }));
		PrintUtil.print(test.maximumBeauty(new int[][] {
			{ 1, 2 },
			{ 3, 2 },
			{ 2, 4 },
			{ 5, 6 },
			{ 3, 5 }
		}, new int[] { 1, 2, 3, 4, 5, 6 }));
		PrintUtil.print(test.maximumBeauty(new int[][] {
				{ 10, 10000 }
		}, new int[] { 5 }));
	}

	public int[] maximumBeauty(int[][] items, int[] queries) {
		int[] result = new int[queries.length];
		Arrays.sort(items, (a, b) -> (a[0] - b[0]));
		for (int i = 1; i < items.length; i++) {
			items[i][1] = Math.max(items[i][1], items[i - 1][1]);
		}
		for (int j = 0; j < queries.length; j++) {
			result[j] = binarySearch(items, queries[j]);
		}
		return result;
	}

	private int binarySearch(int[][] items, int target) {
		int left = 0;
		int right = items.length - 1;
		while (left < right) {
			int mid = (left + right + 1) >> 1;
			if (items[mid][0] > target) {
				right = mid - 1;
			} else {
				left = mid;
			}
		}
		return items[left][0] <= target ? items[left][1] : 0;
	}

}
