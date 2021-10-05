package gracefulsoul.problems;

public class BitwiseANDOfNumbersRange {

	// https://leetcode.com/submissions/detail/566002947/
	public static void main(String[] args) {
		BitwiseANDOfNumbersRange test = new BitwiseANDOfNumbersRange();
		System.out.println(test.rangeBitwiseAnd(5, 7));
		System.out.println(test.rangeBitwiseAnd(0, 0));
		System.out.println(test.rangeBitwiseAnd(1, 2147483647));
	}

	public int rangeBitwiseAnd(int left, int right) {
		int result = 0;
		while (left != right) {
			left >>= 1;
			right >>= 1;
			result++;
		}
		return left << result;
	}

}
