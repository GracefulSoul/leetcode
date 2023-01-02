package gracefulsoul.problems;

public class CustomSortString {

	// https://leetcode.com/problems/custom-sort-string/submissions/869661453/
	public static void main(String[] args) {
		CustomSortString test = new CustomSortString();
		System.out.println(test.customSortString("cba", "abcd"));
		System.out.println(test.customSortString("cbafg", "abcd"));
	}

	public String customSortString(String order, String s) {
		int[] count = new int[26];
		for (char c : s.toCharArray()) {
			count[c - 'a']++;
		}
		StringBuilder sb = new StringBuilder();
		for (char c : order.toCharArray()) {
			while (count[c - 'a']-- > 0) {
				sb.append(c);
			}
		}
		for (int idx = 0; idx < count.length; idx++) {
			while (count[idx]-- > 0) {
				sb.append((char) ('a' + idx));
			}
		}
		return sb.toString();
	}

}
