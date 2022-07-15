package gracefulsoul.problems;

import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {

	// https://leetcode.com/submissions/detail/748137628/
	public static void main(String[] args) {
		DistributeCandies test = new DistributeCandies();
		System.out.println(test.distributeCandies(new int[] { 1, 1, 2, 2, 3, 3 }));
		System.out.println(test.distributeCandies(new int[] { 1, 1, 2, 3 }));
	}

	public int distributeCandies(int[] candyType) {
		Set<Integer> types = new HashSet<>();
		for (int candy : candyType) {
			types.add(candy);
		}
		return Math.min(candyType.length / 2, types.size());
	}

}
