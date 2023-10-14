package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class FindCommonCharacters {

	// https://leetcode.com/problems/find-common-characters/submissions/1074734484/
	public static void main(String[] args) {
		FindCommonCharacters test = new FindCommonCharacters();
		System.out.println(test.commonChars(new String[] { "bella", "label", "roller" }));
		System.out.println(test.commonChars(new String[] { "cool", "lock", "cook" }));
	}

	public List<String> commonChars(String[] words) {
		int length = words.length;
		int[][] count = new int[length][26];
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < words[i].length(); j++) {
				count[i][words[i].charAt(j) - 'a']++;
			}
		}
		List<String> result = new ArrayList<>();
		for (int j = 0; j < 26; j++) {
			int min = 101;
			for (int i = 0; i < length; i++) {
				min = Math.min(min, count[i][j]);
			}
			while (min-- > 0) {
				result.add(String.valueOf((char) (j + 'a')));
			}
		}
		return result;
	}

}
