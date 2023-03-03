package gracefulsoul.problems;

public class BuddyStrings {

	// https://leetcode.com/problems/buddy-strings/submissions/908276074/
	public static void main(String[] args) {
		BuddyStrings test = new BuddyStrings();
		System.out.println(test.buddyStrings("ab", "ba"));
		System.out.println(test.buddyStrings("ab", "ab"));
		System.out.println(test.buddyStrings("aa", "aa"));
	}

	public boolean buddyStrings(String s, String goal) {
		if (s.length() != goal.length()) {
			return false;
		}
		char[] sCharArray = s.toCharArray();
		char[] goalCharArray = goal.toCharArray();
		int[] count = new int[26];
		if (s.equals(goal)) {
			for (char c : sCharArray) {
				count[c - 'a']++;
				if (count[c - 'a'] > 1) {
					return true;
				}
			}
			return false;
		}
		int left = 0;
		int right = s.length() - 1;
		while (sCharArray[left] == goalCharArray[left] && left < right) {
			left++;
		}
		while (sCharArray[right] == goalCharArray[right] && left < right) {
			right--;
		}
		char temp = sCharArray[left];
		sCharArray[left] = sCharArray[right];
		sCharArray[right] = temp;
		if (sCharArray[left] != goalCharArray[left] || sCharArray[right] != goalCharArray[right]) {
			return false;
		}
		while (left++ < right--) {
			if (sCharArray[left] != goalCharArray[left] || sCharArray[right] != goalCharArray[right]) {
				return false;
			}
		}
		return true;
	}

}
