package gracefulsoul.problems;

public class NumberOfSubarraysWithOddSum {

	// https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum/submissions/1554386465/
	public static void main(String[] args) {
		NumberOfSubarraysWithOddSum test = new NumberOfSubarraysWithOddSum();
		System.out.println(test.numOfSubarrays(new int[] { 1, 3, 5 }));
		System.out.println(test.numOfSubarrays(new int[] { 2, 4, 6 }));
		System.out.println(test.numOfSubarrays(new int[] { 1, 2, 3, 4, 5, 6, 7 }));
	}

	public int numOfSubarrays(int[] arr) {
		int result = 0;
		int odd = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 1) {
				odd = i - odd + 1;
			}
			result = (result + odd) % 1000000007;
		}
		return result;
	}

}
