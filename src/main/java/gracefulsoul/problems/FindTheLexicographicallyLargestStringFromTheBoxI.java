package gracefulsoul.problems;

public class FindTheLexicographicallyLargestStringFromTheBoxI {

	// https://leetcode.com/problems/find-the-lexicographically-largest-string-from-the-box-i/submissions/1653582548/
	public static void main(String[] args) {
		FindTheLexicographicallyLargestStringFromTheBoxI test = new FindTheLexicographicallyLargestStringFromTheBoxI();
		System.out.println(test.answerString("dbca", 2));
		System.out.println(test.answerString("gggg", 4));
	}

	public String answerString(String word, int numFriends) {
		if (numFriends == 1) {
			return word;
		} else {
			int length = word.length();
			int start = length - numFriends + 1;
			String result = "";
			String curr;
			for (int i = 0; i < length; i++) {
				curr = word.substring(i, Math.min(start + i, length));
				if (result.compareTo(curr) < 0) {
					result = curr;
				}
			}
			return result;
		}
	}

}
