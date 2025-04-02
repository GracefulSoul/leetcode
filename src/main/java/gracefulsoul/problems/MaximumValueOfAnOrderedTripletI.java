package gracefulsoul.problems;

public class MaximumValueOfAnOrderedTripletI {

	// https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-i/submissions/1594169690/
	public static void main(String[] args) {
		MaximumValueOfAnOrderedTripletI test = new MaximumValueOfAnOrderedTripletI();
		System.out.println(test.maximumTripletValue(new int[] { 12, 6, 1, 2, 7 }));
		System.out.println(test.maximumTripletValue(new int[] { 1, 10, 3, 4, 19 }));
		System.out.println(test.maximumTripletValue(new int[] { 1, 2, 3 }));
	}

	public long maximumTripletValue(int[] nums) {
		long result = 0;
		int diff = 0;
		int max = 0;
		for (int num : nums) {
			result = Math.max(result, 1L * diff * num);
			diff = Math.max(diff, max - num);
			max = Math.max(max, num);
		}
		return result;
	}

}
