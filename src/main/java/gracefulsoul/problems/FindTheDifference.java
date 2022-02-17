package gracefulsoul.problems;

public class FindTheDifference {

	// https://leetcode.com/submissions/detail/642948325/
	public static void main(String[] args) {
		FindTheDifference test = new FindTheDifference();
		System.out.println(test.findTheDifference("abcd", "abcde"));
		System.out.println(test.findTheDifference("", "y"));
	}

	public char findTheDifference(String s, String t) {
		char[] sCharArray = s.toCharArray();
		char[] tCharArray = t.toCharArray();
		int diff = 0;
		for (int idx = 0; idx < sCharArray.length; idx++) {
			diff += tCharArray[idx] - sCharArray[idx];
		}
		return (char) (diff + tCharArray[sCharArray.length]);
	}

}
