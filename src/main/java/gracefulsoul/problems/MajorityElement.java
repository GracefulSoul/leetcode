package gracefulsoul.problems;

public class MajorityElement {

	// https://leetcode.com/submissions/detail/557737861/
	public static void main(String[] args) {
		MajorityElement test = new MajorityElement();
		System.out.println(test.majorityElement(new int[] { 3, 2, 3 }));
		System.out.println(test.majorityElement(new int[] { 2, 2, 1, 1, 1, 2, 2 }));
	}

	public int majorityElement(int[] nums) {
		int result = 0;
		int count = 0;
		for (int num : nums) {
			if (count == 0) {
				result = num;
			}
			if (num != result) {
				count--;
			} else {
				count++;
			}
		}
		return result;
	}

}
