package gracefulsoul.problems;

public class ClearDigits {

	// https://leetcode.com/problems/clear-digits/submissions/1537896195/
	public static void main(String[] args) {
		ClearDigits test = new ClearDigits();
		System.out.println(test.clearDigits("abc"));
		System.out.println(test.clearDigits("cb34"));
	}

	public String clearDigits(String s) {
		StringBuilder sb = new StringBuilder();
		for (char c : s.toCharArray()) {
			if (Character.isDigit(c)) {
				int length = sb.length();
				if (length > 0) {
					sb.deleteCharAt(length - 1);
				}
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}

}
