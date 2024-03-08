package gracefulsoul.problems;

public class CountElementsWithMaximumFrequency {

	// https://leetcode.com/problems/count-elements-with-maximum-frequency/submissions/1197528066/
	public static void main(String[] args) {
		CountElementsWithMaximumFrequency test = new CountElementsWithMaximumFrequency();
		System.out.println(test.maxFrequencyElements(new int[] { 1, 2, 2, 3, 1, 4 }));
		System.out.println(test.maxFrequencyElements(new int[] { 1, 2, 3, 4, 5 }));
	}

	public int maxFrequencyElements(int[] nums) {
		int[] count = new int[101];
		int max = 0;
		for (int num : nums) {
			count[num]++;
			if (count[num] > max) {
				max = count[num];
			}
		}
		int result = 0;
		for (int num : nums) {
			if (max == count[num]) {
				result += count[num]--;
			}
		}
		return result;
	}

}
