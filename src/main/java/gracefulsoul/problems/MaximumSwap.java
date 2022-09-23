package gracefulsoul.problems;

public class MaximumSwap {

	// https://leetcode.com/submissions/detail/806751825/
	public static void main(String[] args) {
		MaximumSwap test = new MaximumSwap();
		System.out.println(test.maximumSwap(2736));
		System.out.println(test.maximumSwap(9973));
	}

	public int maximumSwap(int num) {
		char[] numCharArray = Integer.toString(num).toCharArray();
		int length = numCharArray.length;
		int[] nums = new int[10];
		for (int idx = 0; idx < length; idx++) {
			nums[numCharArray[idx] - '0'] = idx;
		}
		for (int i = 0; i < length; i++) {
			for (int j = 9; j > numCharArray[i] - '0'; j--) {
				if (nums[j] > i) {
					char temp = numCharArray[i];
					numCharArray[i] = numCharArray[nums[j]];
					numCharArray[nums[j]] = temp;
					return Integer.valueOf(new String(numCharArray));
				}
			}
		}
		return num;
	}

}
