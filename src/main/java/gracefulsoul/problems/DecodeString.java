package gracefulsoul.problems;

public class DecodeString {

	// https://leetcode.com/submissions/detail/646649651/
	public static void main(String[] args) {
		System.out.println(new DecodeString().decodeString("3[a]2[bc]"));
		System.out.println(new DecodeString().decodeString("3[a2[c]]"));
		System.out.println(new DecodeString().decodeString("2[abc]3[cd]ef"));
	}

	private int index = 0;

	public String decodeString(String s) {
		StringBuilder result = new StringBuilder();
		while (index < s.length() && s.charAt(index) != ']') {
			if (Character.isDigit(s.charAt(index))) {
				int repeat = 0;
				while (Character.isDigit(s.charAt(index))) {
					repeat = (repeat * 10) + (s.charAt(index++) - '0');
				}
				index++;
				String word = this.decodeString(s);
				for (int idx = 0; idx < repeat; idx++) {
					result.append(word);
				}
				index++;
			} else {
				result.append(s.charAt(index++));
			}
		}
		return result.toString();
	}

}
