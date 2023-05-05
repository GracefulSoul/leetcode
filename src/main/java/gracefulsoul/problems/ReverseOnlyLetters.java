package gracefulsoul.problems;

public class ReverseOnlyLetters {

	// https://leetcode.com/problems/reverse-only-letters/submissions/945218187/
	public static void main(String[] args) {
		ReverseOnlyLetters test = new ReverseOnlyLetters();
		System.out.println(test.reverseOnlyLetters("ab-cd"));
		System.out.println(test.reverseOnlyLetters("a-bC-dEf-ghIj"));
		System.out.println(test.reverseOnlyLetters("Test1ng-Leet=code-Q!"));
	}

	public String reverseOnlyLetters(String s) {
		char[] charArray = s.toCharArray();
		int left = 0;
		int right = charArray.length - 1;
		while (left < right) {
			if (!Character.isAlphabetic(charArray[left])) {
				left++;
			} else if (!Character.isAlphabetic(charArray[right])) {
				right--;
			} else {
				char temp = charArray[left];
				charArray[left++] = charArray[right];
				charArray[right--] = temp;
			}
		}
		return new String(charArray);
	}

}
