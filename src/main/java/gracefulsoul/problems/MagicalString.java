package gracefulsoul.problems;

public class MagicalString {

	// https://leetcode.com/submissions/detail/695418469/
	public static void main(String[] args) {
		MagicalString test = new MagicalString();
		System.out.println(test.magicalString(6));
		System.out.println(test.magicalString(1));
	}

	public int magicalString(int n) {
		int fast = 1;
		int slow = 1;
		int num = 1;
		int[] nums = new int[n + 2];
		while (fast <= n) {
			nums[fast++] = num;
			if (nums[slow++] == 2) {
				nums[fast++] = num;
			}
			num = 3 - num;
		}
		int count = 0;
		for (int idx = 1; idx <= n; idx++) {
			if (nums[idx] == 1) {
				count++;
			}
		}
		return count;
	}

}
