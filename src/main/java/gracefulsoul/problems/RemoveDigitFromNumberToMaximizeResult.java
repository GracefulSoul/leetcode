package gracefulsoul.problems;

public class RemoveDigitFromNumberToMaximizeResult {

	// https://leetcode.com/submissions/detail/694661722/
	public static void main(String[] args) {
		RemoveDigitFromNumberToMaximizeResult test = new RemoveDigitFromNumberToMaximizeResult();
		System.out.println(test.removeDigit("123", '3'));
		System.out.println(test.removeDigit("1231", '1'));
		System.out.println(test.removeDigit("551", '5'));
	}

	public String removeDigit(String number, char digit) {
		char[] nums = number.toCharArray();
		int index = 0;
		for (int idx = 0; idx < number.length(); idx++) {
			if (nums[idx] == digit) {
				index = idx;
				if (idx < number.length() - 1 && nums[idx] < nums[idx + 1]) {
					break;
				}
			}
		}
		return number.substring(0, index).concat(number.substring(index + 1));
	}

}
