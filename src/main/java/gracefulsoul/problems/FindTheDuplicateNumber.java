package gracefulsoul.problems;

public class FindTheDuplicateNumber {

	// https://leetcode.com/submissions/detail/597633320/
	public static void main(String[] args) {
		FindTheDuplicateNumber test = new FindTheDuplicateNumber();
		System.out.println(test.findDuplicate(new int[] { 1, 3, 4, 2, 2 }));
		System.out.println(test.findDuplicate(new int[] { 3, 1, 3, 4, 2 }));
		System.out.println(test.findDuplicate(new int[] { 1, 1 }));
		System.out.println(test.findDuplicate(new int[] { 1, 1, 2 }));
	}

	public int findDuplicate(int[] nums) {
		int memory[] = new int[nums.length];
		for (int num : nums) {
			memory[num]++;
		}
		for (int num : nums) {
			if (memory[num] > 1) {
				return num;
			}
		}
		return -1;
	}

}
