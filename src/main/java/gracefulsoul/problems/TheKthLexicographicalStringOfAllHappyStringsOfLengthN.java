package gracefulsoul.problems;

public class TheKthLexicographicalStringOfAllHappyStringsOfLengthN {

	// https://leetcode.com/problems/the-k-th-lexicographical-string-of-all-happy-strings-of-length-n/submissions/1548094566/
	public static void main(String[] args) {
		TheKthLexicographicalStringOfAllHappyStringsOfLengthN test = new TheKthLexicographicalStringOfAllHappyStringsOfLengthN();
		System.out.println(test.getHappyString(1, 3));
		System.out.println(test.getHappyString(1, 4));
		System.out.println(test.getHappyString(10, 100));
	}

	public String getHappyString(int n, int k) {
		int shift = 1 << (n - 1);
		if (k > 3 * shift) {
			return "";
		} else {
			int c = 'a' + ((k - 1) / shift);
			StringBuilder sb = new StringBuilder(Character.toString(c));
			while (shift > 1) {
				k = ((k - 1) % shift) + 1;
				shift >>= 1;
				if ((k - 1) / shift == 0) {
					c = c == 'a' ? 'b' : 'a';
				} else {
					c = c == 'c' ? 'b' : 'c';
				}
				sb.append((char) c);
			}
			return sb.toString();
		}
	}

}
