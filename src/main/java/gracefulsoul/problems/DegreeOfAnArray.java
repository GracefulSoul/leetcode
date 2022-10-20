package gracefulsoul.problems;

public class DegreeOfAnArray {

	// https://leetcode.com/submissions/detail/826550429/
	public static void main(String[] args) {
		DegreeOfAnArray test = new DegreeOfAnArray();
		System.out.println(test.findShortestSubArray(new int[] { 1, 2, 2, 3, 1 }));
		System.out.println(test.findShortestSubArray(new int[] { 1, 2, 2, 3, 1, 4, 2 }));
	}

	public int findShortestSubArray(int[] nums) {
		int degree = 0;
		for (int num : nums) {
			degree = Math.max(degree, num);
		}
		int[] count = new int[degree + 1];
		int[] first = new int[degree + 1];
		int[] last = new int[degree + 1];
		int max = 1;
		for (int idx = 0; idx < nums.length; idx++) {
			count[nums[idx]]++;
			max = Math.max(max, count[nums[idx]]);
			if (first[nums[idx]] == 0) {
				first[nums[idx]] = idx + 1;
			}
			last[nums[idx]] = idx + 1;
		}
		int result = Integer.MAX_VALUE;
		for (int idx = 0; idx < count.length; idx++) {
			if (count[idx] == max) {
				result = Math.min(result, last[idx] - first[idx] + 1);
			}
		}
		return result;
	}

}
