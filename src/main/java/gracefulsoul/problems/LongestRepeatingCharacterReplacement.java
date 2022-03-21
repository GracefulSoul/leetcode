package gracefulsoul.problems;

public class LongestRepeatingCharacterReplacement {

	// https://leetcode.com/submissions/detail/664142100/
	public static void main(String[] args) {
		LongestRepeatingCharacterReplacement test = new LongestRepeatingCharacterReplacement();
		System.out.println(test.characterReplacement("ABAB", 2));
		System.out.println(test.characterReplacement("AABABBA", 1));
	}

	public int characterReplacement(String s, int k) {
		int[] chars = new int[26];
		int max = 0;
		int maxLength = 0;
		int start = 0;
		int length = s.length();
		char[] charArray = s.toCharArray();
		for (int idx = 0; idx < length; idx++) {
			int num = charArray[idx] - 'A';
			chars[num]++;
			if (chars[num] > max) {
				max = chars[num];
			}
			while (idx - start + 1 > max + k) {
				chars[charArray[start] - 'A']--;
				start++;
			}
			maxLength = Math.max(maxLength, idx - start + 1);
		}
		return maxLength;
	}

}
