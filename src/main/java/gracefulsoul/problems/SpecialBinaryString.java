package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpecialBinaryString {

	// https://leetcode.com/problems/special-binary-string/submissions/858092715/
	public static void main(String[] args) {
		SpecialBinaryString test = new SpecialBinaryString();
		System.out.println(test.makeLargestSpecial("11011000"));
		System.out.println(test.makeLargestSpecial("10"));
	}

	public String makeLargestSpecial(String s) {
		int start = 0;
		int height = 0;
		List<String> mountains = new ArrayList<>();
		for (int i = 0; i < s.length(); ++i) {
			height += s.charAt(i) == '1' ? 1 : -1;
			if (height == 0) {
				mountains.add("1" + this.makeLargestSpecial(s.substring(start + 1, i)) + "0");
				start = i + 1;
			}
		}
		mountains.sort(Collections.reverseOrder());
		StringBuilder sb = new StringBuilder();
		for (String mountain : mountains) {
			sb.append(mountain);
		}
		return sb.toString();
	}

}
