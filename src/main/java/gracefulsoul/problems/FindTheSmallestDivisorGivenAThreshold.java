package gracefulsoul.problems;

public class FindTheSmallestDivisorGivenAThreshold {

	// https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/submissions/1728505932/
	public static void main(String[] args) {
		FindTheSmallestDivisorGivenAThreshold test = new FindTheSmallestDivisorGivenAThreshold();
		System.out.println(test.smallestDivisor(new int[] { 1, 2, 5, 9 }, 6));
		System.out.println(test.smallestDivisor(new int[] { 44, 22, 33, 11, 1 }, 5));
	}

	public int smallestDivisor(int[] nums, int threshold) {
		int left = 1;
		int right = (int) 1e6;
		while (left < right) {
			int mid = (left + right) / 2;
			int sum = 0;
			for (int num : nums) {
				sum += (num + mid - 1) / mid;
			}
			if (sum > threshold) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return left;
	}

}
