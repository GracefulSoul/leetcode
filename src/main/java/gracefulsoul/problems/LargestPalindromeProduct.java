package gracefulsoul.problems;

public class LargestPalindromeProduct {

	// https://leetcode.com/submissions/detail/693991657/
	public static void main(String[] args) {
		LargestPalindromeProduct test = new LargestPalindromeProduct();
		System.out.println(test.largestPalindrome(2));
		System.out.println(test.largestPalindrome(1));
	}

	public int largestPalindrome(int n) {
		if (n > 1) {
			int num = (int) Math.pow(10, n);
			for (long idx = 2; idx < num; idx += 2) {
				long high = num - idx;
				long low = Long.parseLong(new StringBuilder(Long.toString(high)).reverse().toString());
				long temp = (idx * idx) - (4 * low);
				if (temp < 0) {
					continue;
				}
				long sqrt = (long) Math.sqrt(temp);
				if (sqrt * sqrt == temp) {
					return (int) (((high * num) + low) % 1337);
				}
			}
		}
		return 9;
	}

}
