package gracefulsoul.problems;

import java.util.Arrays;
import java.util.List;

public class GoatLatin {

	// https://leetcode.com/problems/goat-latin/submissions/888773271/
	public static void main(String[] args) {
		GoatLatin test = new GoatLatin();
		System.out.println(test.toGoatLatin("I speak Goat Latin"));
		System.out.println(test.toGoatLatin("The quick brown fox jumped over the lazy dog"));
	}

	public String toGoatLatin(String sentence) {
		List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
		String[] words = sentence.split("\\s");
		StringBuilder sb = new StringBuilder();
		StringBuilder temp = new StringBuilder();
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			if (vowels.contains(word.charAt(0))) {
				temp.append(word);
			} else {
				temp.append(word.substring(1, word.length()));
				temp.append(word.charAt(0));
			}
			temp.append("ma");
			for (int idx = 0; idx <= i; idx++) {
				temp.append('a');
			}
			sb.append(temp);
			if (i != words.length - 1) {
				sb.append(' ');
			}
			temp.delete(0, sb.length());
		}
		return sb.toString();
	}

}
