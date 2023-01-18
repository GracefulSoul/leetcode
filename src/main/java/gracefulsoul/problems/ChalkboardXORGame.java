package gracefulsoul.problems;

public class ChalkboardXORGame {

	// https://leetcode.com/problems/chalkboard-xor-game/submissions/881125248/
	public static void main(String[] args) {
		ChalkboardXORGame test = new ChalkboardXORGame();
		System.out.println(test.xorGame(new int[] { 1, 1, 2 }));
		System.out.println(test.xorGame(new int[] { 0, 1 }));
	}

	public boolean xorGame(int[] nums) {
		int n = 0;
		for (int num : nums) {
			n ^= num;
		}
		return n == 0 || nums.length % 2 == 0;
	}

}
