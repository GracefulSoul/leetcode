package gracefulsoul.problems;

public class CouplesHoldingHands {

	// https://leetcode.com/problems/couples-holding-hands/submissions/860441462/
	public static void main(String[] args) {
		CouplesHoldingHands test = new CouplesHoldingHands();
		System.out.println(test.minSwapsCouples(new int[] { 0, 2, 1, 3 }));
		System.out.println(test.minSwapsCouples(new int[] { 3, 2, 0, 1 }));
	}

	public int minSwapsCouples(int[] row) {
		int length = row.length;
		int[] partner = new int[length];
		int[] position = new int[length];
		for (int i = 0; i < length; i++) {
			partner[i] = i % 2 == 0 ? i + 1 : i - 1;
			position[row[i]] = i;
		}
		int result = 0;
		for (int i = 0; i < length; i += 2) {
			int j = i + 1;
			if (row[j] != partner[row[i]]) {
				j = position[partner[row[i]]];
				this.swap(row, i + 1, j);
				this.swap(position, row[i + 1], row[j]);
				result++;
			}
		}
		return result;
	}

	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
