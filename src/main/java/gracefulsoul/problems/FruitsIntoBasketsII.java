package gracefulsoul.problems;

public class FruitsIntoBasketsII {

	// https://leetcode.com/problems/fruits-into-baskets-ii/submissions/1724223950/
	public static void main(String[] args) {
		FruitsIntoBasketsII test = new FruitsIntoBasketsII();
		System.out.println(test.numOfUnplacedFruits(new int[] { 4, 2, 5 }, new int[] { 3, 5, 4 }));
		System.out.println(test.numOfUnplacedFruits(new int[] { 3, 6, 1 }, new int[] { 6, 4, 7 }));
	}

	public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
		int length = fruits.length;
		int result = length;
		for (int i = 0; i < length; i++) {
			for (int j = 0; j < length; j++) {
				if (fruits[i] <= baskets[j]) {
					baskets[j] = 0;
					result--;
					break;
				}
			}
		}
		return result;
	}

}
