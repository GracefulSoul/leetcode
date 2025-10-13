package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindResultantArrayAfterRemovingAnagrams {

	// https://leetcode.com/problems/find-resultant-array-after-removing-anagrams/submissions/1800205110/
	public static void main(String[] args) {
		FindResultantArrayAfterRemovingAnagrams test = new FindResultantArrayAfterRemovingAnagrams();
		System.out.println(test.removeAnagrams(new String[] { "abba", "baba", "bbaa", "cd", "cd" }));
		System.out.println(test.removeAnagrams(new String[] { "a", "b", "c", "d", "e" }));
	}

	public List<String> removeAnagrams(String[] words) {
		String prev = "";
		List<String> result = new ArrayList<>();
		for (String word : words) {
			char[] charArray = word.toCharArray();
			Arrays.sort(charArray);
			String curr = String.valueOf(charArray);
			if (!curr.equals(prev)) {
				result.add(word);
				prev = curr;
			}
		}
		return result;
	}

}
