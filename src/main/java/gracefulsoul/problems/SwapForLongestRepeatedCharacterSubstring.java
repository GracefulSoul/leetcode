package gracefulsoul.problems;

public class SwapForLongestRepeatedCharacterSubstring {

	// https://leetcode.com/problems/swap-for-longest-repeated-character-substring/submissions/1352937240/
	public static void main(String[] args) {
		SwapForLongestRepeatedCharacterSubstring test = new SwapForLongestRepeatedCharacterSubstring();
		System.out.println(test.maxRepOpt1("ababa"));
		System.out.println(test.maxRepOpt1("aaabaaa"));
		System.out.println(test.maxRepOpt1("aaaaa"));
	}

	public int maxRepOpt1(String s) {
		int[] counts = new int[26];
		char[] charArray = s.toCharArray();
		int length = charArray.length;
		for (int i = 0; i < length; i++) {
			counts[charArray[i] - 'a']++;
		}
		int result = 0;
		for (int i = 0; i < length; i++) {
			char curr = charArray[i];
			int j = i;
			int count = 0;
			int diff = 0;
			while (j < length && (curr == charArray[j] || diff == 0) && count < counts[curr - 'a']) {
				if (curr != charArray[j]) {
					diff++;
				}
				count++;
				j++;
			}
			if (count < counts[charArray[i] - 'a'] && diff == 0) {
				count++;
			}
			result = Math.max(result, count);
		}
		return result;
	}

}
