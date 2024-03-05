package gracefulsoul.problems;

public class MinimumLengthOfStringAfterDeletingSimilarEnds {

	// https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends/submissions/1194658563/
	public static void main(String[] args) {
		MinimumLengthOfStringAfterDeletingSimilarEnds test = new MinimumLengthOfStringAfterDeletingSimilarEnds();
		System.out.println(test.minimumLength("ca"));
		System.out.println(test.minimumLength("cabaabac"));
		System.out.println(test.minimumLength("aabccabba"));
	}

	public int minimumLength(String s) {
		char[] charArray = s.toCharArray();
		int left = 0;
		int right = s.length() - 1;
		while (left < right && charArray[left] == charArray[right]) {
			char c = charArray[left];
			while (left <= right && charArray[left] == c) {
				left++;
			}
			while (left <= right && charArray[right] == c) {
				right--;
			}
		}
		return right - left + 1;
	}

}
