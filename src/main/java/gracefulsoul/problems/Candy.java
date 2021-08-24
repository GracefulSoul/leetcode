package gracefulsoul.problems;

import java.util.Arrays;

public class Candy {

	// https://leetcode.com/submissions/detail/543169483/
	public static void main(String[] args) {
		Candy test = new Candy();
		System.out.println(test.candy(new int[] { 1, 0, 2 }));
		System.out.println(test.candy(new int[] { 1, 2, 2 }));
	}

	public int candy(int[] ratings) {
		int candies[] = new int[ratings.length];
		Arrays.fill(candies, 1);
		for (int idx = 1; idx < candies.length; idx++) {
			if (ratings[idx - 1] < ratings[idx]) {
				candies[idx] = candies[idx - 1] + 1;
			}
		}
		for (int idx = candies.length - 2; idx >= 0; idx--) {
			if (ratings[idx] > ratings[idx + 1]) {
				candies[idx] = Math.max(candies[idx], candies[idx + 1] + 1);
			}
		}
		int sum = 0;
		for (int candy : candies) {
			sum += candy;
		}
		return sum;
	}

}
