package gracefulsoul.problems;

public class RemoveAllAdjacentDuplicatesInStringII {

	// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/submissions/1417886947/
	public static void main(String[] args) {
		RemoveAllAdjacentDuplicatesInStringII test = new RemoveAllAdjacentDuplicatesInStringII();
		System.out.println(test.removeDuplicates("abcd", 2));
		System.out.println(test.removeDuplicates("deeedbbcccbdaa", 3));
		System.out.println(test.removeDuplicates("pbbcggttciiippooaais", 2));
	}

	public String removeDuplicates(String s, int k) {
		int[] count = new int[s.length()];
		StringBuilder sb = new StringBuilder();
		for (char c : s.toCharArray()) {
			sb.append(c);
			int length = sb.length();
			int i = length - 1;
			count[i] = 1 + (i > 0 && sb.charAt(i) == sb.charAt(i - 1) ? count[i - 1] : 0);
			if (count[i] >= k) {
				sb.delete(length - k, length);
			}
		}
		return sb.toString();
	}

}
