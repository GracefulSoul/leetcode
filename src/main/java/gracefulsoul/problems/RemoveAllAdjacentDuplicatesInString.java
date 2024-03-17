package gracefulsoul.problems;

public class RemoveAllAdjacentDuplicatesInString {

	// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/submissions/1205892792/
	public static void main(String[] args) {
		RemoveAllAdjacentDuplicatesInString test = new RemoveAllAdjacentDuplicatesInString();
		System.out.println(test.removeDuplicates("abbaca"));
		System.out.println(test.removeDuplicates("azxxzy"));
	}

	public String removeDuplicates(String s) {
		StringBuilder sb = new StringBuilder();
		for (char c : s.toCharArray()) {
			if (sb.length() > 0 && sb.charAt(sb.length() - 1) == c) {
				sb.deleteCharAt(sb.length() - 1);
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}

}
