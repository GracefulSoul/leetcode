package gracefulsoul.problems;

import java.util.Arrays;

public class CountUniqueCharactersOfAllSubstringsOfAGivenString {

	// https://leetcode.com/problems/count-unique-characters-of-all-substrings-of-a-given-string/submissions/890967001/
	public static void main(String[] args) {
		CountUniqueCharactersOfAllSubstringsOfAGivenString test = new CountUniqueCharactersOfAllSubstringsOfAGivenString();
		System.out.println(test.uniqueLetterString("ABC"));
		System.out.println(test.uniqueLetterString("ABA"));
		System.out.println(test.uniqueLetterString("LEETCODE"));
	}

	public int uniqueLetterString(String s) {
		int[] curr = new int[26];
		Arrays.fill(curr, -1);
		int[] last = new int[26];
		Arrays.fill(last, -1);
		int j;
		int count = 0;
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			j = s.charAt(i) - 'A';
			count += i - curr[j] + last[j] - curr[j];
			last[j] = curr[j];
			curr[j] = i;
			result += count;
		}
		return result;
	}

}
