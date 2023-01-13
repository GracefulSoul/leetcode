package gracefulsoul.problems;

import java.util.HashSet;
import java.util.Set;

public class UniqueMorseCodeWords {

	// https://leetcode.com/problems/unique-morse-code-words/submissions/877714815/
	public static void main(String[] args) {
		UniqueMorseCodeWords test = new UniqueMorseCodeWords();
		System.out.println(test.uniqueMorseRepresentations(new String[] { "gin", "zen", "gig", "msg" }));
		System.out.println(test.uniqueMorseRepresentations(new String[] { "a" }));
	}

	private static String[] LETTERS = new String[] {
		".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---",
		".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."
	};
	
	public int uniqueMorseRepresentations(String[] words) {
		Set<String> set = new HashSet<>();
		for (String word : words) {
			StringBuilder sb = new StringBuilder();
			for (char c : word.toCharArray()) {
				sb.append(LETTERS[c - 'a']);
			}
			set.add(sb.toString());
		}
		return set.size();
	}

}
