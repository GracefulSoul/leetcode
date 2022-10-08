package gracefulsoul.problems;

public class RepeatedStringMatch {

	// https://leetcode.com/submissions/detail/817130482/
	public static void main(String[] args) {
		RepeatedStringMatch test = new RepeatedStringMatch();
		System.out.println(test.repeatedStringMatch("abcd", "cdabcdab"));
		System.out.println(test.repeatedStringMatch("a", "aa"));
	}

	public int repeatedStringMatch(String a, String b) {
		StringBuilder sb = new StringBuilder(a);
		int count = 1;
		while (sb.indexOf(b) == -1) {
			if (sb.length() - a.length() > b.length()) {
				return -1;
			}
			sb.append(a);
			count++;
		}
		return count;
	}

}
