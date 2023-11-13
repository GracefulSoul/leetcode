package gracefulsoul.problems;

import java.util.Arrays;

public class SortVowelsInAString {

	// https://leetcode.com/problems/sort-vowels-in-a-string/submissions/1097866219/
	public static void main(String[] args) {
		SortVowelsInAString test = new SortVowelsInAString();
		System.out.println(test.sortVowels("lEetcOde"));
		System.out.println(test.sortVowels("lYmpH"));
	}

	public String sortVowels(String s) {
		String vowels = "aeiouAEIOU";
		char[] charArray = s.toCharArray();
		int length = charArray.length;
		char[] vowelArray = new char[length];
		int i = 0;
		for (char c : charArray) {
			if (vowels.indexOf(c) != -1) {
				vowelArray[i++] = c;
			}
		}
		Arrays.sort(vowelArray, 0, i);
		StringBuilder sb = new StringBuilder();
		for (int j = i = 0; i < charArray.length; i++) {
			if (vowels.indexOf(charArray[i]) != -1) {
				sb.append(vowelArray[j++]);
			} else {
				sb.append(charArray[i]);
			}
		}
		return sb.toString();
	}

}
