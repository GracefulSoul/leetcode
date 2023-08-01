package gracefulsoul.problems;

public class LeastOperatorsToExpressNumber {

	// https://leetcode.com/problems/least-operators-to-express-number/submissions/1009308375/
	public static void main(String[] args) {
		LeastOperatorsToExpressNumber test = new LeastOperatorsToExpressNumber();
		System.out.println(test.leastOpsExpressTarget(3, 19));
		System.out.println(test.leastOpsExpressTarget(5, 501));
		System.out.println(test.leastOpsExpressTarget(100, 100000000));
	}

	public int leastOpsExpressTarget(int x, int target) {
		int[] nums = new int[2];
		int i = 0;
		while (target > 0) {
			int curr = target % x;
			target /= x;
			if (i > 0) {
				nums = new int[] {
					Math.min((curr * i) + nums[0], ((curr + 1) * i) + nums[1]),
					Math.min(((x - curr) * i) + nums[0], ((x - curr - 1) * i) + nums[1])
				};
			} else {
				nums[0] = curr * 2;
				nums[1] = (x - curr) * 2;
			}
			i++;
		}
		return Math.min(nums[0], i + nums[1]) - 1;
	}

}
