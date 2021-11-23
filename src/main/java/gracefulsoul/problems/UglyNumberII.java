package gracefulsoul.problems;

public class UglyNumberII {

	// https://leetcode.com/submissions/detail/591458097/
	public static void main(String[] args) {
		UglyNumberII test = new UglyNumberII();
		System.out.println(test.nthUglyNumber(10));
		System.out.println(test.nthUglyNumber(1));
	}

	public int nthUglyNumber(int n) {
		int[] nums = new int[n];
		nums[0] = 1;
		int index2 = 0;
		int index3 = 0;
		int index5 = 0;
		int factor2 = 2;
		int factor3 = 3;
		int factor5 = 5;
		int min = 1;
		for (int idx = 1; idx < n; idx++) {
			nums[idx] = min = Math.min(Math.min(factor2, factor3), factor5);
			if (min == factor2) {
				factor2 = nums[++index2] * 2;
			}
			if (min == factor3) {
				factor3 = nums[++index3] * 3;
			}
			if (min == factor5) {
				factor5 = nums[++index5] * 5;
			}
		}
		return min;
	}

}
