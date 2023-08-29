package gracefulsoul.problems;

public class MinimumPenaltyForAShop {

	// https://leetcode.com/problems/minimum-penalty-for-a-shop/submissions/1034898957/
	public static void main(String[] args) {
		MinimumPenaltyForAShop test = new MinimumPenaltyForAShop();
		System.out.println(test.bestClosingTime("YYNY"));
		System.out.println(test.bestClosingTime("NNNNN"));
		System.out.println(test.bestClosingTime("YYYY"));
	}

	public int bestClosingTime(String customers) {
		int max = 0;
		int score = 0;
		int time = -1;
		for (int i = 0; i < customers.length(); i++) {
			if (customers.charAt(i) == 'Y') {
				score++;
			} else {
				score--;
			}
			if (score > max) {
				max = score;
				time = i;
			}
		}
		return time + 1;
	}

}
