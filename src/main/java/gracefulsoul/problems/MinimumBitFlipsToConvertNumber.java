package gracefulsoul.problems;

public class MinimumBitFlipsToConvertNumber {

	// https://leetcode.com/problems/minimum-bit-flips-to-convert-number/submissions/1386491795/
	public static void main(String[] args) {
		MinimumBitFlipsToConvertNumber test = new MinimumBitFlipsToConvertNumber();
		System.out.println(test.minBitFlips(10, 7));
		System.out.println(test.minBitFlips(3, 4));
	}

	public int minBitFlips(int start, int goal) {
		int result = 0;
		int bit = start ^ goal;
		while (bit != 0) {
			result += bit & 1;
			bit >>= 1;
		}
		return result;
	}

}
