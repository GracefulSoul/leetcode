package gracefulsoul.problems;

public class ValidPalindrome {

	// https://leetcode.com/submissions/detail/538837041/
	public static void main(String[] args) {
		ValidPalindrome test = new ValidPalindrome();
		System.out.println(test.isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(test.isPalindrome("race a car"));
	}

	public boolean isPalindrome(String s) {
		char[] charArr = s.toCharArray();
		for (int i = 0, j = charArr.length - 1; i < j;) {
			if (!Character.isLetterOrDigit(charArr[i])) {
				i++;
			} else if (!Character.isLetterOrDigit(charArr[j])) {
				j--;
			} else if (Character.toLowerCase(charArr[i++]) != Character.toLowerCase(charArr[j--])) {
				return false;
			}
		}
		return true;
	}

}
