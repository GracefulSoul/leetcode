package gracefulsoul.problems;

public class MaxConsecutiveOnes {

	// https://leetcode.com/submissions/detail/696539387/
	public static void main(String[] args) {
		MaxConsecutiveOnes test = new MaxConsecutiveOnes();
		System.out.println(test.findMaxConsecutiveOnes(new int[] { 1, 1, 0, 1, 1, 1 }));
		System.out.println(test.findMaxConsecutiveOnes(new int[] { 1, 0, 1, 1, 0, 1 }));
	}

	public int findMaxConsecutiveOnes(int[] nums) {
		int max = 0;
		int curr = 0;
		for (int num : nums) {
			if (num == 0) {
				max = Math.max(max, curr);
				curr = 0;
			} else {
				curr++;	
			}
		}
		return Math.max(max, curr);
	}

}
