package gracefulsoul.problems;

public class MinimumTimeToMakeRopeColorful {

	// https://leetcode.com/problems/minimum-time-to-make-rope-colorful/submissions/1129920353/
	public static void main(String[] args) {
		MinimumTimeToMakeRopeColorful test = new MinimumTimeToMakeRopeColorful();
		System.out.println(test.minCost("abaac", new int[] { 1, 2, 3, 4, 5 }));
		System.out.println(test.minCost("abc", new int[] { 1, 2, 3 }));
		System.out.println(test.minCost("aabaa", new int[] { 1, 2, 3, 4, 1 }));
	}

	public int minCost(String colors, int[] neededTime) {
		int result = 0;
		char[] charArray = colors.toCharArray();
		int max = neededTime[0];
		for (int i = 1; i < charArray.length; i++) {
			if (charArray[i - 1] != charArray[i]) {
				max = neededTime[i];
			} else {
				result += Math.min(max, neededTime[i]);
				max = Math.max(max, neededTime[i]);
			}
		}
		return result;
	}

}
