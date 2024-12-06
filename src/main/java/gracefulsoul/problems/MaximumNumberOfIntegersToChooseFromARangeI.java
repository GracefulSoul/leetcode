package gracefulsoul.problems;

public class MaximumNumberOfIntegersToChooseFromARangeI {

	// https://leetcode.com/problems/maximum-number-of-integers-to-choose-from-a-range-i/submissions/1471695459/
	public static void main(String[] args) {
		MaximumNumberOfIntegersToChooseFromARangeI test = new MaximumNumberOfIntegersToChooseFromARangeI();
		System.out.println(test.maxCount(new int[] { 1, 6, 5 }, 5, 6));
		System.out.println(test.maxCount(new int[] { 1, 2, 3, 4, 5, 6, 7 }, 8, 1));
		System.out.println(test.maxCount(new int[] { 11 }, 7, 50));
	}

	public int maxCount(int[] banned, int n, int maxSum) {
		boolean[] ban = new boolean[10001];
		for (int num : banned) {
			ban[num] = true;
		}
		long sum = 0;
		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			if (!ban[i]) {
				sum += i;
				if (sum > maxSum) {
					break;
				}
				cnt++;
			}
		}
		return cnt;
	}

}
