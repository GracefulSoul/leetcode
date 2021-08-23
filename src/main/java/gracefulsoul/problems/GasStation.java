package gracefulsoul.problems;

public class GasStation {

	// https://leetcode.com/submissions/detail/542674987/
	public static void main(String[] args) {
		GasStation test = new GasStation();
		System.out.println(test.canCompleteCircuit(new int[] { 1, 2, 3, 4, 5 }, new int[] { 3, 4, 5, 1, 2 }));
		System.out.println(test.canCompleteCircuit(new int[] { 2, 3, 4 }, new int[] { 3, 4, 3 }));
	}

	public int canCompleteCircuit(int[] gas, int[] cost) {
		int fill = 0;
		int use = 0;
		int tank = 0;
		int start = 0;
		for (int idx = 0; idx < gas.length; idx++) {
			fill += gas[idx];
			use += cost[idx];
			tank += gas[idx] - cost[idx];
			if (tank < 0) {
				tank = 0;
				start = idx + 1;
			}
		}
		return fill < use ? -1 : start;
	}

}
