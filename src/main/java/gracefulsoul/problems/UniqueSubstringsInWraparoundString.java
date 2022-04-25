package gracefulsoul.problems;

public class UniqueSubstringsInWraparoundString {

	// https://leetcode.com/submissions/detail/686925925/
	public static void main(String[] args) {
		UniqueSubstringsInWraparoundString test = new UniqueSubstringsInWraparoundString();
		test.findSubstringInWraproundString("a");
		test.findSubstringInWraproundString("cac");
		test.findSubstringInWraproundString("zab");
	}

	public int findSubstringInWraproundString(String p) {
		char[] charArray = p.toCharArray();
		int[] max = new int[26];
		max[charArray[0] - 'a'] = 1;
		int sum = 1;
		int length = 1;
		for (int idx = 1; idx < p.length(); idx++) {
			int diff = charArray[idx] - charArray[idx - 1];
			if (diff == 1 || diff == -25) {
				length++;
			} else {
				length = 1;
			}
			int index = charArray[idx] - 'a';
			if (length > max[index]) {
				sum += length - max[index];
				max[index] = length;
			}
		}
		return sum;
	}

}
