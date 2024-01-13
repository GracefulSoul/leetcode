package gracefulsoul.problems;

public class MinimumNumberOfStepsToMakeTwoStringsAnagram {

	// https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/submissions/1144726357/
	public static void main(String[] args) {
		MinimumNumberOfStepsToMakeTwoStringsAnagram test = new MinimumNumberOfStepsToMakeTwoStringsAnagram();
		System.out.println(test.minSteps("bab", "aba"));
		System.out.println(test.minSteps("leetcode", "practice"));
		System.out.println(test.minSteps("anagram", "mangaar"));
	}

	public int minSteps(String s, String t) {
		int[] count = new int[26];
		for (int i = 0; i < s.length(); i++) {
			count[s.charAt(i) - 'a']++;
			count[t.charAt(i) - 'a']--;
		}
		int result = 0;
		for (int num : count) {
			if (num > 0) {
				result += num;
			}
		}
		return result;
	}

}
