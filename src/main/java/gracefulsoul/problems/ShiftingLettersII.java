package gracefulsoul.problems;

public class ShiftingLettersII {

	// https://leetcode.com/problems/shifting-letters-ii/submissions/1498420768/
	public static void main(String[] args) {
		ShiftingLettersII test = new ShiftingLettersII();
		System.out.println(test.shiftingLetters("abc", new int[][] {
			{ 0, 1, 0 },
			{ 1, 2, 1 },
			{ 0, 2, 1 }
		}));
		System.out.println(test.shiftingLetters("dztz", new int[][] {
			{ 0, 0, 0 },
			{ 1, 1, 1 }
		}));
	}

	public String shiftingLetters(String s, int[][] shifts) {
		int length = s.length();
		int[] dp = new int[length + 1];
		for (int[] shift : shifts) {
			int end = shift[1] + 1;
			int weight = shift[2] == 1 ? 1 : -1;
			dp[shift[0]] += weight;
			if (end < length) {
				dp[end] -= weight;
			}
		}
		int curr = 0;
		for (int i = 0; i < length; i++) {
			curr += dp[i];
			dp[i] = curr;
		}
		StringBuilder sb = new StringBuilder(s);
		for (int i = 0; i < length; i++) {
			sb.setCharAt(i, (char) ('a' + (s.charAt(i) - 'a' + (((dp[i] % 26) + 26) % 26)) % 26));
		}
		return sb.toString();
	}

}
