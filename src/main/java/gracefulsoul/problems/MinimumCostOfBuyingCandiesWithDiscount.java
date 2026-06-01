package gracefulsoul.problems;

import java.util.Arrays;

public class MinimumCostOfBuyingCandiesWithDiscount {

	// https://leetcode.com/problems/minimum-cost-of-buying-candies-with-discount/submissions/2019224689/
	public static void main(String[] args) {
		MinimumCostOfBuyingCandiesWithDiscount test = new MinimumCostOfBuyingCandiesWithDiscount();
		System.out.println(test.minimumCost(new int[] { 1, 2, 3 }));
		System.out.println(test.minimumCost(new int[] { 6, 5, 7, 9, 2, 2 }));
		System.out.println(test.minimumCost(new int[] { 5, 5 }));
	}

	public int minimumCost(int[] cost) {
		Arrays.sort(cost);
		int length = cost.length;
		int result = 0;
		for (int i = 0; i < length; i++) {
			if (i % 3 != length % 3) {
				result += cost[i];
			}
		}
		return result;
	}

}
