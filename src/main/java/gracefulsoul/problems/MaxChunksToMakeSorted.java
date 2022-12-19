package gracefulsoul.problems;

public class MaxChunksToMakeSorted {

	// https://leetcode.com/problems/max-chunks-to-make-sorted/submissions/861883538/
	public static void main(String[] args) {
		MaxChunksToMakeSorted test = new MaxChunksToMakeSorted();
		System.out.println(test.maxChunksToSorted(new int[] { 4, 3, 2, 1, 0 }));
		System.out.println(test.maxChunksToSorted(new int[] { 1, 0, 2, 3, 4 }));
	}

	public int maxChunksToSorted(int[] arr) {
		int max = 0;
		int result = 0;
		for (int idx = 0; idx < arr.length; idx++) {
			max = Math.max(max, arr[idx]);
			if (max == idx) {
				result++;
			}
		}
		return result;
	}

}
