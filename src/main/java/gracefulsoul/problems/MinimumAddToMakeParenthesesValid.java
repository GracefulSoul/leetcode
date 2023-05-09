package gracefulsoul.problems;

public class MinimumAddToMakeParenthesesValid {

	// https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/submissions/947191488/
	public static void main(String[] args) {
		MinimumAddToMakeParenthesesValid test = new MinimumAddToMakeParenthesesValid();
		System.out.println(test.minAddToMakeValid("())"));
		System.out.println(test.minAddToMakeValid("((("));
	}

	public int minAddToMakeValid(String s) {
		int left = 0;
		int right = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				right++;
			} else if (right > 0) {
				right--;
			} else {
				left++;
			}
		}
		return left + right;
	}

}
