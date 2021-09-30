package gracefulsoul.problems;

public class ReverseBits {

	// https://leetcode.com/submissions/detail/563240768/
	public static void main(String[] args) {
		ReverseBits test = new ReverseBits();
		System.out.println(test.reverseBits(43261596));
	}

	public int reverseBits(int n) {
		int result = 0;
		for (int i = 0; i < 32; i++) {
			result = (result <<= 1) + (n & 1);
			n >>= 1;
		}
		return result;
	}

}
