package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class AmbiguousCoordinates {

	// https://leetcode.com/problems/ambiguous-coordinates/submissions/884958579/
	public static void main(String[] args) {
		AmbiguousCoordinates test = new AmbiguousCoordinates();
		System.out.println(test.ambiguousCoordinates("(123)"));
		System.out.println(test.ambiguousCoordinates("(0123)"));
		System.out.println(test.ambiguousCoordinates("(00011)"));
	}

	public List<String> ambiguousCoordinates(String s) {
		List<String> result = new ArrayList<>();
		int length = s.length();
		for (int idx = 1; idx < length - 2; idx++) {
			List<String> left = this.makeCoordinates(s.substring(1, idx + 1));
			List<String> right = this.makeCoordinates(s.substring(idx + 1, length - 1));
			for (String x : left) {
				for (String y : right) {
					result.add("(" + x + ", " + y + ")");
				}
			}
		}
		return result;
	}

	private List<String> makeCoordinates(String s) {
		List<String> list = new ArrayList<>();
		for (int idx = 1; idx <= s.length(); idx++) {
			String left = s.substring(0, idx);
			String right = s.substring(idx);
			if ((left.length() > 1 && left.charAt(0) == '0') || (right.length() > 0 && right.charAt(right.length() - 1) == '0')) {
				continue;
			}
			if (right.isEmpty()) {
				list.add(left);
			} else {
				list.add(left + "." + right);
			}
		}
		return list;
	}

}
