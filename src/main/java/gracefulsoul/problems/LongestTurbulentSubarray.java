package gracefulsoul.problems;

public class LongestTurbulentSubarray {

	// https://leetcode.com/problems/longest-turbulent-subarray/submissions/1027498967/
	public static void main(String[] args) {
		LongestTurbulentSubarray test = new LongestTurbulentSubarray();
		System.out.println(test.maxTurbulenceSize(new int[] { 9, 4, 2, 10, 7, 8, 8, 1, 9 }));
		System.out.println(test.maxTurbulenceSize(new int[] { 4, 8, 12, 16 }));
		System.out.println(test.maxTurbulenceSize(new int[] { 100 }));
	}

	public int maxTurbulenceSize(int[] arr) {
		int result = 0;
		for (int i = 0, count = 0; i < arr.length - 1; i++, count *= -1) {
			if (arr[i] > arr[i + 1]) {
				count = count > 0 ? count + 1 : 1;
			} else if (arr[i] < arr[i + 1]) {
				count = count < 0 ? count - 1 : -1;
			} else {
				count = 0;
			}
			result = Math.max(result, Math.abs(count));
		}
		return result + 1;
	}

}
