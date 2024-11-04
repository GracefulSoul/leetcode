package gracefulsoul.problems;

public class StringCompressionIII {

	// https://leetcode.com/problems/string-compression-iii/submissions/1442575588/
	public static void main(String[] args) {
		StringCompressionIII test = new StringCompressionIII();
		System.out.println(test.compressedString("abcde"));
		System.out.println(test.compressedString("aaaaaaaaaaaaaabb"));
	}

	public String compressedString(String word) {
		StringBuilder sb = new StringBuilder();
		int count = 1;
		char c = word.charAt(0);
		for (int i = 1; i < word.length(); i++) {
			if (c == word.charAt(i) && count < 9) {
				count++;
			} else {
				sb.append(count).append(c);
				c = word.charAt(i);
				count = 1;
			}
		}
		return sb.append(count).append(c).toString();
	}

}
