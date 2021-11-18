package gracefulsoul.problems;

public class ValidAnagram {

	// https://leetcode.com/submissions/detail/589062480/
	public static void main(String[] args) {
		ValidAnagram test = new ValidAnagram();
		System.out.println(test.isAnagram("anagram", "nagaram"));
		System.out.println(test.isAnagram("rat", "car"));
	}

	public boolean isAnagram(String s, String t) {
		int[] alphabet = new int[26];
		for (char c : s.toCharArray()) {
			alphabet[c - 'a']++;
		}
		for (char c : t.toCharArray()) {
			alphabet[c - 'a']--;
		}
		for (int idx = 0; idx < alphabet.length; idx++) {
			if (alphabet[idx] != 0) {
				return false;
			}
		}
		return true;
	}

}
