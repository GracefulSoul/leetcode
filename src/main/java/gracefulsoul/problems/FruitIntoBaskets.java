package gracefulsoul.problems;

public class FruitIntoBaskets {

	// https://leetcode.com/problems/fruit-into-baskets/submissions/936292143/
	public static void main(String[] args) {
		FruitIntoBaskets test = new FruitIntoBaskets();
		System.out.println(test.totalFruit(new int[] { 1, 2, 1 }));
		System.out.println(test.totalFruit(new int[] { 0, 1, 2, 2 }));
		System.out.println(test.totalFruit(new int[] { 1, 2, 3, 2, 2 }));
	}

	public int totalFruit(int[] fruits) {
		int length = fruits.length;
		int start = 0;
		int max = 0;
		int mid = 0;
		int[] baskets = new int[] { -1, -1 };
		for (int end = 0; end < length; end++) {
			int curr = fruits[end];
			if (curr != baskets[1]) {
				if (curr != baskets[0]) {
					max = Math.max(max, end - start);
					start = mid;
				}
				mid = end;
				baskets[0] = baskets[1];
				baskets[1] = curr;
			}
		}
		return Math.max(max, length - start);
	}

}
