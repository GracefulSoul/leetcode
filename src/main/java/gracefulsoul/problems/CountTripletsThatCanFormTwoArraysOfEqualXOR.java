package gracefulsoul.problems;

public class CountTripletsThatCanFormTwoArraysOfEqualXOR {

	// https://leetcode.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/submissions/1273151764/
	public static void main(String[] args) {
		CountTripletsThatCanFormTwoArraysOfEqualXOR test = new CountTripletsThatCanFormTwoArraysOfEqualXOR();
		System.out.println(test.countTriplets(new int[] { 2, 3, 1, 6, 7 }));
		System.out.println(test.countTriplets(new int[] { 1, 1, 1, 1, 1 }));
	}

	public int countTriplets(int[] arr) {
		int result = 0;
		int length = arr.length;
		for (int i = 0; i < length; i++) {
			int temp = arr[i];
			for (int j = i + 1; j < length; j++) {
				temp ^= arr[j];
				if (temp == 0) {
					result += (j - i);
				}
			}
		}
		return result;
	}

}
