package gracefulsoul.problems;

public class CountLargestGroup {

	// https://leetcode.com/problems/count-largest-group/submissions/1615556804/
	public static void main(String[] args) {
		CountLargestGroup test = new CountLargestGroup();
		System.out.println(test.countLargestGroup(13));
		System.out.println(test.countLargestGroup(2));
	}

	public int countLargestGroup(int n) {
		int[] counts = new int[37];
		int result = 0;
		int max = 0;
		for (int i = 1; i <= n; i++) {
			int sum = 0;
			for (int x = i; x > 0; x /= 10) {
				sum += x % 10;
			}
			counts[sum]++;
			if (max == counts[sum]) {
				result++;
			} else if (max < counts[sum]) {
				max = counts[sum];
				result = 1;
			}
		}
		return result;
	}

}
