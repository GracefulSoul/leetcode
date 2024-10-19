package gracefulsoul.problems;

public class FindKthBitInNthBinaryString {

	// https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/submissions/1426923165/
	public static void main(String[] args) {
		FindKthBitInNthBinaryString test = new FindKthBitInNthBinaryString();
		System.out.println(test.findKthBit(3, 1));
		System.out.println(test.findKthBit(4, 11));
	}

	public char findKthBit(int n, int k) {
		int flips = 0;
		while (n > 1) {
			int length = (1 << n) - 1;
			int mid = (length + 1) / 2;
			if (k == mid) {
				return flips == 0 ? '1' : '0';
			} else if (k > mid) {
				flips ^= 1;
				k = length - k + 1;
			}
			n -= 1;
		}
		return flips == 0 ? '0' : '1';
	}

}
