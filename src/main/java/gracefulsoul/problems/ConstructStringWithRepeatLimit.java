package gracefulsoul.problems;

public class ConstructStringWithRepeatLimit {

	// https://leetcode.com/problems/construct-string-with-repeat-limit/submissions/1481155611/
	public static void main(String[] args) {
		ConstructStringWithRepeatLimit test = new ConstructStringWithRepeatLimit();
		System.out.println(test.repeatLimitedString("cczazcc", 3));
		System.out.println(test.repeatLimitedString("aababab", 2));
	}

	public String repeatLimitedString(String s, int repeatLimit) {
		int[] counts = new int[26];
		for (char c : s.toCharArray()) {
			counts[c - 'a']++;
		}
		int index = -1;
		StringBuilder sb = new StringBuilder();
		for (int i = 25; i >= 0; i--) {
			if (counts[i] == 0) {
				continue;
			}
			if (index > 0) {
				sb.append((char) ('a' + i));
				counts[i]--;
				i = index;
				index = -1;
			} else {
				for (int j = 0; j < repeatLimit && counts[i] > 0; j++, counts[i]--) {
					sb.append((char) ('a' + i));
				}
				if (counts[i] > 0) {
					index = i + 1;
				}
			}
		}
		return sb.toString();
	}

}
