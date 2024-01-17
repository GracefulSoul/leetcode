package gracefulsoul.problems;

import java.util.ArrayList;
import java.util.List;

public class CamelcaseMatching {

	// https://leetcode.com/problems/camelcase-matching/submissions/1149611885/
	public static void main(String[] args) {
		CamelcaseMatching test = new CamelcaseMatching();
		test.camelMatch(new String[] { "FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack" }, "FB");
		test.camelMatch(new String[] { "FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack" }, "FoBa");
		test.camelMatch(new String[] { "FooBar", "FooBarTest", "FootBall", "FrameBuffer", "ForceFeedBack" }, "FoBaT");
	}

	public List<Boolean> camelMatch(String[] queries, String pattern) {
		List<Boolean> result = new ArrayList<>();
		for (String query : queries) {
			result.add(this.isMatch(query, pattern));
		}
		return result;
	}

	private boolean isMatch(String query, String pattern) {
		int i = 0;
		for (char c : query.toCharArray()) {
			if (i < pattern.length() && c == pattern.charAt(i)) {
				i++;
			} else if (c < 'a') {
				return false;
			}
		}
		return i == pattern.length();
	}

}
