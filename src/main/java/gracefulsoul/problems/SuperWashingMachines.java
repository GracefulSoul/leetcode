package gracefulsoul.problems;

public class SuperWashingMachines {

	// https://leetcode.com/submissions/detail/713086167/
	public static void main(String[] args) {
		SuperWashingMachines test = new SuperWashingMachines();
		System.out.println(test.findMinMoves(new int[] { 1, 0, 5 }));
		System.out.println(test.findMinMoves(new int[] { 0, 3, 0 }));
		System.out.println(test.findMinMoves(new int[] { 0, 2, 0 }));
	}

	public int findMinMoves(int[] machines) {
		int total = 0;
		int length = machines.length;
		for (int machine : machines) {
			total += machine;
		}
		if (total % length != 0) {
			return -1;
		}
		int avg = total / length;
		int count = 0;
		int max = 0;
		int diff = 0;
		for (int machine : machines) {
			diff = machine - avg;
			count += diff;
			max = Math.max(Math.max(max, Math.abs(count)), diff);
		}
		return max;
	}

}
