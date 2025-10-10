package gracefulsoul.problems;

public class TakingMaximumEnergyFromTheMysticDungeon {

	// https://leetcode.com/problems/taking-maximum-energy-from-the-mystic-dungeon/submissions/1797262656/
	public static void main(String[] args) {
		TakingMaximumEnergyFromTheMysticDungeon test = new TakingMaximumEnergyFromTheMysticDungeon();
		System.out.println(test.maximumEnergy(new int[] { 5, 2, -10, -5, 1 }, 3));
		System.out.println(test.maximumEnergy(new int[] { -2, -3, -1 }, 2));
	}

	public int maximumEnergy(int[] energy, int k) {
		int length = energy.length;
		int[] dp = new int[length];
		int result = Integer.MIN_VALUE;
		for (int i = length - 1; i >= 0; i--) {
			dp[i] = energy[i] + (i + k < length ? dp[i + k] : 0);
			result = Math.max(result, dp[i]);
		}
		return result;
	}

}
