package gracefulsoul.problems;

public class WaterAndJugProblem {

	// https://leetcode.com/submissions/detail/629922027/
	public static void main(String[] args) {
		WaterAndJugProblem test = new WaterAndJugProblem();
		System.out.println(test.canMeasureWater(3, 5, 4));
		System.out.println(test.canMeasureWater(2, 6, 5));
		System.out.println(test.canMeasureWater(1, 2, 3));
	}

	public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
		if (jug1Capacity + jug2Capacity < targetCapacity) {
			return false;
		} else if (jug1Capacity == targetCapacity
				|| jug2Capacity == targetCapacity
				|| jug1Capacity + jug2Capacity == targetCapacity) {
			return true;
		} else {
			return targetCapacity % this.getGcd(jug1Capacity, jug2Capacity) == 0;
		}
	}

	private int getGcd(int num1, int num2) {
		if (num1 % num2 == 0) {
			return num2;
		} else {
			return this.getGcd(num2, num1 % num2);
		}
	}

}
