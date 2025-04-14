package gracefulsoul.problems;

public class CountGoodTriplets {

	// https://leetcode.com/problems/count-good-triplets/submissions/1606426608/
	public static void main(String[] args) {
		CountGoodTriplets test = new CountGoodTriplets();
		System.out.println(test.countGoodTriplets(new int[] { 3, 0, 1, 1, 9, 7 }, 7, 2, 3));
		System.out.println(test.countGoodTriplets(new int[] { 1, 1, 2, 2, 3 }, 0, 0, 1));
	}

	public int countGoodTriplets(int[] arr, int a, int b, int c) {
		int length = arr.length;
		int result = 0;
		for (int i = 0; i < length - 2; i++) {
			for (int j = i + 1; j < length - 1; j++) {
				if (Math.abs(arr[i] - arr[j]) <= a) {
					for (int k = j + 1; k < length; k++) {
						if (Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c) {
							result++;
						}
					}
				}
			}
		}
		return result;
	}

}
