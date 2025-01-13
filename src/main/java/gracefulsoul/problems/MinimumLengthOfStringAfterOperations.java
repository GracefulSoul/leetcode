package gracefulsoul.problems;

public class MinimumLengthOfStringAfterOperations {

	// https://leetcode.com/problems/minimum-length-of-string-after-operations/submissions/1507077709/
	public static void main(String[] args) {
		MinimumLengthOfStringAfterOperations test = new MinimumLengthOfStringAfterOperations();
		System.out.println(test.minimumLength("abaacbcbb"));
		System.out.println(test.minimumLength("aa"));
	}

	public int minimumLength(String s) {
		int[] counts = new int[26];
		for (char c : s.toCharArray()) {
			counts[c - 'a']++;
		}
		int result = 0;
		for (int count : counts) {
			if (count > 0) {
				if (count % 2 == 0) {
					result += 2;
				} else {
					result++;
				}
			}
		}
		return result;
	}

}
