package gracefulsoul.problems;

public class CanMakeArithmeticProgressionFromSequence {

	// https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/submissions/964770392/
	public static void main(String[] args) {
		CanMakeArithmeticProgressionFromSequence test = new CanMakeArithmeticProgressionFromSequence();
		System.out.println(test.canMakeArithmeticProgression(new int[] { 3, 5, 1 }));
		System.out.println(test.canMakeArithmeticProgression(new int[] { 1, 2, 4 }));
	}

	public boolean canMakeArithmeticProgression(int[] arr) {
		int length = arr.length;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int num : arr) {
			min = Math.min(min, num);
			max = Math.max(max, num);
		}
		int diff = max - min;
		if (diff % (length - 1) != 0) {
			return false;
		}
		diff /= length - 1;
		for (int i = 0; i < length;) {
			int num = arr[i] - min;
			if (num == diff * i) {
				i++;
			} else if (num % diff != 0) {
				return false;
			} else {
				int position = num / diff;
				if (position < i || arr[position] == arr[i]) {
					return false;
				}
				int temp = arr[position];
				arr[position] = arr[i];
				arr[i] = temp;
			}
		}
		return true;
	}

}
