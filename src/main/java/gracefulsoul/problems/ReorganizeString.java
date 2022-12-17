package gracefulsoul.problems;

public class ReorganizeString {

	// https://leetcode.com/problems/reorganize-string/submissions/860926244/
	public static void main(String[] args) {
		ReorganizeString test = new ReorganizeString();
		System.out.println(test.reorganizeString("aab"));
		System.out.println(test.reorganizeString("aaab"));
	}

	public String reorganizeString(String s) {
		int length = s.length();
		int[] hash = new int[26];
		for (char c : s.toCharArray()) {
			hash[c - 'a']++;
		}
		int letter = 0;
		int count = 0;
		for (int idx = 0; idx < hash.length; idx++) {
			if (hash[idx] > count) {
				letter = idx;
				count = hash[idx];
			}
		}
		if (count > (length + 1) / 2) {
			return "";
		}
		char[] result = new char[length];
		int index = 0;
		while (hash[letter] > 0) {
			result[index] = (char) (letter + 'a');
			index += 2;
			hash[letter]--;
		}
		for (int idx = 0; idx < hash.length; idx++) {
			while (hash[idx] > 0) {
				if (index >= result.length) {
					index = 1;
				}
				result[index] = (char) (idx + 'a');
				index += 2;
				hash[idx]--;
			}
		}
		return String.valueOf(result);
	}

}
