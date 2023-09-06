package gracefulsoul.problems;

import java.util.LinkedList;
import java.util.List;

public class AddToArrayFormOfInteger {

	// https://leetcode.com/problems/add-to-array-form-of-integer/submissions/1042011101/
	public static void main(String[] args) {
		AddToArrayFormOfInteger test = new AddToArrayFormOfInteger();
		System.out.println(test.addToArrayForm(new int[] { 1, 2, 0, 0 }, 34));
		System.out.println(test.addToArrayForm(new int[] { 2, 7, 4 }, 181));
		System.out.println(test.addToArrayForm(new int[] { 2, 1, 5 }, 806));
	}

	public List<Integer> addToArrayForm(int[] num, int k) {
		LinkedList<Integer> result = new LinkedList<>();
		int length = num.length - 1;
		while (length >= 0 || k != 0) {
			if (length >= 0) {
				k += num[length--];
			}
			result.addFirst(k % 10);
			k /= 10;
		}
		return result;
	}

}
