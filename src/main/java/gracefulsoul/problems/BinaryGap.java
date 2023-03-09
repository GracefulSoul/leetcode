package gracefulsoul.problems;

public class BinaryGap {

	// https://leetcode.com/problems/binary-gap/submissions/912010329/
	public static void main(String[] args) {
		BinaryGap test = new BinaryGap();
		System.out.println(test.binaryGap(22));
		System.out.println(test.binaryGap(8));
		System.out.println(test.binaryGap(5));
	}

	public int binaryGap(int n) {
		int result = 0;
		for (int i = -32; n > 0; n /= 2, i++) {
			if (n % 2 == 1) {
				result = Math.max(result, i);
				i = 0;
			}
		}
		return result;
	}

}
