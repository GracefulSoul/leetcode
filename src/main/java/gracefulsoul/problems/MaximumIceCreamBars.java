package gracefulsoul.problems;

public class MaximumIceCreamBars {

	// https://leetcode.com/problems/maximum-ice-cream-bars/submissions/2040529036/
	public static void main(String[] args) {
		MaximumIceCreamBars test = new MaximumIceCreamBars();
		System.out.println(test.maxIceCream(new int[] { 1, 3, 2, 4, 1 }, 7));
		System.out.println(test.maxIceCream(new int[] { 10, 6, 8, 7, 7, 8 }, 5));
		System.out.println(test.maxIceCream(new int[] { 1, 6, 3, 1, 2, 5 }, 20));
	}

	public int maxIceCream(int[] costs, int coins) {
		int max = costs[0];
		for (int i = 1; i < costs.length; i++) {
			max = Math.max(costs[i], max);
		}
		int[] counts = new int[max + 1];
		for (int cost : costs) {
			counts[cost]++;
		}
		int result = 0;
		for (int i = 0; i < counts.length; i++) {
			if (coins < i) {
				break;
			}
			if (counts[i] > 0) {
				result += Math.min(counts[i], coins / i);
				coins -= Math.min(coins, counts[i] * i);
			}
		}
		return result;
	}

}
