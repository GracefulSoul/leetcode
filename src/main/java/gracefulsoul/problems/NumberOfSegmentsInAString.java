package gracefulsoul.problems;

public class NumberOfSegmentsInAString {

	// https://leetcode.com/submissions/detail/667549397/
	public static void main(String[] args) {
		NumberOfSegmentsInAString test = new NumberOfSegmentsInAString();
		System.out.println(test.countSegments("Hello, my name is John"));
		System.out.println(test.countSegments("Hello"));
	}

	public int countSegments(String s) {
		s = s.trim();
		int length = s.length();
		char[] charArray = s.toCharArray();
		int count = 0;
		if (length == 0) {
			return count;
		} else {
			for (int idx = 0; idx < length; idx++) {
				if (charArray[idx] == ' ' && charArray[idx + 1] != ' ') {
					count++;
				}
			}
			return count + 1;
		}
	}

}
