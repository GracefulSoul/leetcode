package gracefulsoul.problems;

public class MaximumLengthSubstringWithTwoOccurrences {

	// https://leetcode.com/problems/maximum-length-substring-with-two-occurrences/submissions/2106505701/
	public static void main(String[] args) {
		MaximumLengthSubstringWithTwoOccurrences test = new MaximumLengthSubstringWithTwoOccurrences();
		System.out.println(test.maximumLengthSubstring("bcbbbcba"));
		System.out.println(test.maximumLengthSubstring("aaaa"));
	}

	public int maximumLengthSubstring(String s) {
		char[] charArray = s.toCharArray();
		int[] counts = new int[26];
		int result = 0;
		for (int i = 0, j = 0; j < charArray.length; j++) {
			int num = charArray[j] - 'a';
			counts[num]++;
			while (2 < counts[num]) {
				counts[charArray[i++] - 'a']--;
			}
			result = Math.max(result, j - i + 1);
		}
		return result;
	}

}
