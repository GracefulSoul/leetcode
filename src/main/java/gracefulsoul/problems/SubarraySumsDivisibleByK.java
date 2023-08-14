package gracefulsoul.problems;

public class SubarraySumsDivisibleByK {

	// https://leetcode.com/problems/subarray-sums-divisible-by-k/submissions/1021038967/
	public static void main(String[] args) {
		SubarraySumsDivisibleByK test = new SubarraySumsDivisibleByK();
		System.out.println(test.subarraysDivByK(new int[] { 4, 5, 0, -2, -3, 1 }, 5));
		System.out.println(test.subarraysDivByK(new int[] { 5 }, 9));
	}

	public int subarraysDivByK(int[] nums, int k) {
		int result = 0;
		int prefix = 0;
		int[] count = new int[k];
		count[0] = 1;
		for (int num : nums) {
			prefix = (prefix + num % k + k) % k;
			result += count[prefix];
			count[prefix]++;
		}
		return result;
	}

}
