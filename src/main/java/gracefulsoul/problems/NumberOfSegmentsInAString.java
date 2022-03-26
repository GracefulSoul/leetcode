package gracefulsoul.problems;

public class NumberOfSegmentsInAString {

	// https://leetcode.com/submissions/detail/667546090/
	public static void main(String[] args) {
		NumberOfSegmentsInAString test = new NumberOfSegmentsInAString();
		System.out.println(test.countSegments("Hello, my name is John"));
		System.out.println(test.countSegments("Hello"));
	}

	public int countSegments(String s) {
		int length = s.length();
		char[] charArray = s.toCharArray();
		if (length == 0) {
			return 0;
		}
		int count = charArray[0] != ' ' ? 1 : 0;
		for (int i = 1; i < length; i++) {
			if (charArray[i] != ' ' && charArray[i - 1] == ' ') {
				count++;
			}
		}
		return count;
	}

}
