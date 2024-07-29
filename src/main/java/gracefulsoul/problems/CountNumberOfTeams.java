package gracefulsoul.problems;

public class CountNumberOfTeams {

	// https://leetcode.com/problems/count-number-of-teams/submissions/1337081719/
	public static void main(String[] args) {
		CountNumberOfTeams test = new CountNumberOfTeams();
		System.out.println(test.numTeams(new int[] { 2, 5, 3, 4, 1 }));
		System.out.println(test.numTeams(new int[] { 2, 1, 3 }));
		System.out.println(test.numTeams(new int[] { 1, 2, 3, 4 }));
	}

	public int numTeams(int[] rating) {
		int length = rating.length;
		int[][] dp = new int[length][2];
		int result = 0;
		for (int i = 1; i < rating.length; i++) {
			for (int j = 0; j < i; j++) {
				if (rating[i] > rating[j]) {
					dp[i][0]++;
					result += dp[j][0];
				} else {
					dp[i][1]++;
					result += dp[j][1];
				}
			}
		}
		return result;
	}

}
