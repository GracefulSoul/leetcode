package gracefulsoul.problems;

public class MinimumLengthOfStringAfterDeletingSimilarEnds {

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
			char c = s.charAt(left);
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
