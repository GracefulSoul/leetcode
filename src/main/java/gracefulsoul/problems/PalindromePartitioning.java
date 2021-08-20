package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

	// https://leetcode.com/submissions/detail/541182257/
	public static void main(String[] args) {
		PalindromePartitioning test = new PalindromePartitioning();
		System.out.println(test.partition("aab"));
		System.out.println(test.partition("a"));
	}

	public List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<>();
		this.recursive(s, 0, result, new ArrayList<>());
		return result;
	}

	private void recursive(String s, int index, List<List<String>> result, List<String> temp) {
		if (index == s.length()) {
			result.add(new ArrayList<>(temp));
		} else {
			for (int i = index; i < s.length(); i++) {
				if (this.isPalindrome(s, index, i)) {
					temp.add(s.substring(index, i + 1));
					this.recursive(s, i + 1, result, temp);
					temp.remove(temp.size() - 1);
				}
			}
		}
	}

	private boolean isPalindrome(String s, int start, int end) {
		while (start < end) {
			if (s.charAt(start++) != s.charAt(end--)) {
				return false;
			}
		}
		return true;
	}

}
