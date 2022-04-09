package gracefulsoul.problems;

import gracefulsoul.util.PrintUtil;

public class ReverseString {

	// https://leetcode.com/submissions/detail/622947023/
	public static void main(String[] args) {
		ReverseString test = new ReverseString();
		char[] s1 = new char[] { 'h', 'e', 'l', 'l', 'o' };
		test.reverseString(s1);
		PrintUtil.print(s1);
		char[] s2 = new char[] { 'H', 'a', 'n', 'n', 'a', 'h' };
		test.reverseString(s2);
		PrintUtil.print(s2);
	}

	public void reverseString(char[] s) {
		int left = 0;
		int right = s.length - 1;
		while (left < right) {
			char temp = s[left];
			s[left] = s[right];
			s[right] = temp;
			left++;
			right--;
		}
	}

}
