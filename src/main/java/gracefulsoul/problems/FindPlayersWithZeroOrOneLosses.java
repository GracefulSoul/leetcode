package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindPlayersWithZeroOrOneLosses {

	// https://leetcode.com/problems/find-players-with-zero-or-one-losses/submissions/1146744149/
	public static void main(String[] args) {
		FindPlayersWithZeroOrOneLosses test = new FindPlayersWithZeroOrOneLosses();
		System.out.println(test.findWinners(new int[][] {
			{ 1, 3 },
			{ 2, 3 },
			{ 3, 6 },
			{ 5, 6 },
			{ 5, 7 },
			{ 4, 5 },
			{ 4, 8 },
			{ 4, 9 },
			{ 10, 4 },
			{ 10, 9 }
		}));
		System.out.println(test.findWinners(new int[][] {
			{ 2, 3 },
			{ 1, 3 },
			{ 5, 4 },
			{ 6, 4 }
		}));
	}

	public List<List<Integer>> findWinners(int[][] matches) {
		int[] losses = new int[100001];
		for (int i = 0; i < matches.length; i++) {
			int win = matches[i][0];
			int loss = matches[i][1];
			if (losses[win] == 0) {
				losses[win] = -1;
			}
			if (losses[loss] == -1) {
				losses[loss] = 1;
			} else {
				losses[loss]++;
			}
		}
		List<List<Integer>> result = Arrays.asList(new ArrayList<>(), new ArrayList<>());
		for (int i = 0; i < losses.length; i++) {
			if (losses[i] == -1) {
				result.get(0).add(i);
			} else if (losses[i] == 1) {
				result.get(1).add(i);
			}
		}
		return result;
	}

}
