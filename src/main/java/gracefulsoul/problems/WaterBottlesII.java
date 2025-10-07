package gracefulsoul.problems;

public class WaterBottlesII {

	// https://leetcode.com/problems/water-bottles-ii/submissions/1789661396/
	public static void main(String[] args) {
		WaterBottlesII test = new WaterBottlesII();
		System.out.println(test.maxBottlesDrunk(13, 6));
		System.out.println(test.maxBottlesDrunk(10, 3));
	}

	public int maxBottlesDrunk(int numBottles, int numExchange) {
		int result = numBottles;
		while (numBottles >= numExchange) {
			numBottles -= numExchange - 1;
			numExchange++;
			result++;
		}
		return result;
	}

}
