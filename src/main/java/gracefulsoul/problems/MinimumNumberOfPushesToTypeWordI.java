package gracefulsoul.problems;

public class MinimumNumberOfPushesToTypeWordI {

	// https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-i/submissions/2087359926/
	public static void main(String[] args) {
		MinimumNumberOfPushesToTypeWordI test = new MinimumNumberOfPushesToTypeWordI();
		System.out.println(test.minimumPushes("abcde"));
		System.out.println(test.minimumPushes("xycdefghij"));
	}

	public int minimumPushes(String word) {
		int length = word.length();
		int keypads = length >> 3;
		return ((keypads << 2) + (length & 7)) * (keypads + 1);
	}

}
