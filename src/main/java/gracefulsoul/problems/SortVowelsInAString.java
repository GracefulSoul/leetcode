package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortVowelsInAString {

	// https://leetcode.com/problems/sort-vowels-in-a-string/submissions/1097845551/
	public static void main(String[] args) {
		SortVowelsInAString test = new SortVowelsInAString();
		System.out.println(test.sortVowels("lEetcOde"));
		System.out.println(test.sortVowels("lYmpH"));
	}

	public String sortVowels(String s) {
		String vowels = "aeiouAEIOU";
		char[] charArray = s.toCharArray();
		List<Character> list = new ArrayList<>();
		for (char c : charArray) {
			if (vowels.indexOf(c) != -1) {
				list.add(c);
			}
		}
		Collections.sort(list, Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();
		for (char c : charArray) {
			if (vowels.indexOf(c) != -1) {
				sb.append(list.remove(list.size() - 1));
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}

}
