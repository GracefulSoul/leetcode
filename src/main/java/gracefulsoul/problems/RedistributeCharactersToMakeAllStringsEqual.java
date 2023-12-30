package gracefulsoul.problems;

public class RedistributeCharactersToMakeAllStringsEqual {

	// https://leetcode.com/problems/redistribute-characters-to-make-all-strings-equal/submissions/1131800958/
	public static void main(String[] args) {
		RedistributeCharactersToMakeAllStringsEqual test = new RedistributeCharactersToMakeAllStringsEqual();
		System.out.println(test.makeEqual(new String[] { "abc", "aabc", "bc" }));
		System.out.println(test.makeEqual(new String[] { "ab", "a" }));
	}

	public boolean makeEqual(String[] words) {
		int length = words.length;
		if (length == 1) {
			return true;
		}
		int wordsLength = 0;
		for (String s : words) {
			wordsLength += s.length();
		}
		if (wordsLength % length != 0) {
			return false;
		}
		int[] counts = new int[26];
		for (String s : words) {
			wordsLength += s.length();
			for (char c : s.toCharArray()) {
				counts[c - 'a']++;
			}
		}
		for (int count : counts) {
			if (count % length != 0) {
				return false;
			}
		}
		return true;
	}

}
