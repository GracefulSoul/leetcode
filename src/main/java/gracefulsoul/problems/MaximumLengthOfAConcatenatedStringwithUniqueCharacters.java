package gracefulsoul.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaximumLengthOfAConcatenatedStringwithUniqueCharacters {

	// https://leetcode.com/problems/maximum-length-of-a-concatenated-string-with-unique-characters/submissions/1154513348/
	public static void main(String[] args) {
		MaximumLengthOfAConcatenatedStringwithUniqueCharacters test = new MaximumLengthOfAConcatenatedStringwithUniqueCharacters();
		System.out.println(test.maxLength(Arrays.asList("un", "iq", "ue")));
		System.out.println(test.maxLength(Arrays.asList("cha", "r", "act", "ers")));
		System.out.println(test.maxLength(Arrays.asList("abcdefghijklmnopqrstuvwxyz")));
	}

	private int result;

	public int maxLength(List<String> arr) {
		this.result = 0;
		this.dfs(arr, "", 0);
		return this.result;
	}

	private void dfs(List<String> arr, String s, int index) {
		boolean isUnique = this.validate(s);
		if (isUnique) {
			this.result = Math.max(this.result, s.length());
		}
		if (index == arr.size() || !isUnique) {
			return;
		}
		for (int i = index; i < arr.size(); i++) {
			this.dfs(arr, s + arr.get(i), i + 1);
		}
	}

	private boolean validate(String s) {
		Set<Character> set = new HashSet<>();
		for (char c : s.toCharArray()) {
			if (set.contains(c)) {
				return false;
			}
			set.add(c);
		}
		return true;
	}

}
