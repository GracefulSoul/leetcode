package gracefulsoul.problems;

public class ElementAppearingMoreThan25PercentInSortedArray {

	// https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/submissions/1741844368/
	public static void main(String[] args) {
		ElementAppearingMoreThan25PercentInSortedArray test = new ElementAppearingMoreThan25PercentInSortedArray();
		System.out.println(test.findSpecialInteger(new int[] { 1, 2, 2, 6, 6, 6, 6, 7, 10 }));
		System.out.println(test.findSpecialInteger(new int[] { 1, 1 }));
	}

	public int findSpecialInteger(int[] arr) {
		int length = arr.length;
		int half = length / 4;
		for (int i = 0; i < length - half; i++) {
			if (arr[i] == arr[i + half]) {
				return arr[i];
			}
		}
		return -1;
	}

}
