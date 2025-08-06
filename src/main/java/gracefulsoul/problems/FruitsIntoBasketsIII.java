package gracefulsoul.problems;

public class FruitsIntoBasketsIII {

	// https://leetcode.com/problems/fruits-into-baskets-iii/submissions/1725597080/
	public static void main(String[] args) {
		FruitsIntoBasketsIII test = new FruitsIntoBasketsIII();
		System.out.println(test.numOfUnplacedFruits(new int[] { 4, 2, 5 }, new int[] { 3, 5, 4 }));
		System.out.println(test.numOfUnplacedFruits(new int[] { 3, 6, 1 }, new int[] { 6, 4, 7 }));
	}

	public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
		int length = baskets.length;
		int limit = 1;
		while (limit <= length) {
			limit <<= 1;
		}
		int[] segmentTree = new int[limit << 1];
		for (int i = 0; i < length; i++) {
			segmentTree[limit + i] = baskets[i];
		}
		for (int i = limit - 1; i > 0; i--) {
			segmentTree[i] = Math.max(segmentTree[2 * i], segmentTree[2 * i + 1]);
		}
		int count = 0;
		for (int i = 0; i < length; i++) {
			int x = fruits[i];
			int index = 1;
			if (segmentTree[index] < x) {
				count++;
				continue;
			}
			while (index < limit) {
				index = index * 2;
				if (segmentTree[index] < x) {
					index++;
				}
			}
			segmentTree[index] = -1;
			while (index > 1) {
				index >>= 1;
				segmentTree[index] = Math.max(segmentTree[2 * index], segmentTree[2 * index + 1]);
			}
		}
		return count;
	}

}
