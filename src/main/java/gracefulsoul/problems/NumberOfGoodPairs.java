package gracefulsoul.problems;

public class NumberOfGoodPairs {

	// https://leetcode.com/problems/number-of-good-pairs/submissions/1065433628/
	public static void main(String[] args) {
		NumberOfGoodPairs test = new NumberOfGoodPairs();
		System.out.println(test.numIdenticalPairs(new int[] { 1, 2, 3, 1, 1, 3 }));
		System.out.println(test.numIdenticalPairs(new int[] { 1, 1, 1, 1 }));
		System.out.println(test.numIdenticalPairs(new int[] { 1, 2, 3 }));
	}

	public int numIdenticalPairs(int[] nums) {
		int result = 0;
		int[] count = new int[101];
		for (int num : nums) {
			result += count[num]++;
		}
		return result;
	}

}
