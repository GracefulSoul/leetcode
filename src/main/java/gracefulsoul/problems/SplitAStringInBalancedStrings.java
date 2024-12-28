package gracefulsoul.problems;

public class SplitAStringInBalancedStrings {

	// https://leetcode.com/problems/split-a-string-in-balanced-strings/submissions/1490263373/
	public static void main(String[] args) {
		SplitAStringInBalancedStrings test = new SplitAStringInBalancedStrings();
		System.out.println(test.balancedStringSplit("RLRRLLRLRL"));
		System.out.println(test.balancedStringSplit("RLRRRLLRLL"));
		System.out.println(test.balancedStringSplit("LLLLRRRR"));
	}

	public int balancedStringSplit(String s) {
		int result = 0;
		int count = 0;
		for (char c : s.toCharArray()) {
			if (c == 'L') {
				count++;
			} else {
				count--;
			}
			if (count == 0) {
				result++;
			}
		}
		return result;
	}

}
