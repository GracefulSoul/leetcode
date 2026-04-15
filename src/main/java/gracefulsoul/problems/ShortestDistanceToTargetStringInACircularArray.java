package gracefulsoul.problems;

public class ShortestDistanceToTargetStringInACircularArray {

	// https://leetcode.com/problems/shortest-distance-to-target-string-in-a-circular-array/submissions/1979070218/
	public static void main(String[] args) {
		ShortestDistanceToTargetStringInACircularArray test = new ShortestDistanceToTargetStringInACircularArray();
		System.out.println(test.closestTarget(new String[] { "hello", "i", "am", "leetcode", "hello" }, "hello", 1));
		System.out.println(test.closestTarget(new String[] { "a", "b", "leetcode" }, "leetcode", 0));
		System.out.println(test.closestTarget(new String[] { "i", "eat", "leetcode" }, "ate", 0));
	}

	public int closestTarget(String[] words, String target, int startIndex) {
		int result = Integer.MAX_VALUE;
		int length = words.length;
		for (int i = 0; i < length; i++) {
			if (target.equals(words[i])) {
				int distance = Math.abs(i - startIndex);
				result = Math.min(result, distance);
				result = Math.min(result, length - distance);
			}
		}
		return result == Integer.MAX_VALUE ? -1 : result;
	}

}
