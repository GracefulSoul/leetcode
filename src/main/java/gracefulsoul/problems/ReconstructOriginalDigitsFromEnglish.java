package gracefulsoul.problems;

public class ReconstructOriginalDigitsFromEnglish {

	// https://leetcode.com/submissions/detail/663411450/
	public static void main(String[] args) {
		ReconstructOriginalDigitsFromEnglish test = new ReconstructOriginalDigitsFromEnglish();
		System.out.println(test.originalDigits("owoztneoer"));
		System.out.println(test.originalDigits("fviefuro"));
	}

	public String originalDigits(String s) {
		char[] charCount = new char[26 + 'a'];
		for (char c : s.toCharArray()) {
			charCount[c]++;
		}
		int[] count = new int[10];
		count[0] = charCount['z'];
		count[2] = charCount['w'];
		count[4] = charCount['u'];
		count[6] = charCount['x'];
		count[8] = charCount['g'];
		count[3] = charCount['h'] - count[8];
		count[5] = charCount['f'] - count[4];
		count[7] = charCount['s'] - count[6];
		count[9] = charCount['i'] - count[6] - count[5] - count[8];
		count[1] = charCount['n'] - count[7] - (2 * count[9]);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < count[i]; j++) {
				sb.append(i);
			}
		}
		return sb.toString();
	}

}
