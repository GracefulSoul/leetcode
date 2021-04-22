package gracefulsoul.problems;

public class ReverseInteger {

	// https://leetcode.com/submissions/detail/480942023/
	public static void main(String[] args) {
		ReverseInteger test = new ReverseInteger();
		System.out.println(test.reverse(321));
		System.out.println(test.reverse(-321));
		System.out.println(test.reverse(120));
		System.out.println(test.reverse(0));
//		System.out.println(test.reverse(Integer.MAX_VALUE));
//		System.out.println(test.reverse(Integer.MIN_VALUE));
	}

	public int reverse(int x) {
		int result = 0;
		while (x != 0) {
			int temp = result * 10 + x % 10;
			if (temp / 10 != result) {
				return 0;
			} else {
				result = temp;
				x /= 10;
			}
		}
		return result;
	}

}
