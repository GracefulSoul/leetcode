package gracefulsoul.problems;

public class BeautifulArrangement {

	// https://leetcode.com/submissions/detail/720041722/
	public static void main(String[] args) {
		BeautifulArrangement test = new BeautifulArrangement();
		System.out.println(test.countArrangement(2));
		System.out.println(test.countArrangement(1));
	}

	public int countArrangement(int n) {
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = i + 1;
		}
		return this.recursive(array, n - 1);
	}

	private int recursive(int[] array, int index) {
		if (index == 0) {
			return 1;
		}
		int count = 0;
		for (int i = index; i >= 0; i--) {
			this.swap(array, index, i);
			int num = index + 1;
			if (array[index] % num == 0 || num % array[index] == 0) {
				count += this.recursive(array, index - 1);
			}
			this.swap(array, index, i);
		}
		return count;
	}

	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

}
