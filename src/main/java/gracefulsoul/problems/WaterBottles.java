package gracefulsoul.problems;

public class WaterBottles {

	// https://leetcode.com/problems/water-bottles/submissions/1312930745/
	public static void main(String[] args) {
		WaterBottles test = new WaterBottles();
		System.out.println(test.numWaterBottles(9, 3));
		System.out.println(test.numWaterBottles(15, 4));
	}

	public int numWaterBottles(int numBottles, int numExchange) {
		int result = numBottles;
		while (numBottles >= numExchange) {
			int newBottles = numBottles / numExchange;
			result += newBottles;
			numBottles = (numBottles % numExchange) + newBottles;
		}
		return result;
	}

}
