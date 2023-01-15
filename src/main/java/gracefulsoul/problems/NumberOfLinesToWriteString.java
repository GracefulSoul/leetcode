package gracefulsoul.problems;

public class NumberOfLinesToWriteString {

	// https://leetcode.com/problems/number-of-lines-to-write-string/submissions/878301815/
	public static void main(String[] args) {
		NumberOfLinesToWriteString test = new NumberOfLinesToWriteString();
		System.out.println(test.numberOfLines(new int[] { 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 }, "abcdefghijklmnopqrstuvwxyz"));
		System.out.println(test.numberOfLines(new int[] { 4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10 }, "bbbcccdddaaa"));
	}

	public int[] numberOfLines(int[] widths, String s) {
		int line = 1;
		int width = 0;
		for (char c : s.toCharArray()) {
			int curr = widths[c - 'a'];
			if (width + curr > 100) {
				line++;
				width = curr;
			} else {
				width += curr;
			}
		}
		return new int[] { line, width };
	}

}
