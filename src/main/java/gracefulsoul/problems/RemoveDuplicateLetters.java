package gracefulsoul.problems;

public class RemoveDuplicateLetters {

	// https://leetcode.com/submissions/detail/606896008/
	public static void main(String[] args) {
		RemoveDuplicateLetters test = new RemoveDuplicateLetters();
		System.out.println(test.removeDuplicateLetters("bcabc"));
		System.out.println(test.removeDuplicateLetters("cbacdcbc"));
	}

	public String removeDuplicateLetters(String s) {
		StringBuilder sb = new StringBuilder();
		int[] count = new int[26];
		boolean[] chars = new boolean[26];
		for (char c : s.toCharArray()) {
			count[c - 'a'] += 1;
		}
		for (int i = 0, j = 0; i < s.length(); i++) {
			char curr = s.charAt(i);
			if (!chars[curr - 'a']) {
				while (j > 0 && sb.charAt(j - 1) > curr && count[sb.charAt(j - 1) - 'a'] > 0) {
					chars[sb.charAt(j - 1) - 'a'] = false;
					sb.deleteCharAt(j - 1);
					j--;
				}
				sb.append(curr);
				chars[curr - 'a'] = true;
				j++;
			}
			count[curr - 'a'] -= 1;
		}
		return sb.toString();
	}

}
