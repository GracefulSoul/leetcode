package gracefulsoul.problems;

public class MinimumWindowSubstring {

	// https://leetcode.com/submissions/detail/512739432/
	public static void main(String[] args) {
		MinimumWindowSubstring test = new MinimumWindowSubstring();
		System.out.println(test.minWindow("ADOBECODEBANC", "ABC"));
		System.out.println(test.minWindow("a", "a"));
		System.out.println(test.minWindow("a", "aa"));
	}

	public String minWindow(String s, String t) {
		int[] cnt = new int[128];
		for (char c : t.toCharArray()) {
			cnt[c]++;
		}
		int start = 0;
		int end = Integer.MAX_VALUE;
		int counter = t.length();
		for (int i = 0, j = 0; i < s.length(); i++) {
			if (cnt[s.charAt(i)]-- > 0) {
				counter--;
			}
			while (counter == 0) {
				if (i - j + 1 < end) {
					end = i - j + 1;
					start = j;
				}
				if (++cnt[s.charAt(j++)] > 0) {
					counter++;
				}
			}
		}
		return end == Integer.MAX_VALUE ? "" : s.substring(start, start + end);
	}

}
