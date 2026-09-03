package gracefulsoul.problems;

public class ConstructUniformParityArrayII {

	// https://leetcode.com/problems/construct-uniform-parity-array-ii/submissions/2129574035/
	public static void main(String[] args) {
		ConstructUniformParityArrayII test = new ConstructUniformParityArrayII();
		System.out.println(test.uniformArray(new int[] { 1, 4, 7 }));
		System.out.println(test.uniformArray(new int[] { 2, 3 }));
		System.out.println(test.uniformArray(new int[] { 4, 6 }));
	}

	public boolean uniformArray(int[] nums1) {
		int min = nums1[0];
		int odd = 0;
		for (int num : nums1) {
			min = Math.min(min, num);
			odd |= num & 1;
		}
		return (min & 1) == odd;
	}

}
