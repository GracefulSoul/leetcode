package gracefulsoul.problems;

public class LongestChunkedPalindromeDecomposition {

	// https://leetcode.com/problems/longest-chunked-palindrome-decomposition/submissions/1348732394/
	public static void main(String[] args) {
		LongestChunkedPalindromeDecomposition test = new LongestChunkedPalindromeDecomposition();
		System.out.println(test.longestDecomposition("ghiabcdefhelloadamhelloabcdefghi"));
		System.out.println(test.longestDecomposition("merchant"));
		System.out.println(test.longestDecomposition("antaprezatepzapreanta"));
	}

	public int longestDecomposition(String text) {
		int length = text.length();
		for (int i = 0; i < length / 2; i++) {
			if (text.substring(0, i + 1).equals(text.substring(length - 1 - i, length))) {
				return 2 + this.longestDecomposition(text.substring(i + 1, length - 1 - i));
			}
		}
		return length == 0 ? 0 : 1;
	}

}
