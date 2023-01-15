package gracefulsoul.problems;

public class NumberOfLinesToWriteString {

	// https://leetcode.com/problems/number-of-lines-to-write-string/submissions/878304072/
	public static void main(String[] args) {
		NumberOfLinesToWriteString test = new NumberOfLinesToWriteString();
		System.out.println(test.numberOfLines(new int[] { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 }, "abcdefghijklmnopqrstuvwxyz"));
		System.out.println(test.numberOfLines(new int[] { 4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 }, "bbbcccdddaaa"));
	}

	public int[] numberOfLines(int[] widths, String s) {
		int[] result = new int[] { 1, 0 };
		for (char c : s.toCharArray()) {
			int curr = widths[c - 'a'];
			if (result[1] + curr > 100) {
				result[0]++;
				result[1] = curr;
			} else {
				result[1] += curr;
			}
		}
		return result;
	}

}
