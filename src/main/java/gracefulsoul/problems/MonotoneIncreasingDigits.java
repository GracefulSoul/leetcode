package gracefulsoul.problems;

public class MonotoneIncreasingDigits {

	// https://leetcode.com/submissions/detail/849858202/
	public static void main(String[] args) {
		MonotoneIncreasingDigits test = new MonotoneIncreasingDigits();
		System.out.println(test.monotoneIncreasingDigits(10));
		System.out.println(test.monotoneIncreasingDigits(1234));
		System.out.println(test.monotoneIncreasingDigits(332));
	}

	public int monotoneIncreasingDigits(int n) {
		char[] charArray = String.valueOf(n).toCharArray();
		int end = charArray.length - 1;
		for (int idx = charArray.length - 1; idx > 0; idx--) {
			if (charArray[idx - 1] > charArray[idx]) {
				end = idx - 1;
				charArray[idx - 1]--;
			}
		}
		for (int idx = end + 1; idx < charArray.length; idx++) {
			charArray[idx] = '9';
		}
		return Integer.parseInt(new String(charArray));
	}

}
