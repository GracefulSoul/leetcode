package gracefulsoul.problems;

public class NumberOf1Bits {

	// https://leetcode.com/submissions/detail/563708874/
	public static void main(String[] args) {
		NumberOf1Bits test = new NumberOf1Bits();
		System.out.println(test.hammingWeight(00000000000000000000000000001011));
		System.out.println(test.hammingWeight(00000000000000000000000010000000));
	}

	// you need to treat n as an unsigned value
	public int hammingWeight(int n) {
		int result = 0;
		while (n != 0) {
			result += n & 1;
			n >>>= 1;
		}
		return result;
	}

}
