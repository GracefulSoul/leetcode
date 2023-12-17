package gracefulsoul.problems;

public class BestSightseeingPair {

	// https://leetcode.com/problems/best-sightseeing-pair/submissions/1123366305/
	public static void main(String[] args) {
		BestSightseeingPair test = new BestSightseeingPair();
		System.out.println(test.maxScoreSightseeingPair(new int[] { 8, 1, 5, 2, 6 }));
		System.out.println(test.maxScoreSightseeingPair(new int[] { 1, 2 }));
	}

	public int maxScoreSightseeingPair(int[] values) {
		int result = 0;
		int max = 0;
		for (int i = 0; i < values.length; i++) {
			result = Math.max(result, max + values[i] - i);
			max = Math.max(max, values[i] + i);
		}
		return result;
	}

}
