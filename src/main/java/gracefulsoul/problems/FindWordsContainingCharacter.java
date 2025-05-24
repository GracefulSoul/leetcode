package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class FindWordsContainingCharacter {

	// https://leetcode.com/problems/find-words-containing-character/submissions/1643050056/
	public static void main(String[] args) {
		FindWordsContainingCharacter test = new FindWordsContainingCharacter();
		System.out.println(test.findWordsContaining(new String[] { "leet", "code" }, 'e'));
		System.out.println(test.findWordsContaining(new String[] { "abc", "bcd", "aaaa", "cbc" }, 'a'));
		System.out.println(test.findWordsContaining(new String[] { "abc", "bcd", "aaaa", "cbc" }, 'z'));
	}

	public List<Integer> findWordsContaining(String[] words, char x) {
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < words.length; i++) {
			if (words[i].indexOf(x) != -1) {
				result.add(i);
			}
		}
		return result;
	}

}
