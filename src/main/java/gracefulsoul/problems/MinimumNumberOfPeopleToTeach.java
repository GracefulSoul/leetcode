package gracefulsoul.problems;

import java.util.HashSet;
import java.util.Set;

public class MinimumNumberOfPeopleToTeach {

	// https://leetcode.com/problems/minimum-number-of-people-to-teach/submissions/1765886482/
	public static void main(String[] args) {
		MinimumNumberOfPeopleToTeach test = new MinimumNumberOfPeopleToTeach();
		System.out.println(test.minimumTeachings(2, new int[][] {
			{ 1 },
			{ 2 },
			{ 1, 2 }
			}, new int[][] {
				{ 1, 2 },
				{ 1, 3 },
				{ 2, 3 }
			}));
		System.out.println(test.minimumTeachings(3, new int[][] {
			{ 2 },
			{ 1, 3 },
			{ 1, 2 },
			{ 3 }
			}, new int[][] {
				{ 1, 4 },
				{ 1, 2 },
				{ 3, 4 },
				{ 2, 3 }
			}));
	}

	public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
		Set<Integer> set = new HashSet<>();
		for (int[] friendship : friendships) {
			int u1 = friendship[0] - 1;
			int u2 = friendship[1] - 1;
			boolean canCommunicate = false;
			for (int lang1 : languages[u1]) {
				for (int lang2 : languages[u2]) {
					if (lang1 == lang2) {
						canCommunicate = true;
						break;
					}
				}
				if (canCommunicate)
					break;
			}
			if (!canCommunicate) {
				set.add(u1);
				set.add(u2);
			}
		}
		int result = languages.length + 1;
		for (int lang = 1; lang <= n; lang++) {
			int count = 0;
			for (int user : set) {
				boolean isKnown = false;
				for (int language : languages[user]) {
					if (language == lang) {
						isKnown = true;
						break;
					}
				}
				if (!isKnown)
					count++;
			}
			result = Math.min(result, count);
		}
		return result;
	}

}
