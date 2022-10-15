package gracefulsoul.problems;

public class BinaryNumberWithAlternatingBits {

	// https://leetcode.com/submissions/detail/822845459/
	public static void main(String[] args) {
		BinaryNumberWithAlternatingBits test = new BinaryNumberWithAlternatingBits();
		System.out.println(test.hasAlternatingBits(5));
		System.out.println(test.hasAlternatingBits(7));
		System.out.println(test.hasAlternatingBits(11));
	}

	public boolean hasAlternatingBits(int n) {
		n ^= (n >> 1);
		return (n & (n + 1)) == 0;
	}

}
