package gracefulsoul.problems;

public class ReorganizeString {

	// https://leetcode.com/problems/reorganize-string/submissions/860928612/
	public static void main(String[] args) {
		ReorganizeString test = new ReorganizeString();
		System.out.println(test.reorganizeString("aab"));
		System.out.println(test.reorganizeString("aaab"));
	}

	public String reorganizeString(String s) {
		int length = s.length();
		int[] counts = new int[26];
		for (char c : s.toCharArray()) {
			counts[c - 'a']++;
		}
		int letter = 0;
		int count = 0;
		for (int idx = 0; idx < counts.length; idx++) {
			if (counts[idx] > count) {
				letter = idx;
				count = counts[idx];
			}
		}
		if (count > (length + 1) / 2) {
			return "";
		}
		char[] result = new char[length];
		int index = 0;
		while (counts[letter] > 0) {
			result[index] = (char) (letter + 'a');
			index += 2;
			counts[letter]--;
		}
		for (int idx = 0; idx < counts.length; idx++) {
			while (counts[idx] > 0) {
				if (index >= result.length) {
					index = 1;
				}
				result[index] = (char) (idx + 'a');
				index += 2;
				counts[idx]--;
			}
		}
		return String.valueOf(result);
	}

}
