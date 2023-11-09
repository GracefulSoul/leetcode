package gracefulsoul.problems;

public class CountNumberOfHomogenousSubstrings {

	// https://leetcode.com/problems/count-number-of-homogenous-substrings/submissions/1095109101/
	public static void main(String[] args) {
		CountNumberOfHomogenousSubstrings test = new CountNumberOfHomogenousSubstrings();
		System.out.println(test.countHomogenous("abbcccaa"));
		System.out.println(test.countHomogenous("xy"));
		System.out.println(test.countHomogenous("zzzzz"));
	}

	public int countHomogenous(String s) {
		int count = 0;
		int result = 0;
		char[] charArray = s.toCharArray();
		for (int left = 0, right = 0; right < charArray.length; right++) {
			if (charArray[left] == charArray[right]) {
				count++;
			} else {
				left = right;
				count = 1;
			}
			result = (result + count) % 1000000007;
		}
		return result;
	}

}
