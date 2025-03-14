package gracefulsoul.problems;

public class MaximumCandiesAllocatedToKChildren {

	// https://leetcode.com/problems/maximum-candies-allocated-to-k-children/submissions/1573347732/?envType=daily-question&envId=2025-03-14
	public static void main(String[] args) {
		MaximumCandiesAllocatedToKChildren test = new MaximumCandiesAllocatedToKChildren();
		System.out.println(test.maximumCandies(new int[] { 5, 8, 6 }, 3));
		System.out.println(test.maximumCandies(new int[] { 2, 5 }, 11));
	}

	public int maximumCandies(int[] candies, long k) {
		long total = 0;
		for (int candy : candies) {
			total += candy;
		}
		int result = 0;
		int left = 1;
		int right = (int) (total / k);
		if (right != 0) {
			while (left <= right) {
				int mid = left + (right - left) / 2;
				long sum = 0;
				for (int candy : candies) {
					sum += candy / mid;
				}
				if (k <= sum) {
					left = mid + 1;
					result = Math.max(result, mid);
				} else {
					right = mid - 1;
				}
			}
		}
		return result;
	}

}
