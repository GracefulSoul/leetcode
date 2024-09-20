package gracefulsoul.problems;

public class MaximumNumberOfBalloons {

	// https://leetcode.com/problems/maximum-number-of-balloons/submissions/1396513929/
	public static void main(String[] args) {
		MaximumNumberOfBalloons test = new MaximumNumberOfBalloons();
		System.out.println(test.maxNumberOfBalloons("nlaebolko"));
		System.out.println(test.maxNumberOfBalloons("loonbalxballpoon"));
		System.out.println(test.maxNumberOfBalloons("leetcode"));
	}

	public int maxNumberOfBalloons(String text) {
		int[] count = new int[26];
		for (char c : text.toCharArray()) {
			count[c - 'a']++;
		}
		int result = count[1];
		result = Math.min(result, count[0]);
		result = Math.min(result, count[11] / 2);
		result = Math.min(result, count[14] / 2);
		result = Math.min(result, count[13]);
		return result;
	}

}
