package gracefulsoul.problems;

public class LongestSubstringWithAtLeastKRepeatingCharacters {

	// https://leetcode.com/submissions/detail/647324741/
	public static void main(String[] args) {
		LongestSubstringWithAtLeastKRepeatingCharacters test = new LongestSubstringWithAtLeastKRepeatingCharacters();
		System.out.println(test.longestSubstring("aaabb", 3));
		System.out.println(test.longestSubstring("ababbc", 2));
	}

	public int longestSubstring(String s, int k) {
		return this.recursive(s, k, 0, s.length());
	}

	private int recursive(String s, int k, int start, int end) {
		if (end < k) {
			return 0;
		}
		int[] count = new int[26];
		char[] charArray = s.toCharArray();
		for (int i = start; i < end; i++) {
			count[charArray[i] - 'a']++;
		}
		for (int mid = start; mid < end; mid++) {
			if (count[charArray[mid] - 'a'] >= k) {
				continue;
			}
			int next = mid + 1;
			while (next < end && count[charArray[next] - 'a'] < k) {
				next++;
			}
			return Math.max(this.recursive(s, k, start, mid), this.recursive(s, k, next, end));
		}
		return end - start;
	}

}
