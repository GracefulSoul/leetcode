package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class StringMatchingInAnArray {

	// https://leetcode.com/problems/string-matching-in-an-array/submissions/1500510393/
	public static void main(String[] args) {
		StringMatchingInAnArray test = new StringMatchingInAnArray();
		System.out.println(test.stringMatching(new String[] { "mass", "as", "hero", "superhero" }));
		System.out.println(test.stringMatching(new String[] { "leetcode", "et", "code" }));
		System.out.println(test.stringMatching(new String[] { "blue", "green", "bu" }));
	}

	public List<String> stringMatching(String[] words) {
		String str = String.join(" ", words);
		List<String> result = new ArrayList<>();
		for (String word : words) {
			if (str.indexOf(word) != str.lastIndexOf(word)) {
				result.add(word);
			}
		}
		return result;
	}

}
