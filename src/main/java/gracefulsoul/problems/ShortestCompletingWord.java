package gracefulsoul.problems;

public class ShortestCompletingWord {

	// https://leetcode.com/submissions/detail/854758252/
	public static void main(String[] args) {
		ShortestCompletingWord test = new ShortestCompletingWord();
		System.out.println(test.shortestCompletingWord("1s3 PSt", new String[] { "step", "steps", "stripe", "stepple" }));
		System.out.println(test.shortestCompletingWord("1s3 456", new String[] { "looks", "pest", "stew", "show" }));
	}

	public String shortestCompletingWord(String licensePlate, String[] words) {
		int[] licenseChars = this.getCharCounts(licensePlate);
		String result = "";
		for (String word : words) {
			if ((result.isEmpty() || result.length() > word.length()) && this.isCompletingWord(licenseChars, this.getCharCounts(word))) {
				result = word;
			}
		}
		return result;
	}

	private boolean isCompletingWord(int[] licenseChars, int[] wordChars) {
		for (int idx = 0; idx < 26; idx++) {
			if (licenseChars[idx] != 0 && licenseChars[idx] > wordChars[idx]) {
				return false;
			}
		}
		return true;
	}

	private int[] getCharCounts(String s) {
		int[] charCounts = new int[26];
		for (char c : s.toCharArray()) {
			if (Character.isLetter(c)) {
				charCounts[Character.toLowerCase(c) - 'a']++;
			}
		}
		return charCounts;
	}

}
