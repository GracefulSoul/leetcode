package gracefulsoul.problems;

public class SumOfDigitsOfStringAfterConvert {

	// https://leetcode.com/problems/sum-of-digits-of-string-after-convert/submissions/1377488412/
	public static void main(String[] args) {
		SumOfDigitsOfStringAfterConvert test = new SumOfDigitsOfStringAfterConvert();
		System.out.println(test.getLucky("iiii", 1));
		System.out.println(test.getLucky("leetcode", 2));
		System.out.println(test.getLucky("zbax", 2));
	}

	public int getLucky(String s, int k) {
		int result = 0;
		for (char c : s.toCharArray()) {
			int num = c - 96;
			if (num > 9) {
				result += (num / 10) + (num % 10);
			} else {
				result += num;
			}
		}
		while (--k > 0 && result > 9) {
			int sum = 0;
			while (result > 0) {
				sum += result % 10;
				result /= 10;
			}
			result = sum;
		}
		return result;
	}

}
