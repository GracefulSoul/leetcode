package gracefulsoul.problems;

public class BuyTwoChocolates {

	// https://leetcode.com/problems/buy-two-chocolates/submissions/1125003496/
	public static void main(String[] args) {
		BuyTwoChocolates test = new BuyTwoChocolates();
		System.out.println(test.buyChoco(new int[] { 1, 2, 2 }, 3));
		System.out.println(test.buyChoco(new int[] { 3, 2, 3 }, 3));
	}

	public int buyChoco(int[] prices, int money) {
		int[] mins = new int[] { Integer.MAX_VALUE, Integer.MAX_VALUE };
		for (int price : prices) {
			if (price < mins[0]) {
				mins[1] = mins[0];
				mins[0] = price;
			} else {
				mins[1] = Math.min(mins[1], price);
			}
		}
		int leftover = money - (mins[0] + mins[1]);
		return leftover >= 0 ? leftover : money;
	}

}
