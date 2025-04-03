package gracefulsoul.problems;

public class MaximumValueOfAnOrderedTripletII {

	// https://leetcode.com/problems/maximum-value-of-an-ordered-triplet-ii/submissions/1595376618/
	public static void main(String[] args) {
		MaximumValueOfAnOrderedTripletII test = new MaximumValueOfAnOrderedTripletII();
		System.out.println(test.maximumTripletValue(new int[] { 12, 6, 1, 2, 7 }));
		System.out.println(test.maximumTripletValue(new int[] { 1, 10, 3, 4, 19 }));
		System.out.println(test.maximumTripletValue(new int[] { 1, 2, 3 }));
	}

	public long maximumTripletValue(int[] nums) {
		long result = 0;
		long diff = 0;
		long max = 0;
		for (int num : nums) {
			result = Math.max(result, 1L * diff * num);
			diff = Math.max(diff, max - num);
			max = Math.max(max, num);
		}
		return result;
	}

}
