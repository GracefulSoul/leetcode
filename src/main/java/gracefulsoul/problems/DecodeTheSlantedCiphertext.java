package gracefulsoul.problems;

public class DecodeTheSlantedCiphertext {

	// https://leetcode.com/problems/decode-the-slanted-ciphertext/submissions/1968593095/
	public static void main(String[] args) {
		DecodeTheSlantedCiphertext test = new DecodeTheSlantedCiphertext();
		System.out.println(test.decodeCiphertext("ch   ie   pr", 3));
		System.out.println(test.decodeCiphertext("iveo    eed   l te   olc", 4));
		System.out.println(test.decodeCiphertext("coding", 1));
	}

	public String decodeCiphertext(String encodedText, int rows) {
		if (rows == 1) {
			return encodedText;
		}
		int length = encodedText.length();
		int cols = length / rows;
		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < cols; i++) {
			for (int j = 0, k = i; j < rows && k < cols; j++, k++) {
				sb.append(encodedText.charAt((j * cols) + k));
			}
		}
		int i = sb.length() - 1;
		while (i >= 0 && sb.charAt(i) == ' ') {
			i--;
		}
		return sb.substring(0, i + 1);
	}

}
