package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumCostToCutAStick {

	public static void main(String[] args) {
		MinimumCostToCutAStick test = new MinimumCostToCutAStick();
		System.out.println(test.minCost(7, new int[] { 1, 3, 4, 5 }));
		System.out.println(test.minCost(9, new int[] { 5, 6, 1, 4, 2 }));
	}

	public int minCost(int n, int[] cuts) {
		List<Integer> list = new ArrayList<>();
		for (int cut : cuts) {
			list.add(cut);
		}
		list.add(0);
		list.add(n);
		Collections.sort(list);
		int size = list.size();
		int[][] dp = new int[size][size];
		for (int j = 2; j < size; j++) {
			for (int i = 0; i < size - j; i++) {
				dp[i][i + j] = 1000000000;
				for (int m = i + 1; m < i + j; ++m) {
					dp[i][i + j] = Math.min(dp[i][i + j], dp[i][m] + dp[m][i + j] + list.get(i + j) - list.get(i));
				}
			}
		}
		return dp[0][size - 1];
	}

}
