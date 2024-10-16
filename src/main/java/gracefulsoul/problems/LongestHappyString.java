package gracefulsoul.problems;

public class LongestHappyString {

	// https://leetcode.com/problems/longest-happy-string/submissions/1424126413/
	public static void main(String[] args) {
		LongestHappyString test = new LongestHappyString();
		System.out.println(test.longestDiverseString(1, 1, 7));
		System.out.println(test.longestDiverseString(7, 1, 0));
	}

	public String longestDiverseString(int a, int b, int c) {
		StringBuilder sb = new StringBuilder();
		int length = a + b + c;
		int countA = 0;
		int countB = 0;
		int countC = 0;
		for (int i = 0; i < length; i++) {
			if ((a >= b && a >= c && countA != 2) || (countB == 2 && a > 0) || (countC == 2 && a > 0)) {
				sb.append("a");
				a--;
				countA++;
				countB = countC = 0;
			} else if ((b >= a && b >= c && countB != 2) || (countA == 2 && b > 0) || (countC == 2 && b > 0)) {
				sb.append("b");
				b--;
				countB++;
				countA = countC = 0;
			} else if ((c >= a && c >= b && countC != 2) || (countA == 2 && c > 0) || (countB == 2 && c > 0)) {
				sb.append("c");
				c--;
				countC++;
				countA = countB = 0;
			}
		}
		return sb.toString();
	}

}
