package gracefulsoul.problems;

public class CheckIfBinaryStringHasAtMostOneSegmentOfOnes {

	// https://leetcode.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones/submissions/1939761832/
	public static void main(String[] args) {
		CheckIfBinaryStringHasAtMostOneSegmentOfOnes test = new CheckIfBinaryStringHasAtMostOneSegmentOfOnes();
		System.out.println(test.checkOnesSegment("1001"));
		System.out.println(test.checkOnesSegment("110"));
	}

	public boolean checkOnesSegment(String s) {
		return !s.contains("01");
	}

}
