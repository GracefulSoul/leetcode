package gracefulsoul.problems;

import java.util.Arrays;

public class MaximumMatchingOfPlayersWithTrainers {

	// https://leetcode.com/problems/maximum-matching-of-players-with-trainers/submissions/1695951908/
	public static void main(String[] args) {
		MaximumMatchingOfPlayersWithTrainers test = new MaximumMatchingOfPlayersWithTrainers();
		System.out.println(test.matchPlayersAndTrainers(new int[] { 4, 7, 9 }, new int[] { 8, 2, 5, 8 }));
		System.out.println(test.matchPlayersAndTrainers(new int[] { 1, 1, 1 }, new int[] { 10 }));
	}

	public int matchPlayersAndTrainers(int[] players, int[] trainers) {
		Arrays.sort(players);
		Arrays.sort(trainers);
		int i = 0;
		int j = 0;
		int result = 0;
		while (j < trainers.length && i < players.length) {
			if (players[i] > trainers[j]) {
				while (j < trainers.length && trainers[j] < players[i]) {
					j++;
				}
			} else {
				result++;
				i++;
				j++;
			}
		}
		return result;
	}

}
