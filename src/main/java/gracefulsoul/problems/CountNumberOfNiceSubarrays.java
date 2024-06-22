package gracefulsoul.problems;

public class CountNumberOfNiceSubarrays {

	// https://leetcode.com/problems/count-number-of-nice-subarrays/submissions/1296168597/
	public static void main(String[] args) {
		CountNumberOfNiceSubarrays test = new CountNumberOfNiceSubarrays();
		System.out.println(test.numberOfSubarrays(new int[] { 1, 1, 2, 1, 1 }, 3));
		System.out.println(test.numberOfSubarrays(new int[] { 2, 4, 6 }, 1));
		System.out.println(test.numberOfSubarrays(new int[] { 2, 2, 2, 1, 2, 2, 1, 2, 2, 2 }, 2));
	}

	public int numberOfSubarrays(int[] nums, int k) {
		int result = 0;
		int length = nums.length;
		int curr = 0;
		int[] visited = new int[length + 1];
		visited[0] = 1;
		for (int i = 0; i < length; i++) {
			curr += nums[i] % 2 == 1 ? 1 : 0;
			visited[curr] += 1;
			result += curr >= k ? visited[curr - k] : 0;
		}
		return result;
	}

}
