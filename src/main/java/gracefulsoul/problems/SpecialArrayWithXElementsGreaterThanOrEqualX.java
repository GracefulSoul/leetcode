package gracefulsoul.problems;

public class SpecialArrayWithXElementsGreaterThanOrEqualX {

	// https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/submissions/1269264215/
	public static void main(String[] args) {
		SpecialArrayWithXElementsGreaterThanOrEqualX test = new SpecialArrayWithXElementsGreaterThanOrEqualX();
		System.out.println(test.specialArray(new int[] { 3, 5 }));
		System.out.println(test.specialArray(new int[] { 0, 0 }));
		System.out.println(test.specialArray(new int[] { 0, 4, 3, 0, 4 }));
	}

	public int specialArray(int[] nums) {
		int length = nums.length;
		int[] counts = new int[length + 1];
		for (int num : nums) {
			if (num >= length) {
				counts[length]++;
			} else {
				counts[num]++;
			}
		}
		int result = 0;
		for (int i = length; i > 0; i--) {
			result += counts[i];
			if (result == i) {
				return i;
			}
		}
		return -1;
	}

}
