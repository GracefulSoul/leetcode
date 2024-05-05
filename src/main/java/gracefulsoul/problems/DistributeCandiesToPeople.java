package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class DistributeCandiesToPeople {

	// https://leetcode.com/problems/distribute-candies-to-people/submissions/1248870486/
	public static void main(String[] args) {
		DistributeCandiesToPeople test = new DistributeCandiesToPeople();
		PrintUtil.print(test.distributeCandies(7, 4));
		PrintUtil.print(test.distributeCandies(10, 3));
	}

	public int[] distributeCandies(int candies, int num_people) {
		int[] result = new int[num_people];
		for (int i = 0; candies > 0; i++) {
			result[i % num_people] += Math.min(candies, i + 1);
			candies -= i + 1;
		}
		return result;
	}

}
