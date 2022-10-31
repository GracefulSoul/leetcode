package gracefulsoul.problems;

public class ToLowerCase {

	// https://leetcode.com/submissions/detail/833915919/
	public static void main(String[] args) {
		ToLowerCase test = new ToLowerCase();
		System.out.println(test.toLowerCase("Hello"));
		System.out.println(test.toLowerCase("here"));
		System.out.println(test.toLowerCase("LOVELY"));
	}

	public String toLowerCase(String s) {
		char[] charArray = s.toCharArray();
		StringBuilder sb = new StringBuilder(charArray.length);
		for (char c : charArray) {
			if (c >= 'A' && c <= 'Z') {
				sb.append((char) (c + 32));
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}

}
