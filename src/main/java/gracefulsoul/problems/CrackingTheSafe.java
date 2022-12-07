package gracefulsoul.problems;

public class CrackingTheSafe {

	// https://leetcode.com/problems/cracking-the-safe/submissions/855840376/
	public static void main(String[] args) {
		CrackingTheSafe test = new CrackingTheSafe();
		System.out.println(test.crackSafe(1, 2));
		System.out.println(test.crackSafe(2, 2));
	}

	public String crackSafe(int n, int k) {
		int base = (int) Math.pow(k, n - 1);
		int[] nums = new int[base * k];
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < base; j++) {
				nums[(i * base) + j] = (j * k) + i;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < nums.length; i++) {
			int j = i;
			while (nums[j] >= 0) {
				sb.append(j / base);
				int temp = nums[j];
				nums[j] = -1;
				j = temp;
			}
		}
		for (int idx = 0; idx < n - 1; idx++) {
			sb.append("0");
		}
		return sb.reverse().toString();
	}

}
