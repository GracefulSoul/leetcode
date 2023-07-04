package gracefulsoul.problems;

public class ValidMountainArray {

	// https://leetcode.com/problems/valid-mountain-array/submissions/986026006/
	public static void main(String[] args) {
		ValidMountainArray test = new ValidMountainArray();
		System.out.println(test.validMountainArray(new int[] { 2, 1 }));
		System.out.println(test.validMountainArray(new int[] { 3, 5, 5 }));
		System.out.println(test.validMountainArray(new int[] { 0, 3, 2, 1 }));
	}

	public boolean validMountainArray(int[] arr) {
		if (arr.length < 3 || arr[0] >= arr[1]) {
			return false;
		}
		boolean decrease = false;
		for (int i = 2; i < arr.length; i++) {
			if (arr[i - 1] > arr[i]) {
				decrease = true;
			} else if (arr[i - 1] == arr[i] || decrease) {
				return false;
			}
		}
		return decrease;
	}

}
