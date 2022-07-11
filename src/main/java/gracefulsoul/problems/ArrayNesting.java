package gracefulsoul.problems;

public class ArrayNesting {

	// https://leetcode.com/submissions/detail/744206000/
	public static void main(String[] args) {
		ArrayNesting test = new ArrayNesting();
		System.out.println(test.arrayNesting(new int[] { 5, 4, 0, 3, 1, 6, 2 }));
		System.out.println(test.arrayNesting(new int[] { 0, 1, 2 }));
	}

	public int arrayNesting(int[] nums) {
		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			int length = 0;
			for (int j = i; nums[j] >= 0; length++) {
				int temp = nums[j];
				nums[j] = -1;
				j = temp;
			}
			max = Math.max(max, length);
		}
		return max;
	}

}
