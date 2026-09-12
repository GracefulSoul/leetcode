package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import gracefulsoul.util.PrintUtil;

public class MaximumScoreOfNonOverlappingIntervals {

	// https://leetcode.com/problems/maximum-score-of-non-overlapping-intervals/submissions/2139306845/
	public static void main(String[] args) {
		MaximumScoreOfNonOverlappingIntervals test = new MaximumScoreOfNonOverlappingIntervals();
		PrintUtil.print(test.maximumWeight(Arrays.asList(
			Arrays.asList(1, 3, 2),
			Arrays.asList(4, 5, 2),
			Arrays.asList(1, 5, 5),
			Arrays.asList(6, 9, 3),
			Arrays.asList(6, 7, 1),
			Arrays.asList(8, 9, 1)
		)));
		PrintUtil.print(test.maximumWeight(Arrays.asList(
			Arrays.asList(5, 8, 1),
			Arrays.asList(6, 7, 7),
			Arrays.asList(4, 7, 3),
			Arrays.asList(9, 10, 6),
			Arrays.asList(7, 8, 2),
			Arrays.asList(11, 14, 3)
		)));
	}

	@SuppressWarnings("unchecked")
	public int[] maximumWeight(List<List<Integer>> intervals) {
		int size = intervals.size();
		int[][] arr = new int[size][4];
		for (int i = 0; i < size; i++) {
			arr[i][0] = intervals.get(i).get(0);
			arr[i][1] = intervals.get(i).get(1);
			arr[i][2] = intervals.get(i).get(2);
			arr[i][3] = i;
		}
		Arrays.sort(arr, (a, b) -> Integer.compare(a[1], b[1]));
		long[][] weightDp = new long[size + 1][5];
		List<Integer>[][] dpList = new ArrayList[size + 1][5];
		for (int i = 0; i <= size; i++) {
			for (int k = 0; k <= 4; k++) {
				dpList[i][k] = new ArrayList<>();
			}
		}
		for (int i = 1; i <= size; i++) {
			int prev = 0;
			int low = 1;
			int high = i - 1;
			while (low <= high) {
				int mid = low + ((high - low) / 2);
				if (arr[mid - 1][1] < arr[i - 1][0]) {
					prev = mid;
					low = mid + 1;
				} else
					high = mid - 1;
			}
			for (int k = 1; k <= 4; k++) {
				long skip = weightDp[i - 1][k];
				List<Integer> skipList = dpList[i - 1][k];
				long take = weightDp[prev][k - 1] + arr[i - 1][2];
				List<Integer> takeList = new ArrayList<>(dpList[prev][k - 1]);
				takeList.add(arr[i - 1][3]);
				Collections.sort(takeList);
				if (take > skip) {
					weightDp[i][k] = take;
					dpList[i][k] = takeList;
				} else if (take == skip) {
					if (this.isLexicographicallySmaller(takeList, skipList)) {
						weightDp[i][k] = take;
						dpList[i][k] = takeList;
					} else {
						weightDp[i][k] = skip;
						dpList[i][k] = skipList;
					}
				} else {
					weightDp[i][k] = skip;
					dpList[i][k] = skipList;
				}
			}
		}
		List<Integer> list = dpList[size][4];
		int[] result = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			result[i] = list.get(i);
		}
		return result;
	}

	private boolean isLexicographicallySmaller(List<Integer> a, List<Integer> b) {
		int min = Math.min(a.size(), b.size());
		for (int i = 0; i < min; i++) {
			if (!a.get(i).equals(b.get(i))) {
				return a.get(i) < b.get(i);
			}
		}
		return a.size() < b.size();
	}

}
