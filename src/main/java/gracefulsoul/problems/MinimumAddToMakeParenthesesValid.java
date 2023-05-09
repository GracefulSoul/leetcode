package gracefulsoul.problems;

public class MinimumAddToMakeParenthesesValid {

	// https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/submissions/947171183/
	public static void main(String[] args) {
		MinimumAddToMakeParenthesesValid test = new MinimumAddToMakeParenthesesValid();
		System.out.println(test.minAddToMakeValid("())"));
		System.out.println(test.minAddToMakeValid("((("));
	}

	public int minAddToMakeValid(String s) {
		int open = 0;
		int close = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				close++;
			} else if (close > 0) {
				close--;
			} else {
				open++;
			}
		}
		return open + close;
	}

}
