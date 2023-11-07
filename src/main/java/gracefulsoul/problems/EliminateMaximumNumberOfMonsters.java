package gracefulsoul.problems;

import java.util.Arrays;

public class EliminateMaximumNumberOfMonsters {

	// https://leetcode.com/problems/eliminate-maximum-number-of-monsters/submissions/1093510343/
	public static void main(String[] args) {
		EliminateMaximumNumberOfMonsters test = new EliminateMaximumNumberOfMonsters();
		System.out.println(test.eliminateMaximum(new int[] { 1, 3, 4 }, new int[] { 1, 1, 1 }));
		System.out.println(test.eliminateMaximum(new int[] { 1, 1, 2, 3 }, new int[] { 1, 1, 1, 1 }));
		System.out.println(test.eliminateMaximum(new int[] { 3, 2, 4 }, new int[] { 5, 3, 2 }));
	}

	public int eliminateMaximum(int[] dist, int[] speed) {
		int length = dist.length;
		for (int i = 0; i < length; i++) {
			dist[i] = (dist[i] - 1) / speed[i];
		}
		Arrays.sort(dist);
		for (int i = 0; i < length; i++) {
			if (dist[i] < i) {
				return i;
			}
		}
		return length;
	}

}
