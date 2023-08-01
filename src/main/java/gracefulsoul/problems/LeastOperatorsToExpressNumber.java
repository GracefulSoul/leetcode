package gracefulsoul.problems;

public class LeastOperatorsToExpressNumber {

	// https://leetcode.com/problems/least-operators-to-express-number/submissions/1009280862/
	public static void main(String[] args) {
		LeastOperatorsToExpressNumber test = new LeastOperatorsToExpressNumber();
		System.out.println(test.leastOpsExpressTarget(3, 19));
		System.out.println(test.leastOpsExpressTarget(5, 501));
		System.out.println(test.leastOpsExpressTarget(100, 100000000));
	}

	public int leastOpsExpressTarget(int x, int target) {
		int[] position = new int[2];
		int i = 0;
		while (target > 0) {
			int curr = target % x;
			target /= x;
			if (i > 0) {
				position = new int[] {
					Math.min((curr * i) + position[0], ((curr + 1) * i) + position[1]),
					Math.min(((x - curr) * i) + position[0], ((x - curr - 1) * i) + position[1])
				};
			} else {
				position[0] = curr * 2;
				position[1] = (x - curr) * 2;
			}
			i++;
		}
		return Math.min(position[0], i + position[1]) - 1;
	}

}
